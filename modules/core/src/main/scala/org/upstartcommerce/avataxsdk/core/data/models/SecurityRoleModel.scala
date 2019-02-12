package org.upstartcommerce.avataxsdk.core.data.models
import java.sql.Date
import org.upstartcommerce.avataxsdk.core.data.enums._

final case class SecurityRoleModel(id:Option[Int] = None, description:Option[String] = None) {
  def withId(value:Int):SecurityRoleModel = copy(id = Some(value))
  def withDescription(value:String):SecurityRoleModel = copy(description = Some(value))
}
  