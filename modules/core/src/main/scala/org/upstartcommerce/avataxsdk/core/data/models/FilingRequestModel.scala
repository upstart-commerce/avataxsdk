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

final case class FilingRequestModel(
    id: Option[Long] = None,
    companyId: Int,
    filingRequestStatusId: Option[FilingRequestStatus] = None,
    data: FilingRequestDataModel,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None
) {

  def withId(value: Long): FilingRequestModel = copy(id = Some(value))
  def withCompanyId(value: Int): FilingRequestModel = copy(companyId = value)
  def withFilingRequestStatusId(value: FilingRequestStatus): FilingRequestModel = copy(filingRequestStatusId = Some(value))
  def withData(value: FilingRequestDataModel): FilingRequestModel = copy(data = value)
  def withCreatedDate(value: Date): FilingRequestModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): FilingRequestModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): FilingRequestModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): FilingRequestModel = copy(modifiedUserId = Some(value))
}
