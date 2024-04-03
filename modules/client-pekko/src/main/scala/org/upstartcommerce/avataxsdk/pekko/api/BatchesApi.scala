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

package org.upstartcommerce.avataxsdk.client.pekko.api

import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.http.scaladsl.model.HttpMethods._
import org.apache.pekko.http.scaladsl.model._
import org.apache.pekko.stream.Materializer
import org.upstartcommerce.avataxsdk.client.pekko._
import org.upstartcommerce.avataxsdk.client.pekko.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.apache.pekko.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import org.upstartcommerce.avataxsdk.client.pekko.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.{BatchesRootApi, CompanyBatchesApi, CompanyBatchesRootApi}
import org.upstartcommerce.avataxsdk.client.pekko.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object BatchesRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      implicit system: ActorSystem,
      materializer: Materializer
  ): BatchesRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with BatchesRootApi[Future, Stream] {
      def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[BatchModel] = {
        val uri = Uri(s"/api/v2/batches").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[BatchModel](req)
      }
    }
}

object CompanyBatchesRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyBatchesRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyBatchesRootApi[Future, Stream] {
      def forBatchId(id: Int): CompanyBatchesApi[Future, Stream] = CompanyBatchesApiImpl(requester, security, clientHeaders)(companyId, id)

      def create(model: List[BatchModel]): AvataxSimpleCall[List[BatchModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/batches")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[BatchModel], List[BatchModel]](req, model)
      }

      def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[BatchModel] = {
        val uri =
          Uri(s"/api/v2/companies/$companyId/batches").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[BatchModel](req)
      }
    }
}

object CompanyBatchesApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      batchId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyBatchesApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyBatchesApi[Future, Stream] {
      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/batches/$batchId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def download(id: Int): AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/companies/$companyId/batches/$batchId/files/$id/attachment")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[String](req)
      }

      def get: AvataxSimpleCall[BatchModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/batches/$batchId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[BatchModel](req)
      }
    }
}
