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
trait AccountsRootApi[F[_], S[_]] {
  def forAccount(accountId: Int): AccountsApi[F, S]

  def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, AccountModel]
  def requestFreeTrial(model: FreeTrialRequestModel): AvataxSimpleCall[F, NewAccountModel]
  def requestNewAccount(model: NewAccountRequestModel): AvataxSimpleCall[F, NewAccountModel]
  def create(model: AccountModel): AvataxSimpleCall[F, List[AccountModel]]
}

/** /api/v2/accounts/$accountId */
trait AccountsApi[F[_], S[_]] {
  def advancedRuleScripts: AccountAdvancedRuleScriptRootApi[F, S]
  def advancedRuleTable: AccountAdvancedRuleTableRootApi[F, S]
  def accountJurisdictionOverrides: AccountsJurisdictionOverridesRootApi[F, S]
  def subscriptions: AccountSubscriptionsRootApi[F, S]
  def users: AccountUsersRootApi[F, S]

  def resetLicenseKey(model: ResetLicenseKeyModel): AvataxSimpleCall[F, LicenseKeyModel]
  def activate(model: ActivateAccountModel): AvataxSimpleCall[F, AccountModel]
  def audit(start: java.util.Date, end: java.util.Date, options: BasicQueryOptions): AvataxCollectionCall[F, S, AuditModel]
  def get(include: Include): AvataxSimpleCall[F, AccountModel]
  def getConfiguration: AvataxSimpleCall[F, List[AccountConfigurationModel]]
  def requestNewEntitlement(offer: String): AvataxSimpleCall[F, OfferModel]
  def delete: AvataxSimpleCall[F, List[ErrorDetail]]
  def update(model: AccountModel): AvataxSimpleCall[F, String]
}
