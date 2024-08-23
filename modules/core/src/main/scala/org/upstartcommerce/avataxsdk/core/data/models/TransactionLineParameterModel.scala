package org.upstartcommerce.avataxsdk.core.data.models

case class TransactionLineParameterModel(id: Option[String] = None, name: Option[String] = None, unit: Option[String] = None) {
  def withId(value: String): TransactionLineParameterModel = copy(id = Some(value))
  def withName(value: String): TransactionLineParameterModel = copy(name = Some(value))
  def withUnit(value: String): TransactionLineParameterModel = copy(unit = Some(value))
}
