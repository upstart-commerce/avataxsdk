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

final case class TaxRuleModel(
    id: Int,
    companyId: Option[Int] = None,
    taxCodeId: Option[Int] = None,
    taxCode: Option[String] = None,
    stateFIPS: Option[String] = None,
    jurisName: Option[String] = None,
    jurisCode: String,
    jurisTypeId: Option[JurisTypeId] = None,
    jurisdictionTypeId: Option[JurisdictionType] = None,
    customerUsageType: Option[String] = None,
    entityUseCode: Option[String] = None,
    taxTypeId: Option[MatchingTaxType] = None,
    rateTypeCode: Option[String] = None,
    taxRuleTypeId: TaxRuleTypeId,
    isAllJuris: Option[Boolean] = None,
    value: Option[BigDecimal] = None,
    cap: Option[BigDecimal] = None,
    threshold: Option[BigDecimal] = None,
    options: Option[String] = None,
    effectiveDate: Option[Date] = None,
    endDate: Option[Date] = None,
    description: Option[String] = None,
    countyFIPS: Option[String] = None,
    isSTPro: Option[Boolean] = None,
    country: String,
    region: Option[String] = None,
    sourcing: Option[Sourcing] = None,
    taxTypeGroup: Option[String] = None,
    taxSubType: Option[String] = None,
    nonPassthroughExpression: Option[String] = None,
    currencyCode: Option[String] = None,
    preferredProgramId: Option[Int] = None,
    uomId: Option[Int] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None
) {

  def withId(value: Int): TaxRuleModel = copy(id = value)
  def withCompanyId(value: Int): TaxRuleModel = copy(companyId = Some(value))
  def withTaxCodeId(value: Int): TaxRuleModel = copy(taxCodeId = Some(value))
  def withTaxCode(value: String): TaxRuleModel = copy(taxCode = Some(value))
  def withStateFIPS(value: String): TaxRuleModel = copy(stateFIPS = Some(value))
  def withJurisName(value: String): TaxRuleModel = copy(jurisName = Some(value))
  def withJurisCode(value: String): TaxRuleModel = copy(jurisCode = value)
  def withJurisTypeId(value: JurisTypeId): TaxRuleModel = copy(jurisTypeId = Some(value))
  def withJurisdictionTypeId(value: JurisdictionType): TaxRuleModel = copy(jurisdictionTypeId = Some(value))
  def withCustomerUsageType(value: String): TaxRuleModel = copy(customerUsageType = Some(value))
  def withEntityUseCode(value: String): TaxRuleModel = copy(entityUseCode = Some(value))
  def withTaxTypeId(value: MatchingTaxType): TaxRuleModel = copy(taxTypeId = Some(value))
  def withRateTypeCode(value: String): TaxRuleModel = copy(rateTypeCode = Some(value))
  def withTaxRuleTypeId(value: TaxRuleTypeId): TaxRuleModel = copy(taxRuleTypeId = value)
  def withIsAllJuris(value: Boolean): TaxRuleModel = copy(isAllJuris = Some(value))
  def withValue(value: BigDecimal): TaxRuleModel = copy(value = Some(value))
  def withCap(value: BigDecimal): TaxRuleModel = copy(cap = Some(value))
  def withThreshold(value: BigDecimal): TaxRuleModel = copy(threshold = Some(value))
  def withOptions(value: String): TaxRuleModel = copy(options = Some(value))
  def withEffectiveDate(value: Date): TaxRuleModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Date): TaxRuleModel = copy(endDate = Some(value))
  def withDescription(value: String): TaxRuleModel = copy(description = Some(value))
  def withCountyFIPS(value: String): TaxRuleModel = copy(countyFIPS = Some(value))
  def withIsSTPro(value: Boolean): TaxRuleModel = copy(isSTPro = Some(value))
  def withCountry(value: String): TaxRuleModel = copy(country = value)
  def withRegion(value: String): TaxRuleModel = copy(region = Some(value))
  def withSourcing(value: Sourcing): TaxRuleModel = copy(sourcing = Some(value))
  def withTaxTypeGroup(value: String): TaxRuleModel = copy(taxTypeGroup = Some(value))
  def withTaxSubType(value: String): TaxRuleModel = copy(taxSubType = Some(value))
  def withNonPassthroughExpression(value: String): TaxRuleModel = copy(nonPassthroughExpression = Some(value))
  def withCurrencyCode(value: String): TaxRuleModel = copy(currencyCode = Some(value))
  def withPreferredProgramId(value: Int): TaxRuleModel = copy(preferredProgramId = Some(value))
  def withUomId(value: Int): TaxRuleModel = copy(uomId = Some(value))
  def withCreatedDate(value: Date): TaxRuleModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): TaxRuleModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): TaxRuleModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): TaxRuleModel = copy(modifiedUserId = Some(value))
}
