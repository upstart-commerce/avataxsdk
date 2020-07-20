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

final case class FilingPaymentModel(
    id: Option[Long] = None,
    filingId: Option[Long] = None,
    paymentAmount: BigDecimal,
    `type`: PaymentType,
    isCalculated: Option[Boolean] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None
) {

  def withId(value: Long): FilingPaymentModel = copy(id = Some(value))
  def withFilingId(value: Long): FilingPaymentModel = copy(filingId = Some(value))
  def withPaymentAmount(value: BigDecimal): FilingPaymentModel = copy(paymentAmount = value)
  def withType(value: PaymentType): FilingPaymentModel = copy(`type` = value)
  def withIsCalculated(value: Boolean): FilingPaymentModel = copy(isCalculated = Some(value))
  def withCreatedDate(value: Date): FilingPaymentModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): FilingPaymentModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): FilingPaymentModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): FilingPaymentModel = copy(modifiedUserId = Some(value))
}
