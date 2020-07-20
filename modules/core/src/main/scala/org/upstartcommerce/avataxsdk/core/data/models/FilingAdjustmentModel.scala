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

final case class FilingAdjustmentModel(
    id: Option[Long] = None,
    filingId: Long,
    amount: Option[BigDecimal] = None,
    period: AdjustmentPeriodTypeId,
    `type`: String,
    isCalculated: Option[Boolean] = None,
    accountType: PaymentAccountTypeId,
    reason: Option[String] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None
) {

  def withId(value: Long): FilingAdjustmentModel = copy(id = Some(value))
  def withFilingId(value: Long): FilingAdjustmentModel = copy(filingId = value)
  def withAmount(value: BigDecimal): FilingAdjustmentModel = copy(amount = Some(value))
  def withPeriod(value: AdjustmentPeriodTypeId): FilingAdjustmentModel = copy(period = value)
  def withType(value: String): FilingAdjustmentModel = copy(`type` = value)
  def withIsCalculated(value: Boolean): FilingAdjustmentModel = copy(isCalculated = Some(value))
  def withAccountType(value: PaymentAccountTypeId): FilingAdjustmentModel = copy(accountType = value)
  def withReason(value: String): FilingAdjustmentModel = copy(reason = Some(value))
  def withCreatedDate(value: Date): FilingAdjustmentModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): FilingAdjustmentModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): FilingAdjustmentModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): FilingAdjustmentModel = copy(modifiedUserId = Some(value))
}
