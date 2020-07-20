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

final case class UserModel(
    id: Int,
    accountId: Int,
    companyId: Option[Int] = None,
    userName: String,
    firstName: String,
    lastName: String,
    email: String,
    postalCode: Option[String] = None,
    securityRoleId: SecurityRoleId,
    passwordStatus: Option[PasswordStatusId] = None,
    isActive: Option[Boolean] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None
) {

  def withId(value: Int): UserModel = copy(id = value)
  def withAccountId(value: Int): UserModel = copy(accountId = value)
  def withCompanyId(value: Int): UserModel = copy(companyId = Some(value))
  def withUserName(value: String): UserModel = copy(userName = value)
  def withFirstName(value: String): UserModel = copy(firstName = value)
  def withLastName(value: String): UserModel = copy(lastName = value)
  def withEmail(value: String): UserModel = copy(email = value)
  def withPostalCode(value: String): UserModel = copy(postalCode = Some(value))
  def withSecurityRoleId(value: SecurityRoleId): UserModel = copy(securityRoleId = value)
  def withPasswordStatus(value: PasswordStatusId): UserModel = copy(passwordStatus = Some(value))
  def withIsActive(value: Boolean): UserModel = copy(isActive = Some(value))
  def withCreatedDate(value: Date): UserModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): UserModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): UserModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): UserModel = copy(modifiedUserId = Some(value))
}
