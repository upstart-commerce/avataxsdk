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

final case class MultiCompanyLineItemModel(
    companyCode: Option[String] = None,
    reportingLocationCode: Option[String] = None,
    number: Option[String] = None,
    quantity: Option[BigDecimal] = None,
    amount: BigDecimal,
    addresses: Option[AddressesModel] = None,
    taxCode: Option[String] = None,
    customerUsageType: Option[String] = None,
    itemCode: Option[String] = None,
    exemptionCode: Option[String] = None,
    discounted: Option[Boolean] = None,
    taxIncluded: Option[Boolean] = None,
    revenueAccount: Option[String] = None,
    ref1: Option[String] = None,
    ref2: Option[String] = None,
    description: Option[String] = None,
    businessIdentificationNo: Option[String] = None,
    taxOverride: Option[TaxOverrideModel] = None,
    parameters: Option[Map[String, String]] = None
) {
  lazy val parametersRaw: Map[String, String] = parameters.getOrElse(Map.empty)
  def withCompanyCode(value: String): MultiCompanyLineItemModel = copy(companyCode = Some(value))
  def withReportingLocationCode(value: String): MultiCompanyLineItemModel = copy(reportingLocationCode = Some(value))
  def withNumber(value: String): MultiCompanyLineItemModel = copy(number = Some(value))
  def withQuantity(value: BigDecimal): MultiCompanyLineItemModel = copy(quantity = Some(value))
  def withAmount(value: BigDecimal): MultiCompanyLineItemModel = copy(amount = value)
  def withAddresses(value: AddressesModel): MultiCompanyLineItemModel = copy(addresses = Some(value))
  def withTaxCode(value: String): MultiCompanyLineItemModel = copy(taxCode = Some(value))
  def withCustomerUsageType(value: String): MultiCompanyLineItemModel = copy(customerUsageType = Some(value))
  def withItemCode(value: String): MultiCompanyLineItemModel = copy(itemCode = Some(value))
  def withExemptionCode(value: String): MultiCompanyLineItemModel = copy(exemptionCode = Some(value))
  def withDiscounted(value: Boolean): MultiCompanyLineItemModel = copy(discounted = Some(value))
  def withTaxIncluded(value: Boolean): MultiCompanyLineItemModel = copy(taxIncluded = Some(value))
  def withRevenueAccount(value: String): MultiCompanyLineItemModel = copy(revenueAccount = Some(value))
  def withRef1(value: String): MultiCompanyLineItemModel = copy(ref1 = Some(value))
  def withRef2(value: String): MultiCompanyLineItemModel = copy(ref2 = Some(value))
  def withDescription(value: String): MultiCompanyLineItemModel = copy(description = Some(value))
  def withBusinessIdentificationNo(value: String): MultiCompanyLineItemModel = copy(businessIdentificationNo = Some(value))
  def withTaxOverride(value: TaxOverrideModel): MultiCompanyLineItemModel = copy(taxOverride = Some(value))
  def withParameters(value: Map[String, String]): MultiCompanyLineItemModel = copy(parameters = Some(value))
}
