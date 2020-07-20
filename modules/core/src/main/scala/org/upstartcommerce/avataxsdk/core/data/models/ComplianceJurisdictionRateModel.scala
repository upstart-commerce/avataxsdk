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

final case class ComplianceJurisdictionRateModel(
    jurisdictionId: Option[Int] = None,
    country: Option[String] = None,
    region: Option[String] = None,
    name: Option[String] = None,
    jurisdictionTypeId: Option[String] = None,
    rate: Option[BigDecimal] = None,
    rateTypeId: Option[String] = None,
    taxTypeId: Option[String] = None,
    effectiveDate: Option[Date] = None,
    endDate: Option[Date] = None,
    stateAssignedCode: Option[String] = None,
    taxAuthorityId: Option[Int] = None
) {

  def withJurisdictionId(value: Int): ComplianceJurisdictionRateModel = copy(jurisdictionId = Some(value))
  def withCountry(value: String): ComplianceJurisdictionRateModel = copy(country = Some(value))
  def withRegion(value: String): ComplianceJurisdictionRateModel = copy(region = Some(value))
  def withName(value: String): ComplianceJurisdictionRateModel = copy(name = Some(value))
  def withJurisdictionTypeId(value: String): ComplianceJurisdictionRateModel = copy(jurisdictionTypeId = Some(value))
  def withRate(value: BigDecimal): ComplianceJurisdictionRateModel = copy(rate = Some(value))
  def withRateTypeId(value: String): ComplianceJurisdictionRateModel = copy(rateTypeId = Some(value))
  def withTaxTypeId(value: String): ComplianceJurisdictionRateModel = copy(taxTypeId = Some(value))
  def withEffectiveDate(value: Date): ComplianceJurisdictionRateModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Date): ComplianceJurisdictionRateModel = copy(endDate = Some(value))
  def withStateAssignedCode(value: String): ComplianceJurisdictionRateModel = copy(stateAssignedCode = Some(value))
  def withTaxAuthorityId(value: Int): ComplianceJurisdictionRateModel = copy(taxAuthorityId = Some(value))
}
