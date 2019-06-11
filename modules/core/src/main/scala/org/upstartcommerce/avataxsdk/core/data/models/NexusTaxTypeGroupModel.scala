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

final case class NexusTaxTypeGroupModel(id: Option[Int] = None, nexusTaxTypeGroupId: Option[String] = None, description: Option[String] = None, subscriptionTypeId: Option[Int] = None, subscriptionDescription: Option[String] = None, tabName: Option[String] = None, showColumn: Option[Boolean] = None) {

  def withId(value: Int): NexusTaxTypeGroupModel = copy(id = Some(value))

  def withNexusTaxTypeGroupId(value: String): NexusTaxTypeGroupModel = copy(nexusTaxTypeGroupId = Some(value))

  def withDescription(value: String): NexusTaxTypeGroupModel = copy(description = Some(value))

  def withSubscriptionTypeId(value: Int): NexusTaxTypeGroupModel = copy(subscriptionTypeId = Some(value))

  def withSubscriptionDescription(value: String): NexusTaxTypeGroupModel = copy(subscriptionDescription = Some(value))

  def withTabName(value: String): NexusTaxTypeGroupModel = copy(tabName = Some(value))

  def withShowColumn(value: Boolean): NexusTaxTypeGroupModel = copy(showColumn = Some(value))
}
  