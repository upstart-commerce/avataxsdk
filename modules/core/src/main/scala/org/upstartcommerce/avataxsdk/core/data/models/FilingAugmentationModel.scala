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

final case class FilingAugmentationModel(
    id: Option[Long] = None,
    filingId: Option[Long] = None,
    fieldAmount: BigDecimal,
    fieldName: String,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None
) {

  def withId(value: Long): FilingAugmentationModel = copy(id = Some(value))
  def withFilingId(value: Long): FilingAugmentationModel = copy(filingId = Some(value))
  def withFieldAmount(value: BigDecimal): FilingAugmentationModel = copy(fieldAmount = value)
  def withFieldName(value: String): FilingAugmentationModel = copy(fieldName = value)
  def withCreatedDate(value: Date): FilingAugmentationModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): FilingAugmentationModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): FilingAugmentationModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): FilingAugmentationModel = copy(modifiedUserId = Some(value))
}
