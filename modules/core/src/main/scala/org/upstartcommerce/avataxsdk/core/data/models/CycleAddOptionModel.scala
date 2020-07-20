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

final case class CycleAddOptionModel(
    available: Option[Boolean] = None,
    transactionalPeriodStart: Option[Date] = None,
    transactionalPeriodEnd: Option[Date] = None,
    filingDueDate: Option[Date] = None,
    cycleName: Option[String] = None,
    frequencyName: Option[String] = None,
    filingFrequencyCode: Option[String] = None,
    filingFrequencyId: Option[FilingFrequencyId] = None,
    cycleUnavailableReason: Option[String] = None,
    availableLocationCodes: Option[List[String]] = None
) {
  lazy val availableLocationCodesRaw: List[String] = availableLocationCodes.getOrElse(List.empty)
  def withAvailable(value: Boolean): CycleAddOptionModel = copy(available = Some(value))
  def withTransactionalPeriodStart(value: Date): CycleAddOptionModel = copy(transactionalPeriodStart = Some(value))
  def withTransactionalPeriodEnd(value: Date): CycleAddOptionModel = copy(transactionalPeriodEnd = Some(value))
  def withFilingDueDate(value: Date): CycleAddOptionModel = copy(filingDueDate = Some(value))
  def withCycleName(value: String): CycleAddOptionModel = copy(cycleName = Some(value))
  def withFrequencyName(value: String): CycleAddOptionModel = copy(frequencyName = Some(value))
  def withFilingFrequencyCode(value: String): CycleAddOptionModel = copy(filingFrequencyCode = Some(value))
  def withFilingFrequencyId(value: FilingFrequencyId): CycleAddOptionModel = copy(filingFrequencyId = Some(value))
  def withCycleUnavailableReason(value: String): CycleAddOptionModel = copy(cycleUnavailableReason = Some(value))
  def withAvailableLocationCodes(value: List[String]): CycleAddOptionModel = copy(availableLocationCodes = Some(value))
}
