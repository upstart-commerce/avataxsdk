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

/** /api/v2/companies/$companyId/taxcodes */
trait CompanyTaxCodesRootApi {
  def forId(taxCodeId:Int): CompanyTaxCodesApi

  def create(model:List[TaxCodeModel]):AvataxSimpleCall[List[TaxCodeModel]]
  def list(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[TaxCodeModel]
}

object CompanyTaxCodesRootApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId:Int)(implicit system: ActorSystem, materializer: Materializer): CompanyTaxCodesRootApi =
    new ApiRoot(requester, security) with CompanyTaxCodesRootApi {
      def forId(taxCodeId: Int): CompanyTaxCodesApi = CompanyTaxCodesApi(requester, security)(companyId, taxCodeId)

      def create(model:List[TaxCodeModel]):AvataxSimpleCall[List[TaxCodeModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/taxcodes")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[TaxCodeModel], List[TaxCodeModel]](req, model)
      }

      def list(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[TaxCodeModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/taxcodes")
          .withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[TaxCodeModel](req)
      }
    }
}

/** /api/v2/companies/$companyId/taxcodes/$taxCodeId */
trait CompanyTaxCodesApi {
  def delete:AvataxSimpleCall[List[ErrorDetail]]
  def get:AvataxSimpleCall[TaxCodeModel]
  def update(model:TaxCodeModel):AvataxSimpleCall[TaxCodeModel]
}
object CompanyTaxCodesApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId:Int, taxCodeId:Int)(implicit system: ActorSystem, materializer: Materializer): CompanyTaxCodesApi =
    new ApiRoot(requester, security) with CompanyTaxCodesApi {
      def delete:AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/taxcodes/$taxCodeId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get:AvataxSimpleCall[TaxCodeModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/taxcodes/$taxCodeId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[TaxCodeModel](req)
      }

      def update(model:TaxCodeModel):AvataxSimpleCall[TaxCodeModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/taxcodes/$taxCodeId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[TaxCodeModel, TaxCodeModel](req, model)
      }
    }
}
