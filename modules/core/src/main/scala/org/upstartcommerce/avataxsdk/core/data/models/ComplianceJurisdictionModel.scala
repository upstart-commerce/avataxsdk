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

final case class ComplianceJurisdictionModel(
    taxRegionId: Option[Int] = None,
    stateAssignedCode: Option[String] = None,
    jurisdictionTypeId: Option[String] = None,
    name: Option[String] = None,
    county: Option[String] = None,
    city: Option[String] = None,
    region: Option[String] = None,
    country: Option[String] = None,
    taxRegionName: Option[String] = None,
    taxAuthorityId: Option[Int] = None,
    rates: Option[List[ComplianceAggregatedTaxRateModel]] = None
) {
  lazy val ratesRaw: List[ComplianceAggregatedTaxRateModel] = rates.getOrElse(List.empty)
  def withTaxRegionId(value: Int): ComplianceJurisdictionModel = copy(taxRegionId = Some(value))
  def withStateAssignedCode(value: String): ComplianceJurisdictionModel = copy(stateAssignedCode = Some(value))
  def withJurisdictionTypeId(value: String): ComplianceJurisdictionModel = copy(jurisdictionTypeId = Some(value))
  def withName(value: String): ComplianceJurisdictionModel = copy(name = Some(value))
  def withCounty(value: String): ComplianceJurisdictionModel = copy(county = Some(value))
  def withCity(value: String): ComplianceJurisdictionModel = copy(city = Some(value))
  def withRegion(value: String): ComplianceJurisdictionModel = copy(region = Some(value))
  def withCountry(value: String): ComplianceJurisdictionModel = copy(country = Some(value))
  def withTaxRegionName(value: String): ComplianceJurisdictionModel = copy(taxRegionName = Some(value))
  def withTaxAuthorityId(value: Int): ComplianceJurisdictionModel = copy(taxAuthorityId = Some(value))
  def withRates(value: List[ComplianceAggregatedTaxRateModel]): ComplianceJurisdictionModel = copy(rates = Some(value))
}
