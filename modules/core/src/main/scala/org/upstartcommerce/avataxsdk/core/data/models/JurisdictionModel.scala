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

package org.upstartcommerce.avataxsdk.core.data.models
import java.sql.Date
import org.upstartcommerce.avataxsdk.core.data.enums._

final case class JurisdictionModel(
    code: String,
    name: String,
    `type`: JurisdictionType,
    rate: Option[BigDecimal] = None,
    salesRate: Option[BigDecimal] = None,
    signatureCode: String,
    region: Option[String] = None,
    useRate: Option[BigDecimal] = None,
    city: Option[String] = None,
    county: Option[String] = None,
    country: Option[String] = None,
    shortName: Option[String] = None,
    stateFips: Option[String] = None,
    countyFips: Option[String] = None,
    placeFips: Option[String] = None,
    id: Option[Int] = None,
    effectiveDate: Option[Date] = None,
    endDate: Option[Date] = None
) {

  def withCode(value: String): JurisdictionModel = copy(code = value)
  def withName(value: String): JurisdictionModel = copy(name = value)
  def withType(value: JurisdictionType): JurisdictionModel = copy(`type` = value)
  def withRate(value: BigDecimal): JurisdictionModel = copy(rate = Some(value))
  def withSalesRate(value: BigDecimal): JurisdictionModel = copy(salesRate = Some(value))
  def withSignatureCode(value: String): JurisdictionModel = copy(signatureCode = value)
  def withRegion(value: String): JurisdictionModel = copy(region = Some(value))
  def withUseRate(value: BigDecimal): JurisdictionModel = copy(useRate = Some(value))
  def withCity(value: String): JurisdictionModel = copy(city = Some(value))
  def withCounty(value: String): JurisdictionModel = copy(county = Some(value))
  def withCountry(value: String): JurisdictionModel = copy(country = Some(value))
  def withShortName(value: String): JurisdictionModel = copy(shortName = Some(value))
  def withStateFips(value: String): JurisdictionModel = copy(stateFips = Some(value))
  def withCountyFips(value: String): JurisdictionModel = copy(countyFips = Some(value))
  def withPlaceFips(value: String): JurisdictionModel = copy(placeFips = Some(value))
  def withId(value: Int): JurisdictionModel = copy(id = Some(value))
  def withEffectiveDate(value: Date): JurisdictionModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Date): JurisdictionModel = copy(endDate = Some(value))
}
