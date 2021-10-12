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

import akka.actor.ActorSystem
import akka.http.scaladsl.model.headers
import akka.http.scaladsl.model.headers._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client.api._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data.Environment
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._

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

  /**
    * @param environment to be used during requests
    * @param poolQueueSize amount of requests that can be waiting in line before they start being dropped
    * @param security provides header for requests
    * @return reactive avatax client
    */
  def apply(
      environment: Environment,
      poolQueueSize: Int = 128,
      security: Option[SecuritySettings] = None,
      clientHeaders: Option[ClientHeaders] = None
  )(implicit system: ActorSystem, materializer: Materializer): AvataxClient = {
    val poolFlow = HostPool.forUrl(environment.url)
    val requester = Requester.pooled(poolFlow, poolQueueSize)
    val credentials = security.map(x => headers.Authorization(BasicHttpCredentials(x.username, x.password)))
    apply(requester, credentials, clientHeaders)
  }

  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      implicit system: ActorSystem,
      materializer: Materializer
  ): AvataxClient = {

    new ApiRoot(requester, security, clientHeaders) with AvataxClient {
      val accounts: AccountsRootApi = AccountsRootApi(requester, security, clientHeaders)
      val addresses: AddressesRootApi = AddressesRootApi(requester, security, clientHeaders)
      val batches: BatchesRootApi = BatchesRootApi(requester, security, clientHeaders)
      val companies: CompaniesRootApi = CompaniesRootApi(requester, security, clientHeaders)
      val definitions: DefinitionsRootApi = DefinitionsRootApi(requester, security, clientHeaders)
      val contacts: ContactsRootApi = ContactsRootApi(requester, security, clientHeaders)
      val dataSources: DataSourcesRootApi = DataSourcesRootApi(requester, security, clientHeaders)
      val distanceThresholds: DistanceThresholdsRootApi = DistanceThresholdsRootApi(requester, security, clientHeaders)
      val filingCalendars: FilingCalendarsRootApi = FilingCalendarsRootApi(requester, security, clientHeaders)
      val filingRequests: FilingRequestsRootApi = FilingRequestsRootApi(requester, security, clientHeaders)
      val taxRates: TaxRatesRootApi = TaxRatesRootApi(requester, security, clientHeaders)
      val fundingRequests: FundingRequestsRootApi = FundingRequestsRootApi(requester, security, clientHeaders)
      val items: ItemsRootApi = ItemsRootApi(requester, security, clientHeaders)
      val jurisdictionOverrides: JurisdictionOverridesRootApi = JurisdictionOverridesRootApi(requester, security, clientHeaders)
      val locations: LocationsRootApi = LocationsRootApi(requester, security, clientHeaders)
      val transactions: TransactionsRootApi = TransactionsRootApi(requester, security, clientHeaders)
      val nexuses: NexusRootApi = NexusRootApi(requester, security, clientHeaders)
      val notices: NoticesRootApi = NoticesRootApi(requester, security, clientHeaders)
      val notifications: NotificationsRootApi = NotificationsRootApi(requester, security, clientHeaders)
      val passwords: PasswordsRootApi = PasswordsRootApi(requester, security, clientHeaders)
      val reports: ReportsRootApi = ReportsRootApi(requester, security, clientHeaders)
      val settings: SettingsRootApi = SettingsRootApi(requester, security, clientHeaders)
      val taxCodes: TaxCodesRootApi = TaxCodesRootApi(requester, security, clientHeaders)
      val subscriptions: SubscriptionsRootApi = SubscriptionsRootApi(requester, security, clientHeaders)
      val taxContents: TaxContentsRootApi = TaxContentsRootApi(requester, security, clientHeaders)
      val upcs: UPCRootApi = UPCRootApi(requester, security, clientHeaders)
      val users: UsersRootApi = UsersRootApi(requester, security, clientHeaders)
      val utilities: UtilitiesRootApi = UtilitiesRootApi(requester, security, clientHeaders)
      val taxRatesByZipCode: TaxRatesByZipCodeRootApi = TaxRatesByZipCodeRootApi(requester, security, clientHeaders)
    }
  }
}
