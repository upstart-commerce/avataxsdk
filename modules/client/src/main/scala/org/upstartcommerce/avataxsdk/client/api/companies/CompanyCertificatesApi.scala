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
import akka.http.scaladsl.model.headers.Authorization
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.api.{ApiRoot, _}
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

/** api/v2/companies/$companyId/certificates */
trait CompanyCertificatesRootApi {
  def forId(certificateId:Int): CompanyCertificatesApi
  def create(preValidatedExemptionReason:Boolean, model:List[CertificateModel]):AvataxSimpleCall[List[CertificateModel]]
  def getSetup:AvataxSimpleCall[ProvisionStatusModel]
  def query(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[CertificateModel]
  def requestSetup:AvataxSimpleCall[ProvisionStatusModel]
}

object CompanyCertificatesRootApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId:Int)(implicit system: ActorSystem, materializer: Materializer): CompanyCertificatesRootApi =
    new ApiRoot(requester, security) with CompanyCertificatesRootApi {
      def forId(certificateId:Int): CompanyCertificatesApi = CompanyCertificatesApi(requester, security)(companyId, certificateId)

      def create(preValidatedExemptionReason:Boolean, model:List[CertificateModel]):AvataxSimpleCall[List[CertificateModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates").withQuery(Query("$preValidatedExemptionReason" -> preValidatedExemptionReason.toString))
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[CertificateModel],List[CertificateModel]](req, model)
      }

      def getSetup:AvataxSimpleCall[ProvisionStatusModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/setup")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[ProvisionStatusModel](req)
      }

      def query(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[CertificateModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates")
          .withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CertificateModel](req)
      }

      def requestSetup:AvataxSimpleCall[ProvisionStatusModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/setup")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[ProvisionStatusModel](req)
      }
    }
}

/** api/v2/companies/$companyId/certificates/$certificateId */
trait CompanyCertificatesApi {
  def delete:AvataxSimpleCall[CertificateModel]
  def downloadImage(page:Int, `type`:CertificatePreviewType):AvataxSimpleCall[String]
  def get(include:Include):AvataxSimpleCall[CertificateModel]
  def linkAttributes(model:List[CertificateAttributeModel]):AvataxCollectionCall[CertificateAttributeModel]
  def linkCustomers(model:LinkCustomersModel):AvataxCollectionCall[CustomerModel]
  def listAttributes:AvataxCollectionCall[CertificateAttributeModel]
  def listCustomers(include:Include):AvataxCollectionCall[CustomerModel]
  def unlinkAttributes(model:List[CertificateAttributeModel]):AvataxCollectionCall[CertificateAttributeModel]
  def unlinkCustomers(model:LinkCustomersModel):AvataxCollectionCall[CustomerModel]
  def update(model:CertificateModel):AvataxSimpleCall[CertificateModel]
  def uploadImage(file:String):AvataxSimpleCall[String]
}

object CompanyCertificatesApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId:Int, certificateId:Int)(implicit system: ActorSystem, materializer: Materializer): CompanyCertificatesApi =
    new ApiRoot(requester, security) with CompanyCertificatesApi {
      def delete:AvataxSimpleCall[CertificateModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[CertificateModel](req)
      }

      def downloadImage(page:Int, `type`:CertificatePreviewType):AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/attachment")
          .withQuery(Query("$page" -> page.toString, "$type" -> `type`.toString))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[String](req)
      }

      def get(include:Include):AvataxSimpleCall[CertificateModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId").withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[CertificateModel](req)
      }

      def linkAttributes(model:List[CertificateAttributeModel]):AvataxCollectionCall[CertificateAttributeModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/attributes/link")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxCollectionBodyCall[List[CertificateAttributeModel], CertificateAttributeModel](req, model)
      }

      def linkCustomers(model:LinkCustomersModel):AvataxCollectionCall[CustomerModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/customers/link")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxCollectionBodyCall[LinkCustomersModel, CustomerModel](req, model)
      }

      def listAttributes:AvataxCollectionCall[CertificateAttributeModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/attributes")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CertificateAttributeModel](req)
      }

      def listCustomers(include:Include):AvataxCollectionCall[CustomerModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/customers")
          .withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CustomerModel](req)
      }

      def unlinkAttributes(model:List[CertificateAttributeModel]):AvataxCollectionCall[CertificateAttributeModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/attributes/unlink")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxCollectionBodyCall[List[CertificateAttributeModel], CertificateAttributeModel](req, model)
      }

      def unlinkCustomers(model:LinkCustomersModel):AvataxCollectionCall[CustomerModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/customers/unlink")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxCollectionBodyCall[LinkCustomersModel, CustomerModel](req, model)
      }

      def update(model:CertificateModel):AvataxSimpleCall[CertificateModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[CertificateModel, CertificateModel](req, model)
      }

      def uploadImage(file:String):AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certificates/$certificateId/attachment")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[String, String](req, file)
      }
    }
}