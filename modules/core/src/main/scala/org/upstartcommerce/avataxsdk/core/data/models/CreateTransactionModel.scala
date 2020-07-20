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
import java.time.Instant

import org.upstartcommerce.avataxsdk.core.data.enums._

final case class CreateTransactionModel(
    code: Option[String] = None,
    lines: List[LineItemModel],
    `type`: Option[DocumentType] = None,
    companyCode: Option[String] = None,
    date: Instant,
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
  def withCode(value: String): CreateTransactionModel = copy(code = Some(value))
  def withLines(value: List[LineItemModel]): CreateTransactionModel = copy(lines = value)
  def withType(value: DocumentType): CreateTransactionModel = copy(`type` = Some(value))
  def withCompanyCode(value: String): CreateTransactionModel = copy(companyCode = Some(value))
  def withDate(value: Instant): CreateTransactionModel = copy(date = value)
  def withSalespersonCode(value: String): CreateTransactionModel = copy(salespersonCode = Some(value))
  def withCustomerCode(value: String): CreateTransactionModel = copy(customerCode = value)
  def withCustomerUsageType(value: String): CreateTransactionModel = copy(customerUsageType = Some(value))
  def withEntityUseCode(value: String): CreateTransactionModel = copy(entityUseCode = Some(value))
  def withDiscount(value: BigDecimal): CreateTransactionModel = copy(discount = Some(value))
  def withPurchaseOrderNo(value: String): CreateTransactionModel = copy(purchaseOrderNo = Some(value))
  def withExemptionNo(value: String): CreateTransactionModel = copy(exemptionNo = Some(value))
  def withAddresses(value: AddressesModel): CreateTransactionModel = copy(addresses = Some(value))
  def withParameters(value: Map[String, String]): CreateTransactionModel = copy(parameters = Some(value))
  def withReferenceCode(value: String): CreateTransactionModel = copy(referenceCode = Some(value))
  def withReportingLocationCode(value: String): CreateTransactionModel = copy(reportingLocationCode = Some(value))
  def withCommit(value: Boolean): CreateTransactionModel = copy(commit = Some(value))
  def withBatchCode(value: String): CreateTransactionModel = copy(batchCode = Some(value))
  def withTaxOverride(value: TaxOverrideModel): CreateTransactionModel = copy(taxOverride = Some(value))
  def withCurrencyCode(value: String): CreateTransactionModel = copy(currencyCode = Some(value))
  def withServiceMode(value: ServiceMode): CreateTransactionModel = copy(serviceMode = Some(value))
  def withExchangeRate(value: BigDecimal): CreateTransactionModel = copy(exchangeRate = Some(value))
  def withExchangeRateEffectiveDate(value: Date): CreateTransactionModel = copy(exchangeRateEffectiveDate = Some(value))
  def withPosLaneCode(value: String): CreateTransactionModel = copy(posLaneCode = Some(value))
  def withBusinessIdentificationNo(value: String): CreateTransactionModel = copy(businessIdentificationNo = Some(value))
  def withIsSellerImporterOfRecord(value: Boolean): CreateTransactionModel = copy(isSellerImporterOfRecord = Some(value))
  def withDescription(value: String): CreateTransactionModel = copy(description = Some(value))
  def withEmail(value: String): CreateTransactionModel = copy(email = Some(value))
  def withDebugLevel(value: TaxDebugLevel): CreateTransactionModel = copy(debugLevel = Some(value))
}
