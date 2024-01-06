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

package org.upstartcommerce.avataxsdk.client.api.companies

import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.http.scaladsl.model.HttpMethods._
import org.apache.pekko.http.scaladsl.model._
import org.apache.pekko.stream.Materializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.api._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.apache.pekko.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import org.upstartcommerce.avataxsdk.client.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders

/** api/v2/companies/$companyId/datasources */
trait CompanyDataSourcesRootApi {
  def forDataSourceId(dataSourceId: Int): CompanyDataSourcesApi

  def create(model: List[DataSourceModel]): AvataxSimpleCall[List[DataSourceModel]]
  def list(options: FiltrableQueryOptions): AvataxCollectionCall[DataSourceModel]
}

object CompanyDataSourcesRootApi {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyDataSourcesRootApi =
    new ApiRoot(requester, security, clientHeaders) with CompanyDataSourcesRootApi {
      def forDataSourceId(dataSourceId: Int): CompanyDataSourcesApi =
        CompanyDataSourcesApi(requester, security, clientHeaders)(companyId, dataSourceId)

      def create(model: List[DataSourceModel]): AvataxSimpleCall[List[DataSourceModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/datasources")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[DataSourceModel], List[DataSourceModel]](req, model)
      }

      def list(options: FiltrableQueryOptions): AvataxCollectionCall[DataSourceModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/datasources")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[DataSourceModel](req)
      }
    }
}

/** api/v2/companies/$companyId/datasources/$dataSourceId */
trait CompanyDataSourcesApi {
  def delete: AvataxSimpleCall[List[ErrorDetail]]
  def get: AvataxSimpleCall[DataSourceModel]
  def update(model: DataSourceModel): AvataxSimpleCall[DataSourceModel]
}
object CompanyDataSourcesApi {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      dataSourceId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyDataSourcesApi =
    new ApiRoot(requester, security, clientHeaders) with CompanyDataSourcesApi {
      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/datasources/$dataSourceId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get: AvataxSimpleCall[DataSourceModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/datasources/$dataSourceId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[DataSourceModel](req)
      }

      def update(model: DataSourceModel): AvataxSimpleCall[DataSourceModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/datasources/$dataSourceId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[DataSourceModel, DataSourceModel](req, model)
      }
    }
}
