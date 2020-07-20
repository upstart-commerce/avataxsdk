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
import org.upstartcommerce.avataxsdk.client.api.ApiRoot
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.upstartcommerce.avataxsdk.json._
import akka.http.scaladsl.model.headers.Authorization
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

/** api/v2/companies/$companyId/customers/$customerCode/certexpressinvites */
trait CompanyCustomerCertExpressInvitationRootApi {
  def forId(certExpressId: Int): CompanyCustomerCertExpressInvitationApi

  def create(model: List[CreateCertExpressInvitationModel]): AvataxSimpleCall[List[CertExpressInvitationStatusModel]]
}

object CompanyCustomerCertExpressInvitationRootApi {
  def apply(requester: Requester, security: Option[Authorization])(
      companyId: Int,
      customerCode: String
  )(implicit system: ActorSystem, materializer: Materializer): CompanyCustomerCertExpressInvitationRootApi =
    new ApiRoot(requester, security) with CompanyCustomerCertExpressInvitationRootApi {
      def forId(certExpressId: Int): CompanyCustomerCertExpressInvitationApi =
        CompanyCustomerCertExpressInvitationApi(requester, security)(companyId, customerCode, certExpressId)

      def create(model: List[CreateCertExpressInvitationModel]): AvataxSimpleCall[List[CertExpressInvitationStatusModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/customers/$customerCode/certexpressinvites}")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[CreateCertExpressInvitationModel], List[CertExpressInvitationStatusModel]](req, model)
      }
    }
}

/** api/v2/companies/$companyId/customers/$customerCode/certexpressinvites/$id */
trait CompanyCustomerCertExpressInvitationApi {
  def get(include: Include): AvataxSimpleCall[CertExpressInvitationModel]
}

object CompanyCustomerCertExpressInvitationApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId: Int, customerCode: String, certExpressId: Int)(
      implicit system: ActorSystem,
      materializer: Materializer
  ): CompanyCustomerCertExpressInvitationApi =
    new ApiRoot(requester, security) with CompanyCustomerCertExpressInvitationApi {
      def get(include: Include): AvataxSimpleCall[CertExpressInvitationModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/customers/$customerCode/certexpressinvites/$certExpressId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[CertExpressInvitationModel](req)
      }
    }
}
