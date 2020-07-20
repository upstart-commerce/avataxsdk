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

package org.upstartcommerce.avataxsdk.core.data

/** Based on: https://developer.com/avatax/filtering-in-rest */
sealed trait FilterAst
final case class Bracket(value: FilterAst) extends FilterAst

/** escape the AST, embedding raw string. Useful in case it's discovered that some op is not supported by AST,
  * or is wrongly typed, clients can still use unsafe escape. */
final case class UntypedFilter(value: String) extends FilterAst

sealed trait AstValue extends FilterAst
final case class FieldAccess(name: String) extends AstValue
final case class Literal(value: String) extends AstValue

sealed trait Conditional extends FilterAst
final case class EQ(lhs: FieldAccess, rhs: FilterAst) extends Conditional
final case class NE(lhs: FieldAccess, rhs: FilterAst) extends Conditional
final case class GT(lhs: FieldAccess, rhs: FilterAst) extends Conditional
final case class GE(lhs: FieldAccess, rhs: FilterAst) extends Conditional
final case class LT(lhs: FieldAccess, rhs: FilterAst) extends Conditional
final case class LE(lhs: FieldAccess, rhs: FilterAst) extends Conditional

sealed trait Conjunction extends FilterAst
final case class Or(lhs: FilterAst, rhs: FilterAst) extends Conjunction
final case class And(lhs: FilterAst, rhs: FilterAst) extends Conjunction

sealed trait AvalaraSpecific extends FilterAst
final case class Between(lhs: FieldAccess, inclusiveFirst: Literal, exclusiveLast: Literal) extends FilterAst
final case class In(lhs: FieldAccess, values: Set[AstValue]) extends FilterAst
final case class Contains(lhs: FieldAccess, filterString: AstValue) extends FilterAst
final case class StartsWith(lhs: FieldAccess, filterString: AstValue) extends FilterAst
final case class EndsWith(lhs: FieldAccess, filterString: AstValue) extends FilterAst
final case class IsNull(lhs: FieldAccess) extends FilterAst
final case class IsNotNull(lhs: FieldAccess) extends FilterAst

object FilterAst {

  def serialize(ast: FilterAst): String = {
    def quote(s: String): String = s.replaceAll("'", "''")
    ast match {
      case Bracket(bracket) => s"(${serialize(bracket)})"
      case FieldAccess(name) => name
      case UntypedFilter(value) => value
      case Literal(value) => s"'${quote(value)}'"

      case EQ(lhs, rhs) => s"${serialize(lhs)} eq ${serialize(rhs)}"
      case NE(lhs, rhs) => s"${serialize(lhs)} ne ${serialize(rhs)}"
      case GT(lhs, rhs) => s"${serialize(lhs)} gt ${serialize(rhs)}"
      case GE(lhs, rhs) => s"${serialize(lhs)} ge ${serialize(rhs)}"
      case LT(lhs, rhs) => s"${serialize(lhs)} lt ${serialize(rhs)}"
      case LE(lhs, rhs) => s"${serialize(lhs)} le ${serialize(rhs)}"

      case Or(lhs, rhs) => s"${serialize(lhs)} or ${serialize(rhs)}"
      case And(lhs, rhs) => s"${serialize(lhs)} and ${serialize(rhs)}"

      case Between(lhs, inclusiveFirst, exclusiveLast) =>
        s"${serialize(lhs)} between ${serialize(inclusiveFirst)} and ${serialize(exclusiveLast)}"
      case In(lhs, values) => s"${serialize(lhs)} in ${values.mkString("(", ",", ")")}"
      case Contains(lhs, value) => s"${serialize(lhs)} contains ${serialize(value)}"
      case StartsWith(lhs, value) => s"${serialize(lhs)} startswith ${serialize(value)}"
      case EndsWith(lhs, value) => s"${serialize(lhs)} endswith ${serialize(value)}"
      case IsNull(lhs) => s"${serialize(lhs)} is null"
      case IsNotNull(lhs) => s"${serialize(lhs)} is not null"
    }
  }

  object syntax {
    implicit final class FilterAccessSyntax(private val node: FilterAst) extends AnyVal {
      def and(other: FilterAst): Conjunction = And(node, other)
      def &&(other: FilterAst): Conjunction = and(other)
      def or(other: FilterAst): Conjunction = Or(node, other)
      def ||(other: FilterAst): Conjunction = or(other)

      /** puts this statement into brackets */
      def bracket: Bracket = Bracket(node)
    }

    implicit final class FieldAccessSyntax(private val node: FieldAccess) extends AnyVal {
      def ===(other: FilterAst): EQ = EQ(node, other)
      def <>(other: FilterAst): NE = NE(node, other)
      def !==(other: FilterAst): NE = <>(other)
      def >=(other: FilterAst): GE = GE(node, other)
      def >(other: FilterAst): GT = GT(node, other)
      def <=(other: FilterAst): LE = LE(node, other)
      def <(other: FilterAst): LT = LT(node, other)

      def between(inclusiveFirst: Literal, exclusiveLast: Literal): Between =
        Between(node, inclusiveFirst, exclusiveLast)
      def in(values: Set[AstValue]): In = In(node, values)
      def contains(filterString: AstValue): Contains = Contains(node, filterString)
      def startsWith(filterString: AstValue): StartsWith = StartsWith(node, filterString)
      def endsWith(filterString: AstValue): EndsWith = EndsWith(node, filterString)
      def isNull: IsNull = IsNull(node)
      def isNotNull: IsNotNull = IsNotNull(node)
    }

    def field(name: String): FieldAccess = FieldAccess(name)
    def literal(value: String): Literal = Literal(value)
    def untypedFilter(value: String): UntypedFilter = UntypedFilter(value)
  }
}
