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

package org.upstartcommerce.avataxsdk.client.api.companies

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.api._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

/** /api/v2/companies/$companyId/items */
trait CompanyItemsRootApi {
  def forItemId(itemId: Long): CompanyItemsApi

  def createItems(model: List[ItemModel]): AvataxSimpleCall[List[ItemModel]]
  def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[ItemModel]
}

object CompanyItemsRootApi {
  def apply(requester: Requester, security: Option[Authorization])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyItemsRootApi =
    new ApiRoot(requester, security) with CompanyItemsRootApi {
      def forItemId(itemId: Long): CompanyItemsApi = CompanyItemsApi(requester, security)(companyId, itemId)

      def createItems(model: List[ItemModel]): AvataxSimpleCall[List[ItemModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[ItemModel], List[ItemModel]](req, model)
      }

      def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[ItemModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ItemModel](req)
      }
    }
}

/** /api/v2/companies/$companyId/items/$itemId */
trait CompanyItemsApi {
  def createClassifications(model: List[ItemClassificationInputModel]): AvataxSimpleCall[List[ItemClassificationOutputModel]]
  def createParameters(model: List[ItemParameterModel]): AvataxSimpleCall[List[ItemParameterModel]]
  def delete: AvataxSimpleCall[List[ErrorDetail]]
  def deleteClassification(classificationId: Long): AvataxSimpleCall[List[ErrorDetail]]
  def deleteParameter(parameterId: Long): AvataxSimpleCall[List[ErrorDetail]]
  def get(include: Include): AvataxSimpleCall[ItemModel]
  def getClassification(classificationId: Long): AvataxSimpleCall[ItemClassificationOutputModel]
  def getParameter(parameterId: Long): AvataxSimpleCall[ItemParameterModel]
  def listClassifications(options: FiltrableQueryOptions): AvataxCollectionCall[ItemClassificationOutputModel]
  def listParameters(options: FiltrableQueryOptions): AvataxCollectionCall[ItemParameterModel]
  def update(model: ItemModel): AvataxSimpleCall[ItemModel]
  def updateClassification(classificationsId: Long, model: ItemClassificationInputModel): AvataxSimpleCall[ItemClassificationOutputModel]
  def updateParameter(parameterId: Long, model: ItemParameterModel): AvataxSimpleCall[ItemParameterModel]
}
object CompanyItemsApi {
  def apply(
      requester: Requester,
      security: Option[Authorization]
  )(companyId: Int, itemId: Long)(implicit system: ActorSystem, materializer: Materializer): CompanyItemsApi =
    new ApiRoot(requester, security) with CompanyItemsApi {
      def createClassifications(model: List[ItemClassificationInputModel]): AvataxSimpleCall[List[ItemClassificationOutputModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items/$itemId/classifications")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[ItemClassificationInputModel], List[ItemClassificationOutputModel]](req, model)
      }

      def createParameters(model: List[ItemParameterModel]): AvataxSimpleCall[List[ItemParameterModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items/$itemId/parameters")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[ItemParameterModel], List[ItemParameterModel]](req, model)
      }

      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items/$itemId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def deleteClassification(classificationId: Long): AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items/$itemId/classifications/$classificationId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def deleteParameter(parameterId: Long): AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items/$itemId/classifications/$parameterId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get(include: Include): AvataxSimpleCall[ItemModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items/$itemId").withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[ItemModel](req)
      }

      def getClassification(classificationId: Long): AvataxSimpleCall[ItemClassificationOutputModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items/$itemId/classifications/$classificationId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[ItemClassificationOutputModel](req)
      }

      def getParameter(parameterId: Long): AvataxSimpleCall[ItemParameterModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items/$itemId/parameters/$parameterId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[ItemParameterModel](req)
      }

      def listClassifications(options: FiltrableQueryOptions): AvataxCollectionCall[ItemClassificationOutputModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items/$itemId/classifications")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ItemClassificationOutputModel](req)
      }

      def listParameters(options: FiltrableQueryOptions): AvataxCollectionCall[ItemParameterModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items/$itemId/parameters")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ItemParameterModel](req)
      }

      def update(model: ItemModel): AvataxSimpleCall[ItemModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items/$itemId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[ItemModel, ItemModel](req, model)
      }

      def updateClassification(
          classificationsId: Long,
          model: ItemClassificationInputModel
      ): AvataxSimpleCall[ItemClassificationOutputModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items/$itemId/classifications/$classificationsId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[ItemClassificationInputModel, ItemClassificationOutputModel](req, model)
      }

      def updateParameter(parameterId: Long, model: ItemParameterModel): AvataxSimpleCall[ItemParameterModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/items/$itemId/parameters/$parameterId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[ItemParameterModel, ItemParameterModel](req, model)
      }
    }
}
