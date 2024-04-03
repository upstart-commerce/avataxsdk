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
import org.upstartcommerce.avataxsdk.client.api.companies.{CompanyFilingCalendarApi, CompanyFilingCalendarRootApi}
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object CompanyFilingCalendarRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyFilingCalendarRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyFilingCalendarRootApi[Future, Stream] {
      def forFilingCalendarId(filingCalendarId: Int): CompanyFilingCalendarApi[Future, Stream] =
        CompanyFilingCalendarApiImpl(requester, security, clientHeaders)(companyId, filingCalendarId)

      def create(model: List[FilingCalendarModel]): AvataxSimpleCall[FilingCalendarModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingcalendars")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[FilingCalendarModel], FilingCalendarModel](req, model)
      }

      def createRequest(model: List[FilingRequestModel]): AvataxSimpleCall[FilingRequestModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingcalendars/add/request")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[FilingRequestModel], FilingRequestModel](req, model)
      }

      def cycleSafeAdd(formCode: String): AvataxSimpleCall[List[CycleAddOptionModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingcalendars/add/options").withQuery(Query("formCode" -> formCode))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[List[CycleAddOptionModel]](req)
      }

      def list(
          returnCountry: String,
          returnRegion: String,
          include: Include,
          options: FiltrableQueryOptions
      ): AvataxCollectionCall[FilingCalendarModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingcalendars")
          .withQuery(include.asQuery.merge(options.asQuery).merge(Query("returnCountry" -> returnCountry, "returnRegion" -> returnRegion)))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[FilingCalendarModel](req)
      }
    }
}

object CompanyFilingCalendarApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      filingCalendarId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyFilingCalendarApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyFilingCalendarApi[Future, Stream] {
      def cancelRequests(model: List[FilingRequestModel]): AvataxSimpleCall[FilingRequestModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingcalendars/$filingCalendarId/cancel/request")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[FilingRequestModel], FilingRequestModel](req, model)
      }

      def cycleSafeEdit(model: List[FilingCalendarEditModel]): AvataxSimpleCall[CycleEditOptionModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingcalendars/$filingCalendarId/edit/options")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[FilingCalendarEditModel], CycleEditOptionModel](req, model)
      }

      def cycleSafeExpiration: AvataxSimpleCall[CycleExpireModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingcalendars/$filingCalendarId/cancel/options")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[CycleExpireModel](req)
      }

      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingcalendars/$filingCalendarId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get: AvataxSimpleCall[FilingCalendarModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingcalendars/$filingCalendarId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[FilingCalendarModel](req)
      }

      def requestUpdate(model: List[FilingRequestModel]): AvataxSimpleCall[FilingRequestModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingcalendars/$filingCalendarId/edit/request")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[FilingRequestModel], FilingRequestModel](req, model)
      }

      def update(model: FilingCalendarModel): AvataxSimpleCall[FilingCalendarModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingcalendars/$filingCalendarId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[FilingCalendarModel, FilingCalendarModel](req, model)
      }
    }
}
