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

final case class JurisdictionOverrideModel(
    id: Option[Int] = None,
    accountId: Option[Int] = None,
    description: String,
    line1: Option[String] = None,
    city: Option[String] = None,
    region: String,
    country: Option[String] = None,
    postalCode: String,
    effectiveDate: Option[Date] = None,
    endDate: Option[Date] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None,
    jurisdictions: List[JurisdictionModel],
    taxRegionId: Int,
    boundaryLevel: Option[BoundaryLevel] = None,
    isDefault: Option[Boolean] = None
) {
  def withId(value: Int): JurisdictionOverrideModel = copy(id = Some(value))
  def withAccountId(value: Int): JurisdictionOverrideModel = copy(accountId = Some(value))
  def withDescription(value: String): JurisdictionOverrideModel = copy(description = value)
  def withLine1(value: String): JurisdictionOverrideModel = copy(line1 = Some(value))
  def withCity(value: String): JurisdictionOverrideModel = copy(city = Some(value))
  def withRegion(value: String): JurisdictionOverrideModel = copy(region = value)
  def withCountry(value: String): JurisdictionOverrideModel = copy(country = Some(value))
  def withPostalCode(value: String): JurisdictionOverrideModel = copy(postalCode = value)
  def withEffectiveDate(value: Date): JurisdictionOverrideModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Date): JurisdictionOverrideModel = copy(endDate = Some(value))
  def withCreatedDate(value: Date): JurisdictionOverrideModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): JurisdictionOverrideModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): JurisdictionOverrideModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): JurisdictionOverrideModel = copy(modifiedUserId = Some(value))
  def withJurisdictions(value: List[JurisdictionModel]): JurisdictionOverrideModel = copy(jurisdictions = value)
  def withTaxRegionId(value: Int): JurisdictionOverrideModel = copy(taxRegionId = value)
  def withBoundaryLevel(value: BoundaryLevel): JurisdictionOverrideModel = copy(boundaryLevel = Some(value))
  def withIsDefault(value: Boolean): JurisdictionOverrideModel = copy(isDefault = Some(value))
}
