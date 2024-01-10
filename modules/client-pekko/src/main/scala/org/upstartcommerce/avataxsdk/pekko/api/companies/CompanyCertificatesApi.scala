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
import org.apache.pekko.http.scaladsl.model.Uri.Query
import org.apache.pekko.http.scaladsl.model._
import org.apache.pekko.http.scaladsl.model.headers.Authorization
import org.apache.pekko.stream.Materializer
import org.upstartcommerce.avataxsdk.client.pekko._
import org.upstartcommerce.avataxsdk.client.pekko.api.{ApiRoot, _}
import org.upstartcommerce.avataxsdk.client.pekko.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import org.upstartcommerce.avataxsdk.client.pekko.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.companies.CompanyCertificatesApi
import org.upstartcommerce.avataxsdk.client.api.companies.CompanyCertificatesRootApi
import org.upstartcommerce.avataxsdk.client.pekko.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object CompanyCertificatesRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyCertificatesRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyCertificatesRootApi[Future, Stream] {
      def forId(certificateId: Int): CompanyCertificatesApi[Future, Stream] =
        CompanyCertificatesApiImpl(requester, security, clientHeaders)(companyId, certificateId)

      def create(preValidatedExemptionReason: Boolean, model: List[CertificateModel]): AvataxSimpleCall[List[CertificateModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates")
          .withQuery(Query("$preValidatedExemptionReason" -> preValidatedExemptionReason.toString))
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[CertificateModel], List[CertificateModel]](req, model)
      }

      def getSetup: AvataxSimpleCall[ProvisionStatusModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/setup")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[ProvisionStatusModel](req)
      }

      def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[CertificateModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CertificateModel](req)
      }

      def requestSetup: AvataxSimpleCall[ProvisionStatusModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/setup")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[ProvisionStatusModel](req)
      }
    }
}

object CompanyCertificatesApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      certificateId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyCertificatesApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyCertificatesApi[Future, Stream] {
      def delete: AvataxSimpleCall[CertificateModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[CertificateModel](req)
      }

      def downloadImage(page: Int, `type`: CertificatePreviewType): AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/attachment")
          .withQuery(Query("$page" -> page.toString, "$type" -> `type`.toString))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[String](req)
      }

      def get(include: Include): AvataxSimpleCall[CertificateModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId").withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[CertificateModel](req)
      }

      def linkAttributes(model: List[CertificateAttributeModel]): AvataxCollectionCall[CertificateAttributeModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/attributes/link")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxCollectionBodyCall[List[CertificateAttributeModel], CertificateAttributeModel](req, model)
      }

      def linkCustomers(model: LinkCustomersModel): AvataxCollectionCall[CustomerModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/customers/link")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxCollectionBodyCall[LinkCustomersModel, CustomerModel](req, model)
      }

      def listAttributes: AvataxCollectionCall[CertificateAttributeModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/attributes")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CertificateAttributeModel](req)
      }

      def listCustomers(include: Include): AvataxCollectionCall[CustomerModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/customers").withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CustomerModel](req)
      }

      def unlinkAttributes(model: List[CertificateAttributeModel]): AvataxCollectionCall[CertificateAttributeModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/attributes/unlink")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxCollectionBodyCall[List[CertificateAttributeModel], CertificateAttributeModel](req, model)
      }

      def unlinkCustomers(model: LinkCustomersModel): AvataxCollectionCall[CustomerModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/customers/unlink")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxCollectionBodyCall[LinkCustomersModel, CustomerModel](req, model)
      }

      def update(model: CertificateModel): AvataxSimpleCall[CertificateModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[CertificateModel, CertificateModel](req, model)
      }

      def uploadImage(file: String): AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/attachment")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[String, String](req, file)
      }
    }
}
