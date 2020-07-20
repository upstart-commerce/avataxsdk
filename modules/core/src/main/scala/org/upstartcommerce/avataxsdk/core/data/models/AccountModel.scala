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

final case class AccountModel(
    id: Int,
    crmid: Option[String] = None,
    name: String,
    effectiveDate: Option[Date] = None,
    endDate: Option[Date] = None,
    accountStatusId: Option[AccountStatusId] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None,
    subscriptions: Option[List[SubscriptionModel]] = None,
    users: Option[List[UserModel]] = None
) {
  lazy val subscriptionsRaw: List[SubscriptionModel] = subscriptions.getOrElse(List.empty)
  lazy val usersRaw: List[UserModel] = users.getOrElse(List.empty)
  def withId(value: Int): AccountModel = copy(id = value)
  def withCrmid(value: String): AccountModel = copy(crmid = Some(value))
  def withName(value: String): AccountModel = copy(name = value)
  def withEffectiveDate(value: Date): AccountModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Date): AccountModel = copy(endDate = Some(value))
  def withAccountStatusId(value: AccountStatusId): AccountModel = copy(accountStatusId = Some(value))
  def withCreatedDate(value: Date): AccountModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): AccountModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): AccountModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): AccountModel = copy(modifiedUserId = Some(value))
  def withSubscriptions(value: List[SubscriptionModel]): AccountModel = copy(subscriptions = Some(value))
  def withUsers(value: List[UserModel]): AccountModel = copy(users = Some(value))
}
