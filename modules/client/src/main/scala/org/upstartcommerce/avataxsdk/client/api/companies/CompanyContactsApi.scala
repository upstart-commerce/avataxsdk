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
import org.upstartcommerce.avataxsdk.client.api.{ApiRoot, _}
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

/** /api/v2/companies/$companyId/contacts */
trait CompanyContactsRootApi {
  def forContactId(id:Int): CompanyContactsApi

  def create(model:List[ContactModel]):AvataxSimpleCall[List[ContactModel]]

  def list(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[ContactModel]
}

object CompanyContactsRootApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId:Int)(implicit system: ActorSystem, materializer: Materializer): CompanyContactsRootApi =
    new ApiRoot(requester, security) with CompanyContactsRootApi {
      def forContactId(id: Int): CompanyContactsApi = CompanyContactsApi(requester, security)(companyId, id)

      def create(model:List[ContactModel]):AvataxSimpleCall[List[ContactModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/contacts")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[ContactModel], List[ContactModel]](req, model)
      }

      def list(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[ContactModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/contacts")
          .withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ContactModel](req)
      }
    }
}

/** /api/v2/companies/$companyId/contacts/$contactId */
trait CompanyContactsApi {
  def delete:AvataxSimpleCall[List[ErrorDetail]]
  def get:AvataxSimpleCall[ContactModel]
}
object CompanyContactsApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId:Int, contactId:Int)(implicit system: ActorSystem, materializer: Materializer): CompanyContactsApi =
    new ApiRoot(requester, security) with CompanyContactsApi {
      def delete:AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/contacts/$contactId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get:AvataxSimpleCall[ContactModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/contacts/$contactId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[ContactModel](req)
      }

      def update(model:ContactModel):AvataxSimpleCall[ContactModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/contacts/$contactId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[ContactModel, ContactModel](req, model)
      }

    }
}