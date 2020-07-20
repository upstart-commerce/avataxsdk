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

final case class VerifyMultiDocumentModel(
    code: String,
    `type`: DocumentType,
    verifyTransactionDate: Option[Date] = None,
    verifyTotalAmount: Option[BigDecimal] = None,
    verifyTotalTax: Option[BigDecimal] = None
) {

  def withCode(value: String): VerifyMultiDocumentModel = copy(code = value)
  def withType(value: DocumentType): VerifyMultiDocumentModel = copy(`type` = value)
  def withVerifyTransactionDate(value: Date): VerifyMultiDocumentModel = copy(verifyTransactionDate = Some(value))
  def withVerifyTotalAmount(value: BigDecimal): VerifyMultiDocumentModel = copy(verifyTotalAmount = Some(value))
  def withVerifyTotalTax(value: BigDecimal): VerifyMultiDocumentModel = copy(verifyTotalTax = Some(value))
}
