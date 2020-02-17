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

/** api/v2/companies/$companyId/customers */
trait CompanyCustomersRootApi {
  def forCustomerCode(code:String): CompanyCustomersApi

  def create(model:List[CustomerModel]):AvataxSimpleCall[List[CustomerModel]]
  def query(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[CustomerModel]
}

object CompanyCustomersRootApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId:Int)(implicit system: ActorSystem, materializer: Materializer): CompanyCustomersRootApi =
    new ApiRoot(requester, security) with CompanyCustomersRootApi {
      def forCustomerCode(code:String): CompanyCustomersApi = CompanyCustomersApi(requester, security)(companyId, code)

      def create(model:List[CustomerModel]):AvataxSimpleCall[List[CustomerModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/customers")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[CustomerModel], List[CustomerModel]](req, model)
      }

      def query(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[CustomerModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/customers").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CustomerModel](req)
      }
    }
}


/** api/v2/companies/$companyId/customers/$customerCode */
trait CompanyCustomersApi {
  def certExpressInvites: CompanyCustomerCertExpressInvitationRootApi
  def certificates:CompanyCustomerCertificatesRootApi

  def deleteCustomer(companyId:Int, customerCode:String):AvataxSimpleCall[CustomerModel]
  def get(include:Include):AvataxSimpleCall[CustomerModel]
  def linkCertificates(model:LinkCertificatesModel):AvataxCollectionCall[CertificateModel]
  def linkShipToToBillCustomer(model:LinkCustomersModel):AvataxSimpleCall[CustomerModel]
  def update(model:CustomerModel):AvataxSimpleCall[CustomerModel]
}

object CompanyCustomersApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId:Int, customerCode:String)(implicit system: ActorSystem, materializer: Materializer): CompanyCustomersApi =
    new ApiRoot(requester, security) with CompanyCustomersApi {
      val certExpressInvites: CompanyCustomerCertExpressInvitationRootApi =
        CompanyCustomerCertExpressInvitationRootApi(requester, security)(companyId, customerCode)
      val certificates:CompanyCustomerCertificatesRootApi = CompanyCustomerCertificatesRootApi(requester, security)(companyId, customerCode)

      def deleteCustomer(companyId:Int, customerCode:String):AvataxSimpleCall[CustomerModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/customers/$customerCode")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[CustomerModel](req)
      }

      def get(include:Include):AvataxSimpleCall[CustomerModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/customers/$customerCode")
          .withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[CustomerModel](req)
      }

      def linkCertificates(model:LinkCertificatesModel):AvataxCollectionCall[CertificateModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/customers/$customerCode/certificates/link")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxCollectionBodyCall[LinkCertificatesModel, CertificateModel](req, model)
      }

      def linkShipToToBillCustomer(model:LinkCustomersModel):AvataxSimpleCall[CustomerModel] = {
        // POST address does not suit too much
        val uri = Uri(s"/api/v2/companies/$companyId/customers/billto/$customerCode/shipto/link")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[LinkCustomersModel, CustomerModel](req, model)
      }

      def update(model:CustomerModel):AvataxSimpleCall[CustomerModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/customers/$customerCode")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[CustomerModel, CustomerModel](req, model)
      }
    }
}
