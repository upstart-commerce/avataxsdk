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

final case class CreateMultiDocumentModel(
    code: Option[String] = None,
    lines: List[MultiDocumentLineItemModel],
    allowAdjust: Option[Boolean] = None,
    `type`: Option[DocumentType] = None,
    companyCode: Option[String] = None,
    date: Date,
    salespersonCode: Option[String] = None,
    customerCode: String,
    customerUsageType: Option[String] = None,
    entityUseCode: Option[String] = None,
    discount: Option[BigDecimal] = None,
    purchaseOrderNo: Option[String] = None,
    exemptionNo: Option[String] = None,
    addresses: Option[AddressesModel] = None,
    parameters: Option[Map[String, String]] = None,
    referenceCode: Option[String] = None,
    reportingLocationCode: Option[String] = None,
    commit: Option[Boolean] = None,
    batchCode: Option[String] = None,
    taxOverride: Option[TaxOverrideModel] = None,
    currencyCode: Option[String] = None,
    serviceMode: Option[ServiceMode] = None,
    exchangeRate: Option[BigDecimal] = None,
    exchangeRateEffectiveDate: Option[Date] = None,
    posLaneCode: Option[String] = None,
    businessIdentificationNo: Option[String] = None,
    isSellerImporterOfRecord: Option[Boolean] = None,
    description: Option[String] = None,
    email: Option[String] = None,
    debugLevel: Option[TaxDebugLevel] = None
) {
  lazy val parametersRaw: Map[String, String] = parameters.getOrElse(Map.empty)
  def withCode(value: String): CreateMultiDocumentModel = copy(code = Some(value))
  def withLines(value: List[MultiDocumentLineItemModel]): CreateMultiDocumentModel = copy(lines = value)
  def withAllowAdjust(value: Boolean): CreateMultiDocumentModel = copy(allowAdjust = Some(value))
  def withType(value: DocumentType): CreateMultiDocumentModel = copy(`type` = Some(value))
  def withCompanyCode(value: String): CreateMultiDocumentModel = copy(companyCode = Some(value))
  def withDate(value: Date): CreateMultiDocumentModel = copy(date = value)
  def withSalespersonCode(value: String): CreateMultiDocumentModel = copy(salespersonCode = Some(value))
  def withCustomerCode(value: String): CreateMultiDocumentModel = copy(customerCode = value)
  def withCustomerUsageType(value: String): CreateMultiDocumentModel = copy(customerUsageType = Some(value))
  def withEntityUseCode(value: String): CreateMultiDocumentModel = copy(entityUseCode = Some(value))
  def withDiscount(value: BigDecimal): CreateMultiDocumentModel = copy(discount = Some(value))
  def withPurchaseOrderNo(value: String): CreateMultiDocumentModel = copy(purchaseOrderNo = Some(value))
  def withExemptionNo(value: String): CreateMultiDocumentModel = copy(exemptionNo = Some(value))
  def withAddresses(value: AddressesModel): CreateMultiDocumentModel = copy(addresses = Some(value))
  def withParameters(value: Map[String, String]): CreateMultiDocumentModel = copy(parameters = Some(value))
  def withReferenceCode(value: String): CreateMultiDocumentModel = copy(referenceCode = Some(value))
  def withReportingLocationCode(value: String): CreateMultiDocumentModel = copy(reportingLocationCode = Some(value))
  def withCommit(value: Boolean): CreateMultiDocumentModel = copy(commit = Some(value))
  def withBatchCode(value: String): CreateMultiDocumentModel = copy(batchCode = Some(value))
  def withTaxOverride(value: TaxOverrideModel): CreateMultiDocumentModel = copy(taxOverride = Some(value))
  def withCurrencyCode(value: String): CreateMultiDocumentModel = copy(currencyCode = Some(value))
  def withServiceMode(value: ServiceMode): CreateMultiDocumentModel = copy(serviceMode = Some(value))
  def withExchangeRate(value: BigDecimal): CreateMultiDocumentModel = copy(exchangeRate = Some(value))
  def withExchangeRateEffectiveDate(value: Date): CreateMultiDocumentModel = copy(exchangeRateEffectiveDate = Some(value))
  def withPosLaneCode(value: String): CreateMultiDocumentModel = copy(posLaneCode = Some(value))
  def withBusinessIdentificationNo(value: String): CreateMultiDocumentModel = copy(businessIdentificationNo = Some(value))
  def withIsSellerImporterOfRecord(value: Boolean): CreateMultiDocumentModel = copy(isSellerImporterOfRecord = Some(value))
  def withDescription(value: String): CreateMultiDocumentModel = copy(description = Some(value))
  def withEmail(value: String): CreateMultiDocumentModel = copy(email = Some(value))
  def withDebugLevel(value: TaxDebugLevel): CreateMultiDocumentModel = copy(debugLevel = Some(value))
}
