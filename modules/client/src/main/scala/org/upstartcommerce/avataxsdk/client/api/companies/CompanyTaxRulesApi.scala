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

/** /api/v2/companies/$companyId/taxrules */
trait CompanyTaxRulesRootApi {
  def forId(taxRuleId: Int): CompanyTaxRulesApi

  def create(model: List[TaxRuleModel]): AvataxSimpleCall[List[TaxRuleModel]]
  def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[TaxRuleModel]
}

object CompanyTaxRulesRootApi {
  def apply(requester: Requester, security: Option[Authorization])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyTaxRulesRootApi =
    new ApiRoot(requester, security) with CompanyTaxRulesRootApi {
      def forId(taxRuleId: Int): CompanyTaxRulesApi = CompanyTaxRulesApi(requester, security)(companyId, taxRuleId)

      def create(model: List[TaxRuleModel]): AvataxSimpleCall[List[TaxRuleModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/taxrules")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[TaxRuleModel], List[TaxRuleModel]](req, model)
      }

      def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[TaxRuleModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/taxrules").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[TaxRuleModel](req)
      }
    }
}

trait CompanyTaxRulesApi {
  def delete: AvataxSimpleCall[List[ErrorDetail]]
  def get: AvataxSimpleCall[TaxRuleModel]
  def update(model: TaxRuleModel): AvataxSimpleCall[TaxRuleModel]
}
object CompanyTaxRulesApi {
  def apply(
      requester: Requester,
      security: Option[Authorization]
  )(companyId: Int, taxRuleId: Int)(implicit system: ActorSystem, materializer: Materializer): CompanyTaxRulesApi =
    new ApiRoot(requester, security) with CompanyTaxRulesApi {
      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/taxrules/$taxRuleId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get: AvataxSimpleCall[TaxRuleModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/taxrules/$taxRuleId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[TaxRuleModel](req)
      }

      def update(model: TaxRuleModel): AvataxSimpleCall[TaxRuleModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/taxrules/$taxRuleId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[TaxRuleModel, TaxRuleModel](req, model)
      }
    }
}
