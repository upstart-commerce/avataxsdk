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

import org.upstartcommerce.avataxsdk.client.api.accounts.{AccountSubscriptionsRootApi, AccountUsersRootApi, AccountsJurisdictionOverridesRootApi}
import org.upstartcommerce.avataxsdk.client.{AvataxCollectionCall, AvataxSimpleCall}
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._

/** /api/v2/accounts */
trait AccountsRootApi {
  def forAccount(accountId: Int): AccountsApi

  def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[AccountModel]
  def requestFreeTrial(model: FreeTrialRequestModel): AvataxSimpleCall[NewAccountModel]
  def requestNewAccount(model: NewAccountRequestModel): AvataxSimpleCall[NewAccountModel]
  def create(model: AccountModel): AvataxSimpleCall[List[AccountModel]]
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
  def audit(start: java.util.Date, end: java.util.Date, options: BasicQueryOptions): AvataxCollectionCall[AuditModel]
  def get(include: Include): AvataxSimpleCall[AccountModel]
  def getConfiguration: AvataxSimpleCall[List[AccountConfigurationModel]]
  def requestNewEntitlement(offer: String): AvataxSimpleCall[OfferModel]
  def delete: AvataxSimpleCall[List[ErrorDetail]]
  def update(model: AccountModel): AvataxSimpleCall[String]
}
