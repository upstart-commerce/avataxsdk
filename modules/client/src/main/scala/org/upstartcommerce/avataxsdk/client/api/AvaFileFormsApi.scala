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

package org.upstartcommerce.avataxsdk.client.api

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

trait AvaFileFormsRootApi {
  def forId(formId: Int): AvaFileFormsApi

  def create(model: List[AvaFileFormModel]): AvataxSimpleCall[List[AvaFileFormModel]]
  def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[AvaFileFormModel]
}

object AvaFileFormsRootApi {
  def apply(
      requester: Requester,
      security: Option[Authorization]
  )(implicit system: ActorSystem, materializer: Materializer): AvaFileFormsRootApi =
    new ApiRoot(requester, security) with AvaFileFormsRootApi {
      def forId(id: Int): AvaFileFormsApi = AvaFileFormsApi(requester, security)(id)

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

trait AvaFileFormsApi {
  def delete: AvataxSimpleCall[List[ErrorDetail]]
  def get: AvataxSimpleCall[AvaFileFormModel]
  def update(model: AvaFileFormModel): AvataxSimpleCall[AvaFileFormModel]
}
object AvaFileFormsApi {
  def apply(requester: Requester, security: Option[Authorization])(
      formId: Int
  )(implicit system: ActorSystem, materializer: Materializer): AvaFileFormsApi =
    new ApiRoot(requester, security) with AvaFileFormsApi {
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
