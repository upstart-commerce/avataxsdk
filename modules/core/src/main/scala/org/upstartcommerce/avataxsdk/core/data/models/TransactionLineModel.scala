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

final case class TransactionLineModel(
    id: Option[Long] = None,
    transactionId: Option[Long] = None,
    lineNumber: Option[String] = None,
    boundaryOverrideId: Option[Int] = None,
    customerUsageType: Option[String] = None,
    entityUseCode: Option[String] = None,
    description: Option[String] = None,
    destinationAddressId: Option[Long] = None,
    originAddressId: Option[Long] = None,
    discountAmount: Option[BigDecimal] = None,
    discountTypeId: Option[Int] = None,
    exemptAmount: Option[BigDecimal] = None,
    exemptCertId: Option[Int] = None,
    certificateId: Option[String] = None,
    exemptNo: Option[String] = None,
    isItemTaxable: Option[Boolean] = None,
    isSSTP: Option[Boolean] = None,
    itemCode: Option[String] = None,
    lineAmount: Option[BigDecimal] = None,
    quantity: Option[BigDecimal] = None,
    ref1: Option[String] = None,
    ref2: Option[String] = None,
    reportingDate: Option[Date] = None,
    revAccount: Option[String] = None,
    sourcing: Option[Sourcing] = None,
    tax: Option[BigDecimal] = None,
    taxableAmount: Option[BigDecimal] = None,
    taxCalculated: Option[BigDecimal] = None,
    taxCode: Option[String] = None,
    taxCodeId: Option[Int] = None,
    taxDate: Option[Date] = None,
    taxEngine: Option[String] = None,
    taxOverrideType: Option[TaxOverrideType] = None,
    businessIdentificationNo: Option[String] = None,
    taxOverrideAmount: Option[BigDecimal] = None,
    taxOverrideReason: Option[String] = None,
    taxIncluded: Option[Boolean] = None,
    details: Option[List[TransactionLineDetailModel]] = None,
    nonPassthroughDetails: Option[List[TransactionLineDetailModel]] = None,
    lineLocationTypes: Option[List[TransactionLineLocationTypeModel]] = None,
    parameters: Option[Map[String, String]] = None,
    hsCode: Option[String] = None,
    costInsuranceFreight: Option[BigDecimal] = None,
    vatCode: Option[String] = None,
    vatNumberTypeId: Option[Int] = None
) {
  lazy val detailsRaw: List[TransactionLineDetailModel] = details.getOrElse(List.empty)
  lazy val nonPassthroughDetailsRaw: List[TransactionLineDetailModel] = nonPassthroughDetails.getOrElse(List.empty)
  lazy val lineLocationTypesRaw: List[TransactionLineLocationTypeModel] = lineLocationTypes.getOrElse(List.empty)
  lazy val parametersRaw: Map[String, String] = parameters.getOrElse(Map.empty)
  def withId(value: Long): TransactionLineModel = copy(id = Some(value))
  def withTransactionId(value: Long): TransactionLineModel = copy(transactionId = Some(value))
  def withLineNumber(value: String): TransactionLineModel = copy(lineNumber = Some(value))
  def withBoundaryOverrideId(value: Int): TransactionLineModel = copy(boundaryOverrideId = Some(value))
  def withCustomerUsageType(value: String): TransactionLineModel = copy(customerUsageType = Some(value))
  def withEntityUseCode(value: String): TransactionLineModel = copy(entityUseCode = Some(value))
  def withDescription(value: String): TransactionLineModel = copy(description = Some(value))
  def withDestinationAddressId(value: Long): TransactionLineModel = copy(destinationAddressId = Some(value))
  def withOriginAddressId(value: Long): TransactionLineModel = copy(originAddressId = Some(value))
  def withDiscountAmount(value: BigDecimal): TransactionLineModel = copy(discountAmount = Some(value))
  def withDiscountTypeId(value: Int): TransactionLineModel = copy(discountTypeId = Some(value))
  def withExemptAmount(value: BigDecimal): TransactionLineModel = copy(exemptAmount = Some(value))
  def withExemptCertId(value: Int): TransactionLineModel = copy(exemptCertId = Some(value))
  def withCertificateId(value: String): TransactionLineModel = copy(certificateId = Some(value))
  def withExemptNo(value: String): TransactionLineModel = copy(exemptNo = Some(value))
  def withIsItemTaxable(value: Boolean): TransactionLineModel = copy(isItemTaxable = Some(value))
  def withIsSSTP(value: Boolean): TransactionLineModel = copy(isSSTP = Some(value))
  def withItemCode(value: String): TransactionLineModel = copy(itemCode = Some(value))
  def withLineAmount(value: BigDecimal): TransactionLineModel = copy(lineAmount = Some(value))
  def withQuantity(value: BigDecimal): TransactionLineModel = copy(quantity = Some(value))
  def withRef1(value: String): TransactionLineModel = copy(ref1 = Some(value))
  def withRef2(value: String): TransactionLineModel = copy(ref2 = Some(value))
  def withReportingDate(value: Date): TransactionLineModel = copy(reportingDate = Some(value))
  def withRevAccount(value: String): TransactionLineModel = copy(revAccount = Some(value))
  def withSourcing(value: Sourcing): TransactionLineModel = copy(sourcing = Some(value))
  def withTax(value: BigDecimal): TransactionLineModel = copy(tax = Some(value))
  def withTaxableAmount(value: BigDecimal): TransactionLineModel = copy(taxableAmount = Some(value))
  def withTaxCalculated(value: BigDecimal): TransactionLineModel = copy(taxCalculated = Some(value))
  def withTaxCode(value: String): TransactionLineModel = copy(taxCode = Some(value))
  def withTaxCodeId(value: Int): TransactionLineModel = copy(taxCodeId = Some(value))
  def withTaxDate(value: Date): TransactionLineModel = copy(taxDate = Some(value))
  def withTaxEngine(value: String): TransactionLineModel = copy(taxEngine = Some(value))
  def withTaxOverrideType(value: TaxOverrideType): TransactionLineModel = copy(taxOverrideType = Some(value))
  def withBusinessIdentificationNo(value: String): TransactionLineModel = copy(businessIdentificationNo = Some(value))
  def withTaxOverrideAmount(value: BigDecimal): TransactionLineModel = copy(taxOverrideAmount = Some(value))
  def withTaxOverrideReason(value: String): TransactionLineModel = copy(taxOverrideReason = Some(value))
  def withTaxIncluded(value: Boolean): TransactionLineModel = copy(taxIncluded = Some(value))
  def withDetails(value: List[TransactionLineDetailModel]): TransactionLineModel = copy(details = Some(value))
  def withNonPassthroughDetails(value: List[TransactionLineDetailModel]): TransactionLineModel = copy(nonPassthroughDetails = Some(value))
  def withLineLocationTypes(value: List[TransactionLineLocationTypeModel]): TransactionLineModel = copy(lineLocationTypes = Some(value))
  def withParameters(value: Map[String, String]): TransactionLineModel = copy(parameters = Some(value))
  def withHsCode(value: String): TransactionLineModel = copy(hsCode = Some(value))
  def withCostInsuranceFreight(value: BigDecimal): TransactionLineModel = copy(costInsuranceFreight = Some(value))
  def withVatCode(value: String): TransactionLineModel = copy(vatCode = Some(value))
  def withVatNumberTypeId(value: Int): TransactionLineModel = copy(vatNumberTypeId = Some(value))
}
