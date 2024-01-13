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

package org.upstartcommerce.avataxsdk.client.akka.api.companies

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model.Uri.Query
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
import org.upstartcommerce.avataxsdk.client.api.companies.{CompanyFilingRequestsApi, CompanyFilingRequestsRootApi}
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object CompanyFilingRequestsRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyFilingRequestsRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyFilingRequestsRootApi[Future, Stream] {
      def forId(filingReqId: Int): CompanyFilingRequestsApi[Future, Stream] =
        CompanyFilingRequestsApiImpl(requester, security, clientHeaders)(companyId, filingReqId)

      def list(filingCalendarId: Int, options: FiltrableQueryOptions): AvataxCollectionCall[FilingRequestModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingrequests")
          .withQuery(options.asQuery.merge(Query("filingCalendarId" -> filingCalendarId.toString)))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[FilingRequestModel](req)
      }
    }
}

object CompanyFilingRequestsApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      filingRequestId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyFilingRequestsApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyFilingRequestsApi[Future, Stream] {
      def approve: AvataxSimpleCall[FilingRequestModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingrequests/$filingRequestId/approve")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[FilingRequestModel](req)
      }

      def cancel: AvataxSimpleCall[FilingRequestModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingrequests/$filingRequestId/cancel")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[FilingRequestModel](req)
      }

      def get: AvataxSimpleCall[FilingRequestModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingrequests/$filingRequestId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[FilingRequestModel](req)
      }

      def update(model: FilingRequestModel): AvataxSimpleCall[FilingRequestModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingrequests/$filingRequestId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[FilingRequestModel, FilingRequestModel](req, model)
      }
    }
}
