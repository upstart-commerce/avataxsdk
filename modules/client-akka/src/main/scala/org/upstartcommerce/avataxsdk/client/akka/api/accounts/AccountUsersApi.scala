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

package org.upstartcommerce.avataxsdk.client.akka.api.accounts

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers.Authorization
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client.akka._
import org.upstartcommerce.avataxsdk.client.akka.api._
import org.upstartcommerce.avataxsdk.client.akka.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import org.upstartcommerce.avataxsdk.client.api.accounts.AccountUsersRootApi
import org.upstartcommerce.avataxsdk.client.api.accounts.AccountUsersApi
import scala.concurrent.Future

object AccountUsersRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      accountId: Int
  )(implicit system: ActorSystem, materializer: Materializer): AccountUsersRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with AccountUsersRootApi[Future, Stream] {
      def forId(userId: Int): AccountUsersApi[Future, Stream] = AccountUsersApiImpl(requester, security, clientHeaders)(accountId, userId)

      def create(model: List[UserModel]): AvataxSimpleCall[List[UserModel]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/users")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[UserModel], List[UserModel]](req, model)
      }

      def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[UserModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/users").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[UserModel](req)
      }
    }
}

object AccountUsersApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      accountId: Int,
      userId: Int
  )(implicit system: ActorSystem, materializer: Materializer): AccountUsersApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with AccountUsersApi[Future, Stream] {
      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/users/$userId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get(include: Include): AvataxSimpleCall[UserModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/users/$userId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[UserModel](req)
      }

      def getEntitlements: AvataxSimpleCall[UserEntitlementModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/users/$userId/entitlements")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[UserEntitlementModel](req)
      }

      def update(model: UserModel): AvataxSimpleCall[UserModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/users/$userId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[UserModel, UserModel](req, model)
      }
    }
}
