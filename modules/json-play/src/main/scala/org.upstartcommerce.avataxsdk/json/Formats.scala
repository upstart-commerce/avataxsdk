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

import org.upstartcommerce.avataxsdk.core.data.FetchResult
import play.api.libs.json._
import play.api.libs.functional.syntax._

import java.time.format.DateTimeFormatter
import java.time.{Instant, LocalDate, LocalDateTime, ZoneOffset}
import scala.util.Try

private[json] trait Formats {

  implicit val instantReads = Reads[Instant] {
    _.validate[String].flatMap[Instant] { tsString =>
      // https://developer.avalara.com/avatax/errors/DateFormatError/
      Try {
        LocalDateTime.parse(tsString, DateTimeFormatter.ISO_LOCAL_DATE_TIME).toInstant(ZoneOffset.UTC)
      }.orElse {
        Try {
          LocalDate.parse(tsString, DateTimeFormatter.ISO_DATE).atStartOfDay(ZoneOffset.UTC).toInstant
        }
      } match {
        case scala.util.Success(value) => JsSuccess(value)
        case scala.util.Failure(value) => JsError(s"Wrong format for: ${tsString}, error: ${value.getMessage}")
      }
    }
  }

  implicit def recordSetOFormat[A](implicit f: Format[List[A]]): OFormat[FetchResult[A]] = new FetchResultFormat[A]
}

sealed private class FetchResultFormat[A](implicit f: Format[List[A]]) extends OFormat[FetchResult[A]] {
  private val rsS = "@recordsetCount"
  private val valueS = "value"
  private val nextLinkS = "@nextLink"

  override def writes(o: FetchResult[A]): JsObject =
    JsObject(Seq(rsS -> JsNumber(o.recordSetCount), valueS -> f.writes(o.value)))

  override def reads(json: JsValue): JsResult[FetchResult[A]] = {
    val value = (json \ valueS).validate[List[A]]
    val recordSetCount = (json \ rsS).validate[Int]
    val nextLink = (json \ nextLinkS).validateOpt[String]
    recordSetCount.and(value).and(nextLink).tupled.map {
      case (v, r, nl) => FetchResult(v, r, nl)
    }
  }
}
