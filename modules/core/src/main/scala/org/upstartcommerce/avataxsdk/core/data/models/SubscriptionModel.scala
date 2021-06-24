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

final case class SubscriptionModel(
    id: Option[Int] = None,
    accountId: Option[Int] = None,
    subscriptionTypeId: Option[Int] = None,
    subscriptionDescription: Option[String] = None,
    effectiveDate: Option[Instant] = None,
    endDate: Option[Instant] = None,
    createdDate: Option[Instant] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Instant] = None,
    modifiedUserId: Option[Int] = None
) {

  def withId(value: Int): SubscriptionModel = copy(id = Some(value))
  def withAccountId(value: Int): SubscriptionModel = copy(accountId = Some(value))
  def withSubscriptionTypeId(value: Int): SubscriptionModel = copy(subscriptionTypeId = Some(value))
  def withSubscriptionDescription(value: String): SubscriptionModel = copy(subscriptionDescription = Some(value))
  def withEffectiveDate(value: Instant): SubscriptionModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Instant): SubscriptionModel = copy(endDate = Some(value))
  def withCreatedDate(value: Instant): SubscriptionModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): SubscriptionModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Instant): SubscriptionModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): SubscriptionModel = copy(modifiedUserId = Some(value))
}
