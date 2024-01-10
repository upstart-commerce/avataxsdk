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

package org.upstartcommerce.avataxsdk.client

import org.upstartcommerce.avataxsdk.client.api._

// todo: remove date for more usable one
// todo: swap strings for enums
// todo: remove .toStrings (from enums etc.)
// todo: non-generic include as Set()
// todo: enums

trait AvataxClient {

  def accounts: AccountsRootApi
  def addresses: AddressesRootApi
  def batches: BatchesRootApi
  def companies: CompaniesRootApi
  def definitions: DefinitionsRootApi
  def contacts: ContactsRootApi
  def dataSources: DataSourcesRootApi
  def distanceThresholds: DistanceThresholdsRootApi
  def filingCalendars: FilingCalendarsRootApi
  def filingRequests: FilingRequestsRootApi
  def taxRates: TaxRatesRootApi
  def fundingRequests: FundingRequestsRootApi
  def items: ItemsRootApi
  def jurisdictionOverrides: JurisdictionOverridesRootApi
  def locations: LocationsRootApi
  def transactions: TransactionsRootApi
  def nexuses: NexusRootApi
  def notices: NoticesRootApi
  def notifications: NotificationsRootApi
  def passwords: PasswordsRootApi
  def reports: ReportsRootApi
  def settings: SettingsRootApi
  def taxCodes: TaxCodesRootApi
  def subscriptions: SubscriptionsRootApi
  def taxContents: TaxContentsRootApi
  def upcs: UPCRootApi
  def users: UsersRootApi
  def utilities: UtilitiesRootApi
  def taxRatesByZipCode: TaxRatesByZipCodeRootApi
}

object AvataxClient {

  final case class SecuritySettings(username: String, password: String)
  final case class ClientHeaders(
      appName: String,
      appVersion: String,
      adapterName: String,
      adapterVersion: String,
      machineName: Option[String]
  )
}
