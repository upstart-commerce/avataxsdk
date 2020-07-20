package org.upstartcommerce.avataxsdk.core.data
import org.upstartcommerce.avataxsdk.core.data.OrderBy.FieldName

sealed trait OrderBy
object OrderBy {
  case object Ascending extends OrderBy
  case object Descending extends OrderBy

  type FieldName = String
  final case class OrderByClause(orderBys: List[(FieldName, OrderBy)])

  def apply(field: FieldName, by: OrderBy): OrderByClause = OrderByClause(List((field, by)))
  def apply(ordering: (FieldName, OrderBy)*): OrderByClause = OrderByClause(ordering.toList)

  def serialize(clause: OrderByClause): String = {
    clause.orderBys
      .map {
        case (fieldName, Ascending) => s"$fieldName ASC"
        case (fieldName, Descending) => s"$fieldName DESC"
      }
      .mkString(",")
  }
}
