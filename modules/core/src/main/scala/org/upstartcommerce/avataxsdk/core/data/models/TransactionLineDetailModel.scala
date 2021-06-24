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
import org.upstartcommerce.avataxsdk.core.data.enums._

final case class TransactionLineDetailModel(
    id: Option[Long] = None,
    transactionLineId: Option[Long] = None,
    transactionId: Option[Long] = None,
    addressId: Option[Long] = None,
    country: Option[String] = None,
    region: Option[String] = None,
    countyFIPS: Option[String] = None,
    stateFIPS: Option[String] = None,
    exemptAmount: Option[BigDecimal] = None,
    exemptReasonId: Option[Int] = None,
    inState: Option[Boolean] = None,
    jurisCode: Option[String] = None,
    jurisName: Option[String] = None,
    jurisdictionId: Option[Int] = None,
    signatureCode: Option[String] = None,
    stateAssignedNo: Option[String] = None,
    jurisType: Option[JurisTypeId] = None,
    jurisdictionType: Option[JurisdictionType] = None,
    nonTaxableAmount: Option[BigDecimal] = None,
    nonTaxableRuleId: Option[Int] = None,
    nonTaxableType: Option[TaxRuleTypeId] = None,
    rate: Option[BigDecimal] = None,
    rateRuleId: Option[Int] = None,
    rateSourceId: Option[Int] = None,
    serCode: Option[String] = None,
    sourcing: Option[Sourcing] = None,
    tax: Option[BigDecimal] = None,
    taxableAmount: Option[BigDecimal] = None,
    taxType: Option[TaxType] = None,
    taxSubTypeId: Option[String] = None,
    taxTypeGroupId: Option[String] = None,
    taxName: Option[String] = None,
    taxAuthorityTypeId: Option[Int] = None,
    taxRegionId: Option[Int] = None,
    taxCalculated: Option[BigDecimal] = None,
    taxOverride: Option[BigDecimal] = None,
    rateTypeCode: Option[String] = None,
    taxableUnits: Option[BigDecimal] = None,
    nonTaxableUnits: Option[BigDecimal] = None,
    exemptUnits: Option[BigDecimal] = None,
    unitOfBasis: Option[String] = None,
    isNonPassThru: Option[Boolean] = None
) {

  def withId(value: Long): TransactionLineDetailModel = copy(id = Some(value))
  def withTransactionLineId(value: Long): TransactionLineDetailModel = copy(transactionLineId = Some(value))
  def withTransactionId(value: Long): TransactionLineDetailModel = copy(transactionId = Some(value))
  def withAddressId(value: Long): TransactionLineDetailModel = copy(addressId = Some(value))
  def withCountry(value: String): TransactionLineDetailModel = copy(country = Some(value))
  def withRegion(value: String): TransactionLineDetailModel = copy(region = Some(value))
  def withCountyFIPS(value: String): TransactionLineDetailModel = copy(countyFIPS = Some(value))
  def withStateFIPS(value: String): TransactionLineDetailModel = copy(stateFIPS = Some(value))
  def withExemptAmount(value: BigDecimal): TransactionLineDetailModel = copy(exemptAmount = Some(value))
  def withExemptReasonId(value: Int): TransactionLineDetailModel = copy(exemptReasonId = Some(value))
  def withInState(value: Boolean): TransactionLineDetailModel = copy(inState = Some(value))
  def withJurisCode(value: String): TransactionLineDetailModel = copy(jurisCode = Some(value))
  def withJurisName(value: String): TransactionLineDetailModel = copy(jurisName = Some(value))
  def withJurisdictionId(value: Int): TransactionLineDetailModel = copy(jurisdictionId = Some(value))
  def withSignatureCode(value: String): TransactionLineDetailModel = copy(signatureCode = Some(value))
  def withStateAssignedNo(value: String): TransactionLineDetailModel = copy(stateAssignedNo = Some(value))
  def withJurisType(value: JurisTypeId): TransactionLineDetailModel = copy(jurisType = Some(value))
  def withJurisdictionType(value: JurisdictionType): TransactionLineDetailModel = copy(jurisdictionType = Some(value))
  def withNonTaxableAmount(value: BigDecimal): TransactionLineDetailModel = copy(nonTaxableAmount = Some(value))
  def withNonTaxableRuleId(value: Int): TransactionLineDetailModel = copy(nonTaxableRuleId = Some(value))
  def withNonTaxableType(value: TaxRuleTypeId): TransactionLineDetailModel = copy(nonTaxableType = Some(value))
  def withRate(value: BigDecimal): TransactionLineDetailModel = copy(rate = Some(value))
  def withRateRuleId(value: Int): TransactionLineDetailModel = copy(rateRuleId = Some(value))
  def withRateSourceId(value: Int): TransactionLineDetailModel = copy(rateSourceId = Some(value))
  def withSerCode(value: String): TransactionLineDetailModel = copy(serCode = Some(value))
  def withSourcing(value: Sourcing): TransactionLineDetailModel = copy(sourcing = Some(value))
  def withTax(value: BigDecimal): TransactionLineDetailModel = copy(tax = Some(value))
  def withTaxableAmount(value: BigDecimal): TransactionLineDetailModel = copy(taxableAmount = Some(value))
  def withTaxType(value: TaxType): TransactionLineDetailModel = copy(taxType = Some(value))
  def withTaxSubTypeId(value: String): TransactionLineDetailModel = copy(taxSubTypeId = Some(value))
  def withTaxTypeGroupId(value: String): TransactionLineDetailModel = copy(taxTypeGroupId = Some(value))
  def withTaxName(value: String): TransactionLineDetailModel = copy(taxName = Some(value))
  def withTaxAuthorityTypeId(value: Int): TransactionLineDetailModel = copy(taxAuthorityTypeId = Some(value))
  def withTaxRegionId(value: Int): TransactionLineDetailModel = copy(taxRegionId = Some(value))
  def withTaxCalculated(value: BigDecimal): TransactionLineDetailModel = copy(taxCalculated = Some(value))
  def withTaxOverride(value: BigDecimal): TransactionLineDetailModel = copy(taxOverride = Some(value))
  def withRateTypeCode(value: String): TransactionLineDetailModel = copy(rateTypeCode = Some(value))
  def withTaxableUnits(value: BigDecimal): TransactionLineDetailModel = copy(taxableUnits = Some(value))
  def withNonTaxableUnits(value: BigDecimal): TransactionLineDetailModel = copy(nonTaxableUnits = Some(value))
  def withExemptUnits(value: BigDecimal): TransactionLineDetailModel = copy(exemptUnits = Some(value))
  def withUnitOfBasis(value: String): TransactionLineDetailModel = copy(unitOfBasis = Some(value))
  def withIsNonPassThru(value: Boolean): TransactionLineDetailModel = copy(isNonPassThru = Some(value))
}
