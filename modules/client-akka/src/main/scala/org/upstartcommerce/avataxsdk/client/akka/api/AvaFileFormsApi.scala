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

package org.upstartcommerce.avataxsdk.client.akka.api

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client.akka._
import org.upstartcommerce.avataxsdk.client.akka.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.{AvaFileFormsApi, AvaFileFormsRootApi}
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}

import scala.concurrent.Future

object AvaFileFormsRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      implicit system: ActorSystem,
      materializer: Materializer
  ): AvaFileFormsRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with AvaFileFormsRootApi[Future, Stream] {
      def forId(id: Int): AvaFileFormsApi[Future, Stream] = AvaFileFormsApiImpl(requester, security, clientHeaders)(id)

      def create(model: List[AvaFileFormModel]): AvataxSimpleCall[List[AvaFileFormModel]] = {
        val uri = Uri(s"/api/v2/avafileforms")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[AvaFileFormModel], List[AvaFileFormModel]](req, model)
      }

      def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[AvaFileFormModel] = {
        val uri =
          Uri(s"/api/v2/avafileforms").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[AvaFileFormModel](req)
      }
    }
}

object AvaFileFormsApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      formId: Int
  )(implicit system: ActorSystem, materializer: Materializer): AvaFileFormsApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with AvaFileFormsApi[Future, Stream] {
      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/avafileforms/$formId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get: AvataxSimpleCall[AvaFileFormModel] = {
        val uri = Uri(s"/api/v2/avafileforms/$formId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[AvaFileFormModel](req)
      }

      def update(model: AvaFileFormModel): AvataxSimpleCall[AvaFileFormModel] = {
        val uri = Uri(s"/api/v2/avafileforms/$formId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[AvaFileFormModel, AvaFileFormModel](req, model)
      }
    }
}
