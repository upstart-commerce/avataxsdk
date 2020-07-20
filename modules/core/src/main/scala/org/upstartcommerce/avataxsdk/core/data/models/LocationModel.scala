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

final case class LocationModel(
    id: Int,
    companyId: Option[Int] = None,
    locationCode: String,
    description: Option[String] = None,
    addressTypeId: AddressTypeId,
    addressCategoryId: AddressCategoryId,
    line1: String,
    line2: Option[String] = None,
    line3: Option[String] = None,
    city: Option[String] = None,
    county: Option[String] = None,
    region: Option[String] = None,
    postalCode: String,
    country: String,
    isDefault: Option[Boolean] = None,
    isRegistered: Option[Boolean] = None,
    dbaName: Option[String] = None,
    outletName: Option[String] = None,
    effectiveDate: Option[Date] = None,
    endDate: Option[Date] = None,
    lastTransactionDate: Option[Date] = None,
    registeredDate: Option[Date] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None,
    settings: Option[List[LocationSettingModel]] = None
) {
  lazy val settingsRaw: List[LocationSettingModel] = settings.getOrElse(List.empty)
  def withId(value: Int): LocationModel = copy(id = value)
  def withCompanyId(value: Int): LocationModel = copy(companyId = Some(value))
  def withLocationCode(value: String): LocationModel = copy(locationCode = value)
  def withDescription(value: String): LocationModel = copy(description = Some(value))
  def withAddressTypeId(value: AddressTypeId): LocationModel = copy(addressTypeId = value)
  def withAddressCategoryId(value: AddressCategoryId): LocationModel = copy(addressCategoryId = value)
  def withLine1(value: String): LocationModel = copy(line1 = value)
  def withLine2(value: String): LocationModel = copy(line2 = Some(value))
  def withLine3(value: String): LocationModel = copy(line3 = Some(value))
  def withCity(value: String): LocationModel = copy(city = Some(value))
  def withCounty(value: String): LocationModel = copy(county = Some(value))
  def withRegion(value: String): LocationModel = copy(region = Some(value))
  def withPostalCode(value: String): LocationModel = copy(postalCode = value)
  def withCountry(value: String): LocationModel = copy(country = value)
  def withIsDefault(value: Boolean): LocationModel = copy(isDefault = Some(value))
  def withIsRegistered(value: Boolean): LocationModel = copy(isRegistered = Some(value))
  def withDbaName(value: String): LocationModel = copy(dbaName = Some(value))
  def withOutletName(value: String): LocationModel = copy(outletName = Some(value))
  def withEffectiveDate(value: Date): LocationModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Date): LocationModel = copy(endDate = Some(value))
  def withLastTransactionDate(value: Date): LocationModel = copy(lastTransactionDate = Some(value))
  def withRegisteredDate(value: Date): LocationModel = copy(registeredDate = Some(value))
  def withCreatedDate(value: Date): LocationModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): LocationModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): LocationModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): LocationModel = copy(modifiedUserId = Some(value))
  def withSettings(value: List[LocationSettingModel]): LocationModel = copy(settings = Some(value))
}
