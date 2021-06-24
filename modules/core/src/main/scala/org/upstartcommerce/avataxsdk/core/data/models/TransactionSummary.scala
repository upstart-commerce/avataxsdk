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

final case class TransactionSummary(
    country: Option[String] = None,
    region: Option[String] = None,
    jurisType: Option[JurisdictionType] = None,
    jurisCode: Option[String] = None,
    jurisName: Option[String] = None,
    taxAuthorityType: Option[Int] = None,
    stateAssignedNo: Option[String] = None,
    taxType: Option[TaxType] = None,
    taxName: Option[String] = None,
    taxGroup: Option[String] = None,
    rateTypeCode: Option[String] = None,
    taxable: Option[BigDecimal] = None,
    rate: Option[BigDecimal] = None,
    tax: Option[BigDecimal] = None,
    taxCalculated: Option[BigDecimal] = None,
    nonTaxable: Option[BigDecimal] = None,
    exemption: Option[BigDecimal] = None
) {

  def withCountry(value: String): TransactionSummary = copy(country = Some(value))
  def withRegion(value: String): TransactionSummary = copy(region = Some(value))
  def withJurisType(value: JurisdictionType): TransactionSummary = copy(jurisType = Some(value))
  def withJurisCode(value: String): TransactionSummary = copy(jurisCode = Some(value))
  def withJurisName(value: String): TransactionSummary = copy(jurisName = Some(value))
  def withTaxAuthorityType(value: Int): TransactionSummary = copy(taxAuthorityType = Some(value))
  def withStateAssignedNo(value: String): TransactionSummary = copy(stateAssignedNo = Some(value))
  def withTaxType(value: TaxType): TransactionSummary = copy(taxType = Some(value))
  def withTaxName(value: String): TransactionSummary = copy(taxName = Some(value))
  def withTaxGroup(value: String): TransactionSummary = copy(taxGroup = Some(value))
  def withRateTypeCode(value: String): TransactionSummary = copy(rateTypeCode = Some(value))
  def withTaxable(value: BigDecimal): TransactionSummary = copy(taxable = Some(value))
  def withRate(value: BigDecimal): TransactionSummary = copy(rate = Some(value))
  def withTax(value: BigDecimal): TransactionSummary = copy(tax = Some(value))
  def withTaxCalculated(value: BigDecimal): TransactionSummary = copy(taxCalculated = Some(value))
  def withNonTaxable(value: BigDecimal): TransactionSummary = copy(nonTaxable = Some(value))
  def withExemption(value: BigDecimal): TransactionSummary = copy(exemption = Some(value))
}
