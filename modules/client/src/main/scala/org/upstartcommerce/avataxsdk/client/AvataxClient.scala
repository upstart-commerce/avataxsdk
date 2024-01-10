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

trait AvataxClient[F[_], S[_]] {

  def accounts: AccountsRootApi[F, S]
  def addresses: AddressesRootApi[F, S]
  def batches: BatchesRootApi[F, S]
  def companies: CompaniesRootApi[F, S]
  def definitions: DefinitionsRootApi[F, S]
  def contacts: ContactsRootApi[F, S]
  def dataSources: DataSourcesRootApi[F, S]
  def distanceThresholds: DistanceThresholdsRootApi[F, S]
  def filingCalendars: FilingCalendarsRootApi[F, S]
  def filingRequests: FilingRequestsRootApi[F, S]
  def taxRates: TaxRatesRootApi[F, S]
  def fundingRequests: FundingRequestsRootApi[F, S]
  def items: ItemsRootApi[F, S]
  def jurisdictionOverrides: JurisdictionOverridesRootApi[F, S]
  def locations: LocationsRootApi[F, S]
  def transactions: TransactionsRootApi[F, S]
  def nexuses: NexusRootApi[F, S]
  def notices: NoticesRootApi[F, S]
  def notifications: NotificationsRootApi[F, S]
  def passwords: PasswordsRootApi[F, S]
  def reports: ReportsRootApi[F, S]
  def settings: SettingsRootApi[F, S]
  def taxCodes: TaxCodesRootApi[F, S]
  def subscriptions: SubscriptionsRootApi[F, S]
  def taxContents: TaxContentsRootApi[F, S]
  def upcs: UPCRootApi[F, S]
  def users: UsersRootApi[F, S]
  def utilities: UtilitiesRootApi[F, S]
  def taxRatesByZipCode: TaxRatesByZipCodeRootApi[F, S]
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
