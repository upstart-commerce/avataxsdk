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

final case class CompanyConfigurationModel(
    companyId: Option[Int] = None,
    category: String,
    name: String,
    value: Option[String] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None
) {

  def withCompanyId(value: Int): CompanyConfigurationModel = copy(companyId = Some(value))
  def withCategory(value: String): CompanyConfigurationModel = copy(category = value)
  def withName(value: String): CompanyConfigurationModel = copy(name = value)
  def withValue(value: String): CompanyConfigurationModel = copy(value = Some(value))
  def withCreatedDate(value: Date): CompanyConfigurationModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): CompanyConfigurationModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): CompanyConfigurationModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): CompanyConfigurationModel = copy(modifiedUserId = Some(value))
}
