package org.upstartcommerce.avataxsdk.core.data.models
import java.sql.Date
import org.upstartcommerce.avataxsdk.core.data.enums._

final case class IsoCountryModel(code:Option[String] = None, alpha3Code:Option[String] = None, name:Option[String] = None, isEuropeanUnion:Option[Boolean] = None, localizedNames:List[IsoLocalizedName] = List.empty, addressesRequireRegion:Option[Boolean] = None) {
  def withCode(value:String):IsoCountryModel = copy(code = Some(value))
  def withAlpha3Code(value:String):IsoCountryModel = copy(alpha3Code = Some(value))
  def withName(value:String):IsoCountryModel = copy(name = Some(value))
  def withIsEuropeanUnion(value:Boolean):IsoCountryModel = copy(isEuropeanUnion = Some(value))
  def withLocalizedNames(value:List[IsoLocalizedName]):IsoCountryModel = copy(localizedNames = value)
  def withAddressesRequireRegion(value:Boolean):IsoCountryModel = copy(addressesRequireRegion = Some(value))
}
  