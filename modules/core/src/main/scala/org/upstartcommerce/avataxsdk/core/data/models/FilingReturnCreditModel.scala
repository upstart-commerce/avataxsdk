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

final case class FilingReturnCreditModel(totalSales: Option[BigDecimal] = None, totalExempt: Option[BigDecimal] = None, totalTaxable: Option[BigDecimal] = None, totalTax: Option[BigDecimal] = None, transactionDetails: Option[List[WorksheetDocument]] = None) {
  lazy val transactionDetailsRaw: List[WorksheetDocument] = transactionDetails.getOrElse(List.empty)

  def withTotalSales(value: BigDecimal): FilingReturnCreditModel = copy(totalSales = Some(value))

  def withTotalExempt(value: BigDecimal): FilingReturnCreditModel = copy(totalExempt = Some(value))

  def withTotalTaxable(value: BigDecimal): FilingReturnCreditModel = copy(totalTaxable = Some(value))

  def withTotalTax(value: BigDecimal): FilingReturnCreditModel = copy(totalTax = Some(value))

  def withTransactionDetails(value: List[WorksheetDocument]): FilingReturnCreditModel = copy(transactionDetails = Some(value))
}
  