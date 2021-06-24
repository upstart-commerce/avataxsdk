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

final case class CycleExpireOptionModel(
    transactionalPeriodStart: Option[Instant] = None,
    transactionalPeriodEnd: Option[Instant] = None,
    filingDueDate: Option[Instant] = None,
    cycleName: Option[String] = None
) {

  def withTransactionalPeriodStart(value: Instant): CycleExpireOptionModel = copy(transactionalPeriodStart = Some(value))
  def withTransactionalPeriodEnd(value: Instant): CycleExpireOptionModel = copy(transactionalPeriodEnd = Some(value))
  def withFilingDueDate(value: Instant): CycleExpireOptionModel = copy(filingDueDate = Some(value))
  def withCycleName(value: String): CycleExpireOptionModel = copy(cycleName = Some(value))
}
