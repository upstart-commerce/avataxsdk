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

final case class WorksheetDocumentLine(
    reportingDate: Option[Date] = None,
    lineNo: Option[String] = None,
    lineAmount: Option[BigDecimal] = None,
    exemptAmount: Option[BigDecimal] = None,
    taxableAmount: Option[BigDecimal] = None,
    taxAmount: Option[BigDecimal] = None,
    messages: Option[List[Message]] = None,
    resultCode: Option[String] = None,
    transactionId: Option[String] = None
) {
  lazy val messagesRaw: List[Message] = messages.getOrElse(List.empty)
  def withReportingDate(value: Date): WorksheetDocumentLine = copy(reportingDate = Some(value))
  def withLineNo(value: String): WorksheetDocumentLine = copy(lineNo = Some(value))
  def withLineAmount(value: BigDecimal): WorksheetDocumentLine = copy(lineAmount = Some(value))
  def withExemptAmount(value: BigDecimal): WorksheetDocumentLine = copy(exemptAmount = Some(value))
  def withTaxableAmount(value: BigDecimal): WorksheetDocumentLine = copy(taxableAmount = Some(value))
  def withTaxAmount(value: BigDecimal): WorksheetDocumentLine = copy(taxAmount = Some(value))
  def withMessages(value: List[Message]): WorksheetDocumentLine = copy(messages = Some(value))
  def withResultCode(value: String): WorksheetDocumentLine = copy(resultCode = Some(value))
  def withTransactionId(value: String): WorksheetDocumentLine = copy(transactionId = Some(value))
}
