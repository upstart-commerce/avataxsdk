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

package org.upstartcommerce.avataxsdk.client.pekko.api

import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.http.scaladsl.model.HttpMethods._
import org.apache.pekko.http.scaladsl.model._
import org.apache.pekko.http.scaladsl.model.headers._
import org.apache.pekko.stream.Materializer
import org.upstartcommerce.avataxsdk.client.pekko.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.apache.pekko.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import org.upstartcommerce.avataxsdk.client.pekko.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.{AccountAdvancedRuleScriptRootApi, AccountAdvancedRuleTableRootApi, AccountsApi, AccountsRootApi}
import org.upstartcommerce.avataxsdk.client.pekko.api.accounts._
import org.upstartcommerce.avataxsdk.client.api.accounts.{AccountSubscriptionsRootApi, AccountUsersRootApi, AccountsJurisdictionOverridesRootApi}
import org.upstartcommerce.avataxsdk.client.pekko.{AvataxCollectionCall, AvataxSimpleCall, Stream}

import scala.concurrent.Future

object AccountsRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      implicit system: ActorSystem,
      materializer: Materializer
  ): AccountsRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with AccountsRootApi[Future, Stream] {
      def forAccount(accountId: Int): AccountsApi[Future, Stream] = AccountsApiImpl(requester, security, clientHeaders)(accountId)

      def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[AccountModel] = {
        val uri = Uri(s"/api/v2/accounts").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[AccountModel](req)
      }

      def requestFreeTrial(model: FreeTrialRequestModel): AvataxSimpleCall[NewAccountModel] = {
        val uri = Uri(s"/api/v2/accounts/freetrial/request")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[FreeTrialRequestModel, NewAccountModel](req, model)
      }

      def requestNewAccount(model: NewAccountRequestModel): AvataxSimpleCall[NewAccountModel] = {
        val uri = Uri(s"/api/v2/accounts/request")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[NewAccountRequestModel, NewAccountModel](req, model)
      }

      def create(model: AccountModel): AvataxSimpleCall[List[AccountModel]] = {
        val uri = Uri(s"/api/v2/accounts")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[AccountModel, List[AccountModel]](req, model)
      }
    }
}
object AccountsApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      accountId: Int
  )(implicit system: ActorSystem, materializer: Materializer): AccountsApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with AccountsApi[Future, Stream] {

      val advancedRuleScripts: AccountAdvancedRuleScriptRootApi[Future, Stream] =
        AccountAdvancedRuleScriptRootApiImpl(requester, security, clientHeaders)(accountId)
      val advancedRuleTable: AccountAdvancedRuleTableRootApi[Future, Stream] =
        AccountAdvancedRuleTableRootApiImpl(requester, security, clientHeaders)(accountId)
      val accountJurisdictionOverrides: AccountsJurisdictionOverridesRootApi[Future, Stream] =
        AccountsJurisdictionOverridesRootApiImpl(requester, security, clientHeaders)(accountId)
      val subscriptions: AccountSubscriptionsRootApi[Future, Stream] =
        AccountSubscriptionsRootApiImpl(requester, security, clientHeaders)(accountId)
      val users: AccountUsersRootApi[Future, Stream] = AccountUsersRootApiImpl(requester, security, clientHeaders)(accountId)

      def resetLicenseKey(model: ResetLicenseKeyModel): AvataxSimpleCall[LicenseKeyModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/resetlicensekey")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[ResetLicenseKeyModel, LicenseKeyModel](req, model)
      }

      def activate(model: ActivateAccountModel): AvataxSimpleCall[AccountModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/activate")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[ActivateAccountModel, AccountModel](req, model)
      }

      def audit(start: java.util.Date, end: java.util.Date, options: BasicQueryOptions): AvataxCollectionCall[AuditModel] = {
        val uri =
          Uri(s"/api/v2/accounts/$accountId/audit")
            .withQuery(options.asQuery.and("start", dateFmt.format(start)).and("end", dateFmt.format(end)))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[AuditModel](req)
      }

      def get(include: Include): AvataxSimpleCall[AccountModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId").withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[AccountModel](req)
      }

      def getConfiguration: AvataxSimpleCall[List[AccountConfigurationModel]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/configuration")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[List[AccountConfigurationModel]](req)
      }

      def setConfiguration(model: List[AccountConfigurationModel]): AvataxSimpleCall[List[AccountConfigurationModel]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/configuration")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[AccountConfigurationModel], List[AccountConfigurationModel]](req, model)
      }

      def requestNewEntitlement(offer: String): AvataxSimpleCall[OfferModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/entitlements/$offer")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[OfferModel](req)
      }

      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def update(model: AccountModel): AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/accounts/$accountId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxSimpleCall[String](req)
      }
    }
}
