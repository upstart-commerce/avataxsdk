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
import org.upstartcommerce.avataxsdk.client.pekko.api._
import org.upstartcommerce.avataxsdk.client.pekko.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.apache.pekko.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import org.upstartcommerce.avataxsdk.client.pekko.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.companies.{CompanyTaxRulesApi, CompanyTaxRulesRootApi}
import org.upstartcommerce.avataxsdk.client.pekko.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object CompanyTaxRulesRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyTaxRulesRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyTaxRulesRootApi[Future, Stream] {
      def forId(taxRuleId: Int): CompanyTaxRulesApi[Future, Stream] =
        CompanyTaxRulesApiImpl(requester, security, clientHeaders)(companyId, taxRuleId)

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

object CompanyTaxRulesApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      taxRuleId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyTaxRulesApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyTaxRulesApi[Future, Stream] {
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
