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
import org.upstartcommerce.avataxsdk.client.api.accounts.AccountsJurisdictionOverridesApi
import org.upstartcommerce.avataxsdk.client.api.accounts.AccountsJurisdictionOverridesRootApi
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object AccountsJurisdictionOverridesRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      accountId: Int
  )(implicit system: ActorSystem, materializer: Materializer): AccountsJurisdictionOverridesRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with AccountsJurisdictionOverridesRootApi[Future, Stream] {
      def forJurisOverrideId(jurisOverrideId: Int): AccountsJurisdictionOverridesApi[Future, Stream] =
        AccountsJurisdictionOverridesApiImpl(requester, security, clientHeaders)(accountId, jurisOverrideId)

      def create(model: List[JurisdictionOverrideModel]): AvataxSimpleCall[List[JurisdictionOverrideModel]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/jurisdictionoverrides")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[JurisdictionOverrideModel], List[JurisdictionOverrideModel]](req, model)
      }

      def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[JurisdictionOverrideModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/jurisdictionoverrides").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[JurisdictionOverrideModel](req)
      }
    }
}

object AccountsJurisdictionOverridesApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      accountId: Int,
      jurisOverrideId: Int
  )(implicit system: ActorSystem, materializer: Materializer): AccountsJurisdictionOverridesApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with AccountsJurisdictionOverridesApi[Future, Stream] {
      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/jurisdictionoverrides/$jurisOverrideId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get(include: Include, options: FiltrableQueryOptions): AvataxSimpleCall[JurisdictionOverrideModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/jurisdictionoverrides/$jurisOverrideId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[JurisdictionOverrideModel](req)
      }

      def update(model: JurisdictionOverrideModel): AvataxSimpleCall[JurisdictionOverrideModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/jurisdictionoverrides/$jurisOverrideId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[JurisdictionOverrideModel, JurisdictionOverrideModel](req, model)
      }
    }
}
