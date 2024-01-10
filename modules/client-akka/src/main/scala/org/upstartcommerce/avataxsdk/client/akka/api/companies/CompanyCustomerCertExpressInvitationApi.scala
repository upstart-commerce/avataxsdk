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
import org.upstartcommerce.avataxsdk.client.akka.api.ApiRoot
import org.upstartcommerce.avataxsdk.client.akka.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.upstartcommerce.avataxsdk.json._
import akka.http.scaladsl.model.headers.Authorization
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import org.upstartcommerce.avataxsdk.client.api.companies.CompanyCustomerCertExpressInvitationApi
import org.upstartcommerce.avataxsdk.client.api.companies.CompanyCustomerCertExpressInvitationRootApi
import scala.concurrent.Future

object CompanyCustomerCertExpressInvitationRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      customerCode: String
  )(implicit system: ActorSystem, materializer: Materializer): CompanyCustomerCertExpressInvitationRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyCustomerCertExpressInvitationRootApi[Future, Stream] {
      def forId(certExpressId: Int): CompanyCustomerCertExpressInvitationApi[Future, Stream] =
        CompanyCustomerCertExpressInvitationApiImpl(requester, security, clientHeaders)(companyId, customerCode, certExpressId)

      def create(model: List[CreateCertExpressInvitationModel]): AvataxSimpleCall[List[CertExpressInvitationStatusModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/customers/$customerCode/certexpressinvites}")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[CreateCertExpressInvitationModel], List[CertExpressInvitationStatusModel]](req, model)
      }
    }
}

object CompanyCustomerCertExpressInvitationApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      customerCode: String,
      certExpressId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyCustomerCertExpressInvitationApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyCustomerCertExpressInvitationApi[Future, Stream] {
      def get(include: Include): AvataxSimpleCall[CertExpressInvitationModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/customers/$customerCode/certexpressinvites/$certExpressId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[CertExpressInvitationModel](req)
      }
    }
}
