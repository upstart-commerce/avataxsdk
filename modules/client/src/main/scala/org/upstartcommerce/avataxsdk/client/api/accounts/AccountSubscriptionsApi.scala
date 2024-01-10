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

package org.upstartcommerce.avataxsdk.client.api.accounts

import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._

/** /api/v2/accounts/$accountId/subscriptions */
trait AccountSubscriptionsRootApi[F[_], S[_]] {
  def forId(subscriptionId: Int): AccountSubscriptionsApi[F, S]

  def create(model: List[SubscriptionModel]): AvataxSimpleCall[F, List[SubscriptionModel]]
  def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, SubscriptionModel]
}

/** /api/v2/accounts/$accountId/subscriptions/$id */
trait AccountSubscriptionsApi[F[_], S[_]] {
  def delete: AvataxSimpleCall[F, List[ErrorDetail]]
  def update(model: SubscriptionModel): AvataxSimpleCall[F, SubscriptionModel]
  def get: AvataxSimpleCall[F, SubscriptionModel]
}
