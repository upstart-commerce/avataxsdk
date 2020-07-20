/* Copyright 2019 UpStart Commerce, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.upstartcommerce.avataxsdk.json

import play.api.libs.json._

import shapeless._
import shapeless.labelled._

/** defines generic derivation of formats */
private[json] trait Derivation {

  /** derive json for 0-arity AST */
  /** witness that it's enum (sealed trait with case objects) */
  trait IsEnum[C <: Coproduct] {
    def to(c: C): String
    def from(s: String): Option[C]
  }

  object IsEnum {
    implicit val cnilIsEnum: IsEnum[CNil] = new IsEnum[CNil] {
      def to(c: CNil): String = sys.error("Impossible")
      def from(s: String): Option[CNil] = None
    }

    implicit def cconsIsEnum[K <: Symbol, H <: Product, T <: Coproduct](
        implicit
        witK: Witness.Aux[K],
        witH: Witness.Aux[H],
        gen: Generic.Aux[H, HNil],
        tie: IsEnum[T]
    ): IsEnum[FieldType[K, H] :+: T] = new IsEnum[FieldType[K, H] :+: T] {
      def to(c: FieldType[K, H] :+: T): String = c match {
        case Inl(_) => witK.value.name
        case Inr(t) => tie.to(t)
      }
      def from(s: String): Option[FieldType[K, H] :+: T] =
        if (s == witK.value.name) Some(Inl(field[K](witH.value)))
        else tie.from(s).map(Inr(_))
    }
  }

  implicit def encodeEnum[A, C <: Coproduct](
      implicit
      w: Writes[String],
      gen: LabelledGeneric.Aux[A, C],
      rie: IsEnum[C]
  ): Writes[A] = { o: A =>
    w.writes(rie.to(gen.to(o)))
  }

  implicit def decodeEnum[A, C <: Coproduct](
      implicit
      gen: LabelledGeneric.Aux[A, C],
      rie: IsEnum[C]
  ): Reads[A] = { json: JsValue =>
    json.validate[String].flatMap { s =>
      rie.from(s).map(gen.from) match {
        case Some(x) => JsSuccess(x)
        case None => JsError(s"unable to decode $s")
      }
    }
  }
}
