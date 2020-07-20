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

final case class AvaFileFormModel(
    id: Option[Int] = None,
    returnName: Option[String] = None,
    formName: Option[String] = None,
    description: Option[String] = None,
    effDate: Option[Date] = None,
    endDate: Option[Date] = None,
    region: Option[String] = None,
    country: Option[String] = None,
    formTypeId: Option[FormTypeId] = None,
    filingOptionTypeId: Option[FilingOptionTypeId] = None,
    dueDateTypeId: Option[DueDateTypeId] = None,
    dueDay: Option[Int] = None,
    efileDueDateTypeId: Option[DueDateTypeId] = None,
    efileDueDay: Option[Int] = None,
    efileDueTime: Option[Date] = None,
    hasVendorDiscount: Option[Boolean] = None,
    roundingTypeId: Option[RoundingTypeId] = None,
    outletTypeId: Option[OutletTypeId] = None
) {

  def withId(value: Int): AvaFileFormModel = copy(id = Some(value))
  def withReturnName(value: String): AvaFileFormModel = copy(returnName = Some(value))
  def withFormName(value: String): AvaFileFormModel = copy(formName = Some(value))
  def withDescription(value: String): AvaFileFormModel = copy(description = Some(value))
  def withEffDate(value: Date): AvaFileFormModel = copy(effDate = Some(value))
  def withEndDate(value: Date): AvaFileFormModel = copy(endDate = Some(value))
  def withRegion(value: String): AvaFileFormModel = copy(region = Some(value))
  def withCountry(value: String): AvaFileFormModel = copy(country = Some(value))
  def withFormTypeId(value: FormTypeId): AvaFileFormModel = copy(formTypeId = Some(value))
  def withFilingOptionTypeId(value: FilingOptionTypeId): AvaFileFormModel = copy(filingOptionTypeId = Some(value))
  def withDueDateTypeId(value: DueDateTypeId): AvaFileFormModel = copy(dueDateTypeId = Some(value))
  def withDueDay(value: Int): AvaFileFormModel = copy(dueDay = Some(value))
  def withEfileDueDateTypeId(value: DueDateTypeId): AvaFileFormModel = copy(efileDueDateTypeId = Some(value))
  def withEfileDueDay(value: Int): AvaFileFormModel = copy(efileDueDay = Some(value))
  def withEfileDueTime(value: Date): AvaFileFormModel = copy(efileDueTime = Some(value))
  def withHasVendorDiscount(value: Boolean): AvaFileFormModel = copy(hasVendorDiscount = Some(value))
  def withRoundingTypeId(value: RoundingTypeId): AvaFileFormModel = copy(roundingTypeId = Some(value))
  def withOutletTypeId(value: OutletTypeId): AvaFileFormModel = copy(outletTypeId = Some(value))
}
