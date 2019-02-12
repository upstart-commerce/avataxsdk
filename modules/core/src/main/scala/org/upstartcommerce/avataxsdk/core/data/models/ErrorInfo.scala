package org.upstartcommerce.avataxsdk.core.data.models
import java.sql.Date
import org.upstartcommerce.avataxsdk.core.data.enums._

final case class ErrorInfo(code:Option[ErrorCodeId] = None, message:Option[String] = None, target:Option[ErrorTargetCode] = None, details:List[ErrorDetail] = List.empty) {
  def withCode(value:ErrorCodeId):ErrorInfo = copy(code = Some(value))
  def withMessage(value:String):ErrorInfo = copy(message = Some(value))
  def withTarget(value:ErrorTargetCode):ErrorInfo = copy(target = Some(value))
  def withDetails(value:List[ErrorDetail]):ErrorInfo = copy(details = value)
}
  