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

package org.upstartcommerce.avataxsdk.client.api.companies

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.api._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

/** /api/v2/companies/$companyId/settings */
trait CompanySettingsRootApi {
  def forId(settingsId:Int): CompanySettingsApi

  def create(model:List[SettingModel]):AvataxSimpleCall[List[SettingModel]]
  def list(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[SettingModel]
}

object CompanySettingsRootApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId:Int)(implicit system: ActorSystem, materializer: Materializer): CompanySettingsRootApi =
    new ApiRoot(requester, security) with CompanySettingsRootApi {
      def forId(settingsId: Int): CompanySettingsApi = CompanySettingsApi(requester, security)(companyId, settingsId)

      def create(model:List[SettingModel]):AvataxSimpleCall[List[SettingModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/settings")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[SettingModel], List[SettingModel]](req, model)
      }

      def list(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[SettingModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/settings")
          .withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[SettingModel](req)
      }

    }
}

/** /api/v2/companies/$companyId/settings/$settingsId */
trait CompanySettingsApi {
  def delete:AvataxSimpleCall[List[ErrorDetail]]
  def get:AvataxSimpleCall[SettingModel]
  def update(model:SettingModel):AvataxSimpleCall[SettingModel]
}

object CompanySettingsApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId:Int, settingsId:Int)(implicit system: ActorSystem, materializer: Materializer): CompanySettingsApi =
    new ApiRoot(requester, security) with CompanySettingsApi {
      def delete:AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/settings/$settingsId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get:AvataxSimpleCall[SettingModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/settings/$settingsId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[SettingModel](req)
      }

      def update(model:SettingModel):AvataxSimpleCall[SettingModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/settings/$settingsId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[SettingModel, SettingModel](req, model)
      }
    }
}