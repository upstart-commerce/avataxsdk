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
import java.time.Instant

final case class CycleEditOptionModel(
    success: Option[Boolean] = None,
    message: Option[String] = None,
    customerMustApprove: Option[Boolean] = None,
    mustCloneFilingCalendar: Option[Boolean] = None,
    clonedCalendarEffDate: Option[Instant] = None,
    expiredCalendarEndDate: Option[Instant] = None
) {

  def withSuccess(value: Boolean): CycleEditOptionModel = copy(success = Some(value))
  def withMessage(value: String): CycleEditOptionModel = copy(message = Some(value))
  def withCustomerMustApprove(value: Boolean): CycleEditOptionModel = copy(customerMustApprove = Some(value))
  def withMustCloneFilingCalendar(value: Boolean): CycleEditOptionModel = copy(mustCloneFilingCalendar = Some(value))
  def withClonedCalendarEffDate(value: Instant): CycleEditOptionModel = copy(clonedCalendarEffDate = Some(value))
  def withExpiredCalendarEndDate(value: Instant): CycleEditOptionModel = copy(expiredCalendarEndDate = Some(value))
}
