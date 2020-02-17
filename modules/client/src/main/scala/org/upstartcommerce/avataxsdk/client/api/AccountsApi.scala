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
import akka.http.scaladsl.model.headers._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client.api.accounts.{AccountSubscriptionsRootApi, AccountUsersRootApi, AccountsJurisdictionOverridesRootApi}
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.client.{AvataxCollectionCall, AvataxSimpleCall}
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._

import akka.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

/** /api/v2/accounts */
trait AccountsRootApi {
  def forAccount(accountId:Int): AccountsApi

  def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[AccountModel]
  def requestFreeTrial(model:FreeTrialRequestModel):AvataxSimpleCall[NewAccountModel]
  def requestNewAccount(model:NewAccountRequestModel):AvataxSimpleCall[NewAccountModel]
  def create(model:AccountModel):AvataxSimpleCall[List[AccountModel]]
}

object AccountsRootApi {
  def apply(requester: Requester, security: Option[Authorization])(implicit system: ActorSystem,
                                                                                 materializer: Materializer): AccountsRootApi =
    new ApiRoot(requester, security) with AccountsRootApi {
      def forAccount(accountId: Int): AccountsApi = AccountsApi(requester, security)(accountId)

      def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[AccountModel] = {
        val uri = Uri(s"/api/v2/accounts").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[AccountModel](req)
      }

      def requestFreeTrial(model:FreeTrialRequestModel):AvataxSimpleCall[NewAccountModel] = {
        val uri = Uri(s"/api/v2/accounts/freetrial/request")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[FreeTrialRequestModel, NewAccountModel](req, model)
      }

      def requestNewAccount(model:NewAccountRequestModel):AvataxSimpleCall[NewAccountModel] = {
        val uri = Uri(s"/api/v2/accounts/request")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[NewAccountRequestModel, NewAccountModel](req, model)
      }

      def create(model:AccountModel):AvataxSimpleCall[List[AccountModel]] = {
        val uri = Uri(s"/api/v2/accounts")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[AccountModel, List[AccountModel]](req, model)
      }
    }
}

/** /api/v2/accounts/$accountId */
trait AccountsApi {
  def advancedRuleScripts: AccountAdvancedRuleScriptRootApi
  def advancedRuleTable: AccountAdvancedRuleTableRootApi
  def accountJurisdictionOverrides: AccountsJurisdictionOverridesRootApi
  def subscriptions: AccountSubscriptionsRootApi
  def users: AccountUsersRootApi

  def resetLicenseKey(model: ResetLicenseKeyModel): AvataxSimpleCall[LicenseKeyModel]
  def activate(model: ActivateAccountModel): AvataxSimpleCall[AccountModel]
  def audit(start: Date, end: Date, options: BasicQueryOptions): AvataxCollectionCall[AuditModel]
  def get(include: Include): AvataxSimpleCall[AccountModel]
  def getConfiguration: AvataxSimpleCall[List[AccountConfigurationModel]]
  def requestNewEntitlement(offer:String):AvataxSimpleCall[OfferModel]
  def delete:AvataxSimpleCall[List[ErrorDetail]]
  def update(model:AccountModel):AvataxSimpleCall[String]
}

object AccountsApi {
  def apply(requester: Requester, security: Option[Authorization])(accountId: Int)(implicit system: ActorSystem,
                                                                                 materializer: Materializer): AccountsApi =
    new ApiRoot(requester, security) with AccountsApi {

      val advancedRuleScripts: AccountAdvancedRuleScriptRootApi = AccountAdvancedRuleScriptRootApi(requester, security)(accountId)
      val advancedRuleTable: AccountAdvancedRuleTableRootApi = AccountAdvancedRuleTableRootApi(requester, security)(accountId)
      val accountJurisdictionOverrides: AccountsJurisdictionOverridesRootApi = AccountsJurisdictionOverridesRootApi(requester, security)(accountId)
      val subscriptions: AccountSubscriptionsRootApi = AccountSubscriptionsRootApi(requester, security)(accountId)
      val users: AccountUsersRootApi = AccountUsersRootApi(requester, security)(accountId)

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

      def audit(start: Date, end: Date, options: BasicQueryOptions): AvataxCollectionCall[AuditModel] = {
        val uri =
          Uri(s"/api/v2/accounts/$accountId/audit").withQuery(options.asQuery.and("start", dateFmt.format(start)).and("end", dateFmt.format(end)))
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

      def setConfiguration(model:List[AccountConfigurationModel]):AvataxSimpleCall[List[AccountConfigurationModel]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/configuration")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[AccountConfigurationModel], List[AccountConfigurationModel]](req, model)
      }

      def requestNewEntitlement(offer:String):AvataxSimpleCall[OfferModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/entitlements/$offer")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[OfferModel](req)
      }

      def delete:AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def update(model:AccountModel):AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/accounts/$accountId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxSimpleCall[String](req)
      }
    }
}
