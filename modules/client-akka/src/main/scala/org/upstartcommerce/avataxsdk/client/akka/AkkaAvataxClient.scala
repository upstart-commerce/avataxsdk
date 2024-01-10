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

package org.upstartcommerce.avataxsdk.client.akka

import akka.actor.ActorSystem
import akka.http.scaladsl.model.headers
import akka.http.scaladsl.model.headers._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client.AvataxClient
import org.upstartcommerce.avataxsdk.client.AvataxClient.{ClientHeaders, SecuritySettings}
import org.upstartcommerce.avataxsdk.client.api._
import org.upstartcommerce.avataxsdk.client.akka.api._
import org.upstartcommerce.avataxsdk.client.akka.internal._
import org.upstartcommerce.avataxsdk.core.data.Environment

import scala.concurrent.Future

// todo: remove date for more usable one
// todo: swap strings for enums
// todo: remove .toStrings (from enums etc.)
// todo: non-generic include as Set()
// todo: enums

object AkkaAvataxClient {

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
  )(implicit system: ActorSystem, materializer: Materializer): AvataxClient[Future, Stream] = {
    val poolFlow = HostPool.forUrl(environment.url)
    val requester = Requester.pooled(poolFlow, poolQueueSize)
    val credentials = security.map(x => headers.Authorization(BasicHttpCredentials(x.username, x.password)))
    apply(requester, credentials, clientHeaders)
  }

  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      implicit system: ActorSystem,
      materializer: Materializer
  ): AvataxClient[Future, Stream] = {

    new ApiRoot(requester, security, clientHeaders) with AvataxClient[Future, Stream] {
      val accounts: AccountsRootApi[Future, Stream] = AccountsRootApiImpl(requester, security, clientHeaders)
      val addresses: AddressesRootApi[Future, Stream] = AddressesRootApiImpl(requester, security, clientHeaders)
      val batches: BatchesRootApi[Future, Stream] = BatchesRootApiImpl(requester, security, clientHeaders)
      val companies: CompaniesRootApi[Future, Stream] = CompaniesRootApiImpl(requester, security, clientHeaders)
      val definitions: DefinitionsRootApi[Future, Stream] = DefinitionsRootApiImpl(requester, security, clientHeaders)
      val contacts: ContactsRootApi[Future, Stream] = ContactsRootApiImpl(requester, security, clientHeaders)
      val dataSources: DataSourcesRootApi[Future, Stream] = DataSourcesRootApiImpl(requester, security, clientHeaders)
      val distanceThresholds: DistanceThresholdsRootApi[Future, Stream] = DistanceThresholdsRootApiImpl(requester, security, clientHeaders)
      val filingCalendars: FilingCalendarsRootApi[Future, Stream] = FilingCalendarsRootApiImpl(requester, security, clientHeaders)
      val filingRequests: FilingRequestsRootApi[Future, Stream] = FilingRequestsRootApiImpl(requester, security, clientHeaders)
      val taxRates: TaxRatesRootApi[Future, Stream] = TaxRatesRootApiImpl(requester, security, clientHeaders)
      val fundingRequests: FundingRequestsRootApi[Future, Stream] = FundingRequestsRootApiImpl(requester, security, clientHeaders)
      val items: ItemsRootApi[Future, Stream] = ItemsRootApiImpl(requester, security, clientHeaders)
      val jurisdictionOverrides: JurisdictionOverridesRootApi[Future, Stream] =
        JurisdictionOverridesRootApiImpl(requester, security, clientHeaders)
      val locations: LocationsRootApi[Future, Stream] = LocationsRootApiImpl(requester, security, clientHeaders)
      val transactions: TransactionsRootApi[Future, Stream] = TransactionsRootApiImpl(requester, security, clientHeaders)
      val nexuses: NexusRootApi[Future, Stream] = NexusRootApiImpl(requester, security, clientHeaders)
      val notices: NoticesRootApi[Future, Stream] = NoticesRootApiImpl(requester, security, clientHeaders)
      val notifications: NotificationsRootApi[Future, Stream] = NotificationsRootApiImpl(requester, security, clientHeaders)
      val passwords: PasswordsRootApi[Future, Stream] = PasswordsRootApiImpl(requester, security, clientHeaders)
      val reports: ReportsRootApi[Future, Stream] = ReportsRootApiImpl(requester, security, clientHeaders)
      val settings: SettingsRootApi[Future, Stream] = SettingsRootApiImpl(requester, security, clientHeaders)
      val taxCodes: TaxCodesRootApi[Future, Stream] = TaxCodesRootApiImpl(requester, security, clientHeaders)
      val subscriptions: SubscriptionsRootApi[Future, Stream] = SubscriptionsRootApiImpl(requester, security, clientHeaders)
      val taxContents: TaxContentsRootApi[Future, Stream] = TaxContentsRootApiImpl(requester, security, clientHeaders)
      val upcs: UPCRootApi[Future, Stream] = UPCRootApiImpl(requester, security, clientHeaders)
      val users: UsersRootApi[Future, Stream] = UsersRootApiImpl(requester, security, clientHeaders)
      val utilities: UtilitiesRootApi[Future, Stream] = UtilitiesRootApiImpl(requester, security, clientHeaders)
      val taxRatesByZipCode: TaxRatesByZipCodeRootApi[Future, Stream] = TaxRatesByZipCodeRootApiImpl(requester, security, clientHeaders)
    }
  }
}
