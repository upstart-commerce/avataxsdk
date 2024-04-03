/* Copyright 2024 UpStart Commerce, Inc.
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

package org.upstartcommerce.avataxsdk.client.pekko.api.accounts

import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.http.scaladsl.model.HttpMethods._
import org.apache.pekko.http.scaladsl.model._
import org.apache.pekko.http.scaladsl.model.headers.Authorization
import org.apache.pekko.stream.Materializer
import org.upstartcommerce.avataxsdk.client.pekko._
import org.upstartcommerce.avataxsdk.client.pekko.api._
import org.upstartcommerce.avataxsdk.client.pekko.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import org.upstartcommerce.avataxsdk.client.pekko.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.pekko.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import org.upstartcommerce.avataxsdk.client.api.accounts.AccountSubscriptionsRootApi
import org.upstartcommerce.avataxsdk.client.api.accounts.AccountSubscriptionsApi
import scala.concurrent.Future

object AccountSubscriptionsRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      accountId: Int
  )(implicit system: ActorSystem, materializer: Materializer): AccountSubscriptionsRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with AccountSubscriptionsRootApi[Future, Stream] {
      def forId(subscriptionId: Int): AccountSubscriptionsApi[Future, Stream] =
        AccountSubscriptionsApiImpl(requester, security, clientHeaders)(accountId, subscriptionId)

      def create(model: List[SubscriptionModel]): AvataxSimpleCall[List[SubscriptionModel]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/subscriptions")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[SubscriptionModel], List[SubscriptionModel]](req, model)
      }

      def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[SubscriptionModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/subscriptions").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[SubscriptionModel](req)
      }
    }
}

object AccountSubscriptionsApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      accountId: Int,
      subscriptionId: Int
  )(implicit system: ActorSystem, materializer: Materializer): AccountSubscriptionsApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with AccountSubscriptionsApi[Future, Stream] {
      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/subscriptions/$subscriptionId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def update(model: SubscriptionModel): AvataxSimpleCall[SubscriptionModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/subscriptions/$subscriptionId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[SubscriptionModel, SubscriptionModel](req, model)
      }

      def get: AvataxSimpleCall[SubscriptionModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/subscriptions/$subscriptionId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[SubscriptionModel](req)
      }
    }
}
