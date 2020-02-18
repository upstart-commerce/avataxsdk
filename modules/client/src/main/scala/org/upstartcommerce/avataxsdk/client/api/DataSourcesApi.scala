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
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

/** /api/v2/datasources */
trait DataSourcesRootApi {
  def forDataSourceId(dataSourceId:Int): DataSourcesApi

  def query(options:FiltrableQueryOptions):AvataxCollectionCall[DataSourceModel]
}

object DataSourcesRootApi {
  def apply(requester: Requester, security: Option[Authorization])(implicit system: ActorSystem, materializer: Materializer): DataSourcesRootApi =
    new ApiRoot(requester, security) with DataSourcesRootApi {
      def forDataSourceId(dataSourceId: Int): DataSourcesApi = DataSourcesApi(requester, security)(dataSourceId)

      def query(options:FiltrableQueryOptions):AvataxCollectionCall[DataSourceModel] = {
        val uri = Uri(s"/api/v2/datasources").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[DataSourceModel](req)
      }
    }
}

/** /api/v2/datasources/$dataSourceId */
trait DataSourcesApi {}
object DataSourcesApi {
  def apply(requester: Requester, security: Option[Authorization])(dataSourceId:Int)(implicit system: ActorSystem, materializer: Materializer): DataSourcesApi =
    new ApiRoot(requester, security) with DataSourcesApi {}
}