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
import akka.http.scaladsl.model.Uri.Query
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.api._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

/** /api/v2/companies/$companyId/locations */
trait CompanyLocationsRootApi {
  def forLocationId(locationId:Int): CompanyLocationsApi

  def create(model:List[LocationModel]):AvataxSimpleCall[List[LocationModel]]
  def list(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[LocationModel]
}

object CompanyLocationsRootApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId:Int)(implicit system: ActorSystem, materializer: Materializer): CompanyLocationsRootApi =
    new ApiRoot(requester, security) with CompanyLocationsRootApi {
      def forLocationId(locationId: Int): CompanyLocationsApi = CompanyLocationsApi(requester, security)(companyId, locationId)

      def create(model:List[LocationModel]):AvataxSimpleCall[List[LocationModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/locations")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[LocationModel], List[LocationModel]](req, model)
      }

      def list(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[LocationModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/locations").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[LocationModel](req)
      }

    }
}

/** /api/v2/companies/$companyId/locations/$locationId */
trait CompanyLocationsApi {
  def delete:AvataxSimpleCall[List[ErrorDetail]]
  def get(include:Include):AvataxSimpleCall[LocationModel]
  def update(model:LocationModel):AvataxSimpleCall[LocationModel]
  def validate:AvataxSimpleCall[LocationValidationModel]
  def buildTaxContentForLocation(date:Date, format:PointOfSaleFileType, partner:PointOfSalePartnerId, includeJurisCodes:Boolean):AvataxSimpleCall[String]
}
object CompanyLocationsApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId:Int, locationId:Int)(implicit system: ActorSystem, materializer: Materializer): CompanyLocationsApi =
    new ApiRoot(requester, security) with CompanyLocationsApi {
      def delete:AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/locations/$locationId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get(include:Include):AvataxSimpleCall[LocationModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/locations/$locationId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[LocationModel](req)
      }

      def update(model:LocationModel):AvataxSimpleCall[LocationModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/locations/$locationId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[LocationModel, LocationModel](req, model)
      }

      def validate:AvataxSimpleCall[LocationValidationModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/locations/$locationId/validate")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[LocationValidationModel](req)
      }

      def buildTaxContentForLocation(date:Date, format:PointOfSaleFileType, partner:PointOfSalePartnerId, includeJurisCodes:Boolean):AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/companies/$companyId/locations/$locationId/pointofsaledata")
          .withQuery(Query("date" -> dateFmt.format(date),
            "format" -> format.toString,
            "partnerId" -> partner.toString,
            "includeJurisCodes" -> includeJurisCodes.toString))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[String](req)
      }
    }
}