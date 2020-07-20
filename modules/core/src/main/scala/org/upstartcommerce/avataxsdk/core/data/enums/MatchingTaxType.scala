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

package org.upstartcommerce.avataxsdk.core.data.enums

sealed trait MatchingTaxType
object MatchingTaxType {
  case object All extends MatchingTaxType
  case object BothSalesAndUseTax extends MatchingTaxType
  case object ConsumerUseTax extends MatchingTaxType
  case object SalesTax extends MatchingTaxType
  case object UseTax extends MatchingTaxType
  case object VATOutputTax extends MatchingTaxType
  case object VATInputTax extends MatchingTaxType
  case object VatNonrecoverableInputTax extends MatchingTaxType
  case object Fee extends MatchingTaxType
  case object Rental extends MatchingTaxType
  case object ConsumerUseAndSalesTax extends MatchingTaxType
  case object ConsumerUseAndSellersUseTax extends MatchingTaxType
  case object Excise extends MatchingTaxType
  case object Lodging extends MatchingTaxType
  case object Bottle extends MatchingTaxType
  case object RentToOwn extends MatchingTaxType
}
