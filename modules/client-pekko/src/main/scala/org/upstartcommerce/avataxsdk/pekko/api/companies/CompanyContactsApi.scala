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

package org.upstartcommerce.avataxsdk.client.pekko.api.companies

import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.http.scaladsl.model.HttpMethods._
import org.apache.pekko.http.scaladsl.model._
import org.apache.pekko.stream.Materializer
import org.upstartcommerce.avataxsdk.client.pekko._
import org.upstartcommerce.avataxsdk.client.pekko.api.{ApiRoot, _}
import org.upstartcommerce.avataxsdk.client.pekko.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.apache.pekko.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import org.upstartcommerce.avataxsdk.client.pekko.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.companies.CompanyContactsApi
import org.upstartcommerce.avataxsdk.client.api.companies.CompanyContactsRootApi
import org.upstartcommerce.avataxsdk.client.pekko.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object CompanyContactsRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyContactsRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyContactsRootApi[Future, Stream] {
      def forContactId(id: Int): CompanyContactsApi[Future, Stream] =
        CompanyContactsApiImpl(requester, security, clientHeaders)(companyId, id)

      def create(model: List[ContactModel]): AvataxSimpleCall[List[ContactModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/contacts")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[ContactModel], List[ContactModel]](req, model)
      }

      def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[ContactModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/contacts").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ContactModel](req)
      }
    }
}

object CompanyContactsApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      contactId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyContactsApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyContactsApi[Future, Stream] {
      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/contacts/$contactId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get: AvataxSimpleCall[ContactModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/contacts/$contactId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[ContactModel](req)
      }

      def update(model: ContactModel): AvataxSimpleCall[ContactModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/contacts/$contactId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[ContactModel, ContactModel](req, model)
      }

    }
}
