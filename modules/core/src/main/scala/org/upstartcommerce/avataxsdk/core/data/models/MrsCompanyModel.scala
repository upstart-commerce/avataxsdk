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

final case class MrsCompanyModel(
    companyId: Option[Int] = None,
    companyName: Option[String] = None,
    accountId: Option[Int] = None,
    accountName: Option[String] = None,
    tin: Option[String] = None,
    companyCode: Option[String] = None,
    createdDate: Option[Instant] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Instant] = None,
    modifiedUserId: Option[Int] = None
) {

  def withCompanyId(value: Int): MrsCompanyModel = copy(companyId = Some(value))
  def withCompanyName(value: String): MrsCompanyModel = copy(companyName = Some(value))
  def withAccountId(value: Int): MrsCompanyModel = copy(accountId = Some(value))
  def withAccountName(value: String): MrsCompanyModel = copy(accountName = Some(value))
  def withTin(value: String): MrsCompanyModel = copy(tin = Some(value))
  def withCompanyCode(value: String): MrsCompanyModel = copy(companyCode = Some(value))
  def withCreatedDate(value: Instant): MrsCompanyModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): MrsCompanyModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Instant): MrsCompanyModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): MrsCompanyModel = copy(modifiedUserId = Some(value))
}
