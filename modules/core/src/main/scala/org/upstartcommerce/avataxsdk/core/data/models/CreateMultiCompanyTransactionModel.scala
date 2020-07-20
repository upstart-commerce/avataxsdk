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

final case class CreateMultiCompanyTransactionModel(
    code: Option[String] = None,
    lines: Option[List[MultiCompanyLineItemModel]] = None,
    `type`: Option[DocumentType] = None,
    companyCode: Option[String] = None,
    date: Option[Date] = None,
    salespersonCode: Option[String] = None,
    customerCode: Option[String] = None,
    customerUsageType: Option[String] = None,
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
  lazy val linesRaw: List[MultiCompanyLineItemModel] = lines.getOrElse(List.empty)
  lazy val parametersRaw: Map[String, String] = parameters.getOrElse(Map.empty)
  def withCode(value: String): CreateMultiCompanyTransactionModel = copy(code = Some(value))
  def withLines(value: List[MultiCompanyLineItemModel]): CreateMultiCompanyTransactionModel = copy(lines = Some(value))
  def withType(value: DocumentType): CreateMultiCompanyTransactionModel = copy(`type` = Some(value))
  def withCompanyCode(value: String): CreateMultiCompanyTransactionModel = copy(companyCode = Some(value))
  def withDate(value: Date): CreateMultiCompanyTransactionModel = copy(date = Some(value))
  def withSalespersonCode(value: String): CreateMultiCompanyTransactionModel = copy(salespersonCode = Some(value))
  def withCustomerCode(value: String): CreateMultiCompanyTransactionModel = copy(customerCode = Some(value))
  def withCustomerUsageType(value: String): CreateMultiCompanyTransactionModel = copy(customerUsageType = Some(value))
  def withDiscount(value: BigDecimal): CreateMultiCompanyTransactionModel = copy(discount = Some(value))
  def withPurchaseOrderNo(value: String): CreateMultiCompanyTransactionModel = copy(purchaseOrderNo = Some(value))
  def withExemptionNo(value: String): CreateMultiCompanyTransactionModel = copy(exemptionNo = Some(value))
  def withAddresses(value: AddressesModel): CreateMultiCompanyTransactionModel = copy(addresses = Some(value))
  def withParameters(value: Map[String, String]): CreateMultiCompanyTransactionModel = copy(parameters = Some(value))
  def withReferenceCode(value: String): CreateMultiCompanyTransactionModel = copy(referenceCode = Some(value))
  def withReportingLocationCode(value: String): CreateMultiCompanyTransactionModel = copy(reportingLocationCode = Some(value))
  def withCommit(value: Boolean): CreateMultiCompanyTransactionModel = copy(commit = Some(value))
  def withBatchCode(value: String): CreateMultiCompanyTransactionModel = copy(batchCode = Some(value))
  def withTaxOverride(value: TaxOverrideModel): CreateMultiCompanyTransactionModel = copy(taxOverride = Some(value))
  def withCurrencyCode(value: String): CreateMultiCompanyTransactionModel = copy(currencyCode = Some(value))
  def withServiceMode(value: ServiceMode): CreateMultiCompanyTransactionModel = copy(serviceMode = Some(value))
  def withExchangeRate(value: BigDecimal): CreateMultiCompanyTransactionModel = copy(exchangeRate = Some(value))
  def withExchangeRateEffectiveDate(value: Date): CreateMultiCompanyTransactionModel = copy(exchangeRateEffectiveDate = Some(value))
  def withPosLaneCode(value: String): CreateMultiCompanyTransactionModel = copy(posLaneCode = Some(value))
  def withBusinessIdentificationNo(value: String): CreateMultiCompanyTransactionModel = copy(businessIdentificationNo = Some(value))
  def withIsSellerImporterOfRecord(value: Boolean): CreateMultiCompanyTransactionModel = copy(isSellerImporterOfRecord = Some(value))
  def withDescription(value: String): CreateMultiCompanyTransactionModel = copy(description = Some(value))
  def withEmail(value: String): CreateMultiCompanyTransactionModel = copy(email = Some(value))
  def withDebugLevel(value: TaxDebugLevel): CreateMultiCompanyTransactionModel = copy(debugLevel = Some(value))
}
