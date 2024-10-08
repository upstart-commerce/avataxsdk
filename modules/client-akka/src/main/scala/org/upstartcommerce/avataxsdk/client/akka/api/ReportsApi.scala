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

package org.upstartcommerce.avataxsdk.client.akka.api

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client.akka._
import org.upstartcommerce.avataxsdk.client.akka.internal._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.{ReportsApi, ReportsRootApi}
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object ReportsRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      implicit system: ActorSystem,
      materializer: Materializer
  ): ReportsRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with ReportsRootApi[Future, Stream] {
      def forId(reportId: Long): ReportsApi[Future, Stream] = ReportsApiImpl(requester, security, clientHeaders)(reportId)

      def list: AvataxCollectionCall[ReportModel] = {
        val uri =
          Uri(s"/api/v2/reports")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ReportModel](req)
      }
    }
}

object ReportsApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      reportId: Long
  )(implicit system: ActorSystem, materializer: Materializer): ReportsApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with ReportsApi[Future, Stream] {
      def download: AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/reports/$reportId/attachment")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[String](req)
      }

      def get: AvataxSimpleCall[ReportModel] = {
        val uri = Uri(s"/api/v2/reports/$reportId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[ReportModel](req)
      }
    }
}
