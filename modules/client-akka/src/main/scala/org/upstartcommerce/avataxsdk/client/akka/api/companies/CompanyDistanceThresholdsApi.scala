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
import org.upstartcommerce.avataxsdk.client.api.companies.{CompanyDistanceThresholdApi, CompanyDistanceThresholdRootApi}
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}

import scala.concurrent.Future

object CompanyDistanceThresholdRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyDistanceThresholdRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyDistanceThresholdRootApi[Future, Stream] {
      def forId(distThreshId: Long): CompanyDistanceThresholdApi[Future, Stream] =
        CompanyDistanceThresholdApiImpl(requester, security, clientHeaders)(companyId, distThreshId)

      def create(model: List[CompanyDistanceThresholdModel]): AvataxSimpleCall[List[CompanyDistanceThresholdModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/distancethresholds")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[CompanyDistanceThresholdModel], List[CompanyDistanceThresholdModel]](req, model)
      }

      def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[CompanyDistanceThresholdModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/distancethresholds").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CompanyDistanceThresholdModel](req)
      }
    }
}

object CompanyDistanceThresholdApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      distThreshId: Long
  )(implicit system: ActorSystem, materializer: Materializer): CompanyDistanceThresholdApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyDistanceThresholdApi[Future, Stream] {
      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/distancethresholds/$distThreshId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get: AvataxSimpleCall[CompanyDistanceThresholdModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/distancethresholds/$distThreshId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[CompanyDistanceThresholdModel](req)
      }

      def update(model: CompanyDistanceThresholdModel): AvataxSimpleCall[CompanyDistanceThresholdModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/distancethresholds/$distThreshId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[CompanyDistanceThresholdModel, CompanyDistanceThresholdModel](req, model)
      }
    }
}
