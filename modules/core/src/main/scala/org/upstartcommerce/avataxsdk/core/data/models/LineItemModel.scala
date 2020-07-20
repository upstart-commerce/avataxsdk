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

final case class LineItemModel(
    number: Option[String] = None,
    quantity: Option[BigDecimal] = None,
    amount: BigDecimal,
    addresses: Option[AddressesModel] = None,
    taxCode: Option[String] = None,
    customerUsageType: Option[String] = None,
    entityUseCode: Option[String] = None,
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
    parameters: Option[Map[String, String]] = None,
    hsCode: Option[String] = None
) {
  lazy val parametersRaw: Map[String, String] = parameters.getOrElse(Map.empty)
  def withNumber(value: String): LineItemModel = copy(number = Some(value))
  def withQuantity(value: BigDecimal): LineItemModel = copy(quantity = Some(value))
  def withAmount(value: BigDecimal): LineItemModel = copy(amount = value)
  def withAddresses(value: AddressesModel): LineItemModel = copy(addresses = Some(value))
  def withTaxCode(value: String): LineItemModel = copy(taxCode = Some(value))
  def withCustomerUsageType(value: String): LineItemModel = copy(customerUsageType = Some(value))
  def withEntityUseCode(value: String): LineItemModel = copy(entityUseCode = Some(value))
  def withItemCode(value: String): LineItemModel = copy(itemCode = Some(value))
  def withExemptionCode(value: String): LineItemModel = copy(exemptionCode = Some(value))
  def withDiscounted(value: Boolean): LineItemModel = copy(discounted = Some(value))
  def withTaxIncluded(value: Boolean): LineItemModel = copy(taxIncluded = Some(value))
  def withRevenueAccount(value: String): LineItemModel = copy(revenueAccount = Some(value))
  def withRef1(value: String): LineItemModel = copy(ref1 = Some(value))
  def withRef2(value: String): LineItemModel = copy(ref2 = Some(value))
  def withDescription(value: String): LineItemModel = copy(description = Some(value))
  def withBusinessIdentificationNo(value: String): LineItemModel = copy(businessIdentificationNo = Some(value))
  def withTaxOverride(value: TaxOverrideModel): LineItemModel = copy(taxOverride = Some(value))
  def withParameters(value: Map[String, String]): LineItemModel = copy(parameters = Some(value))
  def withHsCode(value: String): LineItemModel = copy(hsCode = Some(value))
}
