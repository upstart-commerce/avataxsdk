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
import org.upstartcommerce.avataxsdk.client.akka.api._
import org.upstartcommerce.avataxsdk.client.akka.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.companies.CompanyCustomerCertificatesApi
import org.upstartcommerce.avataxsdk.client.api.companies.CompanyCustomerCertificatesRootApi
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object CompanyCustomerCertificatesRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      customerCode: String
  )(implicit system: ActorSystem, materializer: Materializer): CompanyCustomerCertificatesRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyCustomerCertificatesRootApi[Future, Stream] {
      def forCertId(certificateId: Int): CompanyCustomerCertificatesApi[Future, Stream] =
        CompanyCustomerCertificatesApiImpl(requester, security, clientHeaders)(companyId, customerCode, certificateId)

      def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[CertificateModel] = {
        val uri =
          Uri(s"/api/v2/companies/$companyId/customers/$customerCode/certificates").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CertificateModel](req)
      }

      def listValid(country: String, region: String): AvataxSimpleCall[ExemptionStatusModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/customers/$customerCode/certificates/$country/$region")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[ExemptionStatusModel](req)
      }

      def unlink(model: LinkCertificatesModel): AvataxCollectionCall[CertificateModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/customers/$customerCode/certificates/unlink")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxCollectionBodyCall[LinkCertificatesModel, CertificateModel](req, model)
      }
    }
}

object CompanyCustomerCertificatesApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      customerCode: String,
      certificateId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyCustomerCertificatesApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyCustomerCertificatesApi[Future, Stream] {}
}
