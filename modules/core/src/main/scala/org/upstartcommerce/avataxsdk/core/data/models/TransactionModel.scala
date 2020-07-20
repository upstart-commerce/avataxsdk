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

final case class TransactionModel(
    id: Option[Long] = None,
    code: Option[String] = None,
    companyId: Option[Int] = None,
    date: Option[Date] = None,
    paymentDate: Option[Date] = None,
    status: Option[DocumentStatus] = None,
    `type`: Option[DocumentType] = None,
    batchCode: Option[String] = None,
    currencyCode: Option[String] = None,
    customerUsageType: Option[String] = None,
    entityUseCode: Option[String] = None,
    customerVendorCode: Option[String] = None,
    customerCode: Option[String] = None,
    exemptNo: Option[String] = None,
    reconciled: Option[Boolean] = None,
    locationCode: Option[String] = None,
    reportingLocationCode: Option[String] = None,
    purchaseOrderNo: Option[String] = None,
    referenceCode: Option[String] = None,
    salespersonCode: Option[String] = None,
    taxOverrideType: Option[TaxOverrideType] = None,
    taxOverrideAmount: Option[BigDecimal] = None,
    taxOverrideReason: Option[String] = None,
    totalAmount: Option[BigDecimal] = None,
    totalExempt: Option[BigDecimal] = None,
    totalDiscount: Option[BigDecimal] = None,
    totalTax: Option[BigDecimal] = None,
    totalTaxable: Option[BigDecimal] = None,
    totalTaxCalculated: Option[BigDecimal] = None,
    adjustmentReason: Option[AdjustmentReason] = None,
    adjustmentDescription: Option[String] = None,
    locked: Option[Boolean] = None,
    region: Option[String] = None,
    country: Option[String] = None,
    version: Option[Int] = None,
    softwareVersion: Option[String] = None,
    originAddressId: Option[Long] = None,
    destinationAddressId: Option[Long] = None,
    exchangeRateEffectiveDate: Option[Date] = None,
    exchangeRate: Option[BigDecimal] = None,
    isSellerImporterOfRecord: Option[Boolean] = None,
    description: Option[String] = None,
    email: Option[String] = None,
    businessIdentificationNo: Option[String] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None,
    taxDate: Option[Date] = None,
    lines: Option[List[TransactionLineModel]] = None,
    addresses: Option[List[TransactionAddressModel]] = None,
    locationTypes: Option[List[TransactionLocationTypeModel]] = None,
    summary: Option[List[TransactionSummary]] = None,
    taxDetailsByTaxType: Option[List[TaxDetailsByTaxType]] = None,
    parameters: Option[Map[String, String]] = None,
    messages: Option[List[AvaTaxMessage]] = None,
    invoiceMessages: Option[List[InvoiceMessageModel]] = None
) {
  lazy val linesRaw: List[TransactionLineModel] = lines.getOrElse(List.empty)
  lazy val addressesRaw: List[TransactionAddressModel] = addresses.getOrElse(List.empty)
  lazy val locationTypesRaw: List[TransactionLocationTypeModel] = locationTypes.getOrElse(List.empty)
  lazy val summaryRaw: List[TransactionSummary] = summary.getOrElse(List.empty)
  lazy val taxDetailsByTaxTypeRaw: List[TaxDetailsByTaxType] = taxDetailsByTaxType.getOrElse(List.empty)
  lazy val parametersRaw: Map[String, String] = parameters.getOrElse(Map.empty)
  lazy val messagesRaw: List[AvaTaxMessage] = messages.getOrElse(List.empty)
  lazy val invoiceMessagesRaw: List[InvoiceMessageModel] = invoiceMessages.getOrElse(List.empty)
  def withId(value: Long): TransactionModel = copy(id = Some(value))
  def withCode(value: String): TransactionModel = copy(code = Some(value))
  def withCompanyId(value: Int): TransactionModel = copy(companyId = Some(value))
  def withDate(value: Date): TransactionModel = copy(date = Some(value))
  def withPaymentDate(value: Date): TransactionModel = copy(paymentDate = Some(value))
  def withStatus(value: DocumentStatus): TransactionModel = copy(status = Some(value))
  def withType(value: DocumentType): TransactionModel = copy(`type` = Some(value))
  def withBatchCode(value: String): TransactionModel = copy(batchCode = Some(value))
  def withCurrencyCode(value: String): TransactionModel = copy(currencyCode = Some(value))
  def withCustomerUsageType(value: String): TransactionModel = copy(customerUsageType = Some(value))
  def withEntityUseCode(value: String): TransactionModel = copy(entityUseCode = Some(value))
  def withCustomerVendorCode(value: String): TransactionModel = copy(customerVendorCode = Some(value))
  def withCustomerCode(value: String): TransactionModel = copy(customerCode = Some(value))
  def withExemptNo(value: String): TransactionModel = copy(exemptNo = Some(value))
  def withReconciled(value: Boolean): TransactionModel = copy(reconciled = Some(value))
  def withLocationCode(value: String): TransactionModel = copy(locationCode = Some(value))
  def withReportingLocationCode(value: String): TransactionModel = copy(reportingLocationCode = Some(value))
  def withPurchaseOrderNo(value: String): TransactionModel = copy(purchaseOrderNo = Some(value))
  def withReferenceCode(value: String): TransactionModel = copy(referenceCode = Some(value))
  def withSalespersonCode(value: String): TransactionModel = copy(salespersonCode = Some(value))
  def withTaxOverrideType(value: TaxOverrideType): TransactionModel = copy(taxOverrideType = Some(value))
  def withTaxOverrideAmount(value: BigDecimal): TransactionModel = copy(taxOverrideAmount = Some(value))
  def withTaxOverrideReason(value: String): TransactionModel = copy(taxOverrideReason = Some(value))
  def withTotalAmount(value: BigDecimal): TransactionModel = copy(totalAmount = Some(value))
  def withTotalExempt(value: BigDecimal): TransactionModel = copy(totalExempt = Some(value))
  def withTotalDiscount(value: BigDecimal): TransactionModel = copy(totalDiscount = Some(value))
  def withTotalTax(value: BigDecimal): TransactionModel = copy(totalTax = Some(value))
  def withTotalTaxable(value: BigDecimal): TransactionModel = copy(totalTaxable = Some(value))
  def withTotalTaxCalculated(value: BigDecimal): TransactionModel = copy(totalTaxCalculated = Some(value))
  def withAdjustmentReason(value: AdjustmentReason): TransactionModel = copy(adjustmentReason = Some(value))
  def withAdjustmentDescription(value: String): TransactionModel = copy(adjustmentDescription = Some(value))
  def withLocked(value: Boolean): TransactionModel = copy(locked = Some(value))
  def withRegion(value: String): TransactionModel = copy(region = Some(value))
  def withCountry(value: String): TransactionModel = copy(country = Some(value))
  def withVersion(value: Int): TransactionModel = copy(version = Some(value))
  def withSoftwareVersion(value: String): TransactionModel = copy(softwareVersion = Some(value))
  def withOriginAddressId(value: Long): TransactionModel = copy(originAddressId = Some(value))
  def withDestinationAddressId(value: Long): TransactionModel = copy(destinationAddressId = Some(value))
  def withExchangeRateEffectiveDate(value: Date): TransactionModel = copy(exchangeRateEffectiveDate = Some(value))
  def withExchangeRate(value: BigDecimal): TransactionModel = copy(exchangeRate = Some(value))
  def withIsSellerImporterOfRecord(value: Boolean): TransactionModel = copy(isSellerImporterOfRecord = Some(value))
  def withDescription(value: String): TransactionModel = copy(description = Some(value))
  def withEmail(value: String): TransactionModel = copy(email = Some(value))
  def withBusinessIdentificationNo(value: String): TransactionModel = copy(businessIdentificationNo = Some(value))
  def withModifiedDate(value: Date): TransactionModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): TransactionModel = copy(modifiedUserId = Some(value))
  def withTaxDate(value: Date): TransactionModel = copy(taxDate = Some(value))
  def withLines(value: List[TransactionLineModel]): TransactionModel = copy(lines = Some(value))
  def withAddresses(value: List[TransactionAddressModel]): TransactionModel = copy(addresses = Some(value))
  def withLocationTypes(value: List[TransactionLocationTypeModel]): TransactionModel = copy(locationTypes = Some(value))
  def withSummary(value: List[TransactionSummary]): TransactionModel = copy(summary = Some(value))
  def withTaxDetailsByTaxType(value: List[TaxDetailsByTaxType]): TransactionModel = copy(taxDetailsByTaxType = Some(value))
  def withParameters(value: Map[String, String]): TransactionModel = copy(parameters = Some(value))
  def withMessages(value: List[AvaTaxMessage]): TransactionModel = copy(messages = Some(value))
  def withInvoiceMessages(value: List[InvoiceMessageModel]): TransactionModel = copy(invoiceMessages = Some(value))
}
