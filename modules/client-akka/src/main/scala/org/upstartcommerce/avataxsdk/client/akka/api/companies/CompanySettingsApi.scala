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

package org.upstartcommerce.avataxsdk.client.akka.api.companies

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client.akka._
import org.upstartcommerce.avataxsdk.client.akka.api._
import org.upstartcommerce.avataxsdk.client.akka.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.companies.{CompanySettingsApi, CompanySettingsRootApi}
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object CompanySettingsRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanySettingsRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanySettingsRootApi[Future, Stream] {
      def forId(settingsId: Int): CompanySettingsApi[Future, Stream] =
        CompanySettingsApiImpl(requester, security, clientHeaders)(companyId, settingsId)

      def create(model: List[SettingModel]): AvataxSimpleCall[List[SettingModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/settings")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[SettingModel], List[SettingModel]](req, model)
      }

      def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[SettingModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/settings").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[SettingModel](req)
      }

    }
}

object CompanySettingsApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      settingsId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanySettingsApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanySettingsApi[Future, Stream] {
      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/settings/$settingsId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get: AvataxSimpleCall[SettingModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/settings/$settingsId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[SettingModel](req)
      }

      def update(model: SettingModel): AvataxSimpleCall[SettingModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/settings/$settingsId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[SettingModel, SettingModel](req, model)
      }
    }
}
