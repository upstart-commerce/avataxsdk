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

final case class CompanyReturnSettingModel(
    id: Option[Long] = None,
    companyReturnId: Long,
    filingQuestionId: Long,
    filingQuestionCode: Option[String] = None,
    value: Option[String] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None
) {

  def withId(value: Long): CompanyReturnSettingModel = copy(id = Some(value))
  def withCompanyReturnId(value: Long): CompanyReturnSettingModel = copy(companyReturnId = value)
  def withFilingQuestionId(value: Long): CompanyReturnSettingModel = copy(filingQuestionId = value)
  def withFilingQuestionCode(value: String): CompanyReturnSettingModel = copy(filingQuestionCode = Some(value))
  def withValue(value: String): CompanyReturnSettingModel = copy(value = Some(value))
  def withCreatedDate(value: Date): CompanyReturnSettingModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): CompanyReturnSettingModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): CompanyReturnSettingModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): CompanyReturnSettingModel = copy(modifiedUserId = Some(value))
}
