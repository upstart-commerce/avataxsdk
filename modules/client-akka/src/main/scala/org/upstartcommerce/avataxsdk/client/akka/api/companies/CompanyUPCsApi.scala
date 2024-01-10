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

package org.upstartcommerce.avataxsdk.client.akka.api.companies

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client.akka._
import org.upstartcommerce.avataxsdk.client.akka.api._
import org.upstartcommerce.avataxsdk.client.akka.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.companies.{CompanyUPCsApi, CompanyUPCsRootApi}
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object CompanyUPCsRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyUPCsRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyUPCsRootApi[Future, Stream] {
      def forId(upcId: Int): CompanyUPCsApi[Future, Stream] = CompanyUPCsApiImpl(requester, security, clientHeaders)(companyId, upcId)

      def create(model: List[UPCModel]): AvataxSimpleCall[List[UPCModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/upcs")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[UPCModel], List[UPCModel]](req, model)
      }

      def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[UPCModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/upcs").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[UPCModel](req)
      }
    }
}

object CompanyUPCsApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      upcId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyUPCsApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyUPCsApi[Future, Stream] {
      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/upcs/$upcId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get: AvataxSimpleCall[UPCModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/upcs/$upcId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[UPCModel](req)
      }

      def update(model: UPCModel): AvataxSimpleCall[UPCModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/upcs/$upcId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[UPCModel, UPCModel](req, model)
      }
    }
}
