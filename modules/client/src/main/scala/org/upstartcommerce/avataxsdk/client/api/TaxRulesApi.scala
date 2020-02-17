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

package org.upstartcommerce.avataxsdk.client.api

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

trait TaxRulesRootApi {
  def query(include:Include, options: FiltrableQueryOptions):AvataxCollectionCall[TaxRuleModel]
}

object TaxRulesRootApi {
  def apply(requester: Requester, security: Option[Authorization])(implicit system: ActorSystem, materializer: Materializer): TaxRulesRootApi =
    new ApiRoot(requester, security) with TaxRulesRootApi {

      def query(include:Include, options: FiltrableQueryOptions):AvataxCollectionCall[TaxRuleModel] = {
        val uri = Uri(s"/api/v2/taxrules").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[TaxRuleModel](req)
      }
    }
}

/*
  def resetLicenseKey(model: ResetLicenseKeyModel): AvataxSimpleCall[LicenseKeyModel] = {
      val uri = Uri(s"/api/v2/accounts/accountId/resetlicensekey")
      val req = HttpRequest(uri = uri).withMethod(POST)
      avataxBodyCall[ResetLicenseKeyModel, LicenseKeyModel](req, model)
    }
  def delete: AvataxSimpleCall[List[ErrorDetail]] = {
      val uri = Uri(s"/api/v2/accounts/accountId/advancedrulescripts/scriptType")
      val req = HttpRequest(uri = uri).withMethod(DELETE)
      avataxSimpleCall[List[ErrorDetail]](req)
    }

  def audit(start: Date, end: Date, options: BasicQueryOptions): AvataxCollectionCall[AuditModel] = {
      val uri =
        Uri(s"/api/v2/accounts/accountId/audit")
          .withQuery(options.asQuery.and("start", dateFmt.format(start)).and("end", dateFmt.format(end)))
      val req = HttpRequest(uri = uri).withMethod(GET)
      avataxCollectionCall[AuditModel](req)
    }
    
     def list(include:Include, options: FiltrableQueryOptions):AvataxCollectionCall[BatchModel] = {
        val uri =
          Uri(s"/api/v2/").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[BatchModel](req)
      }
*/