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

package org.upstartcommerce.avataxsdk.client.akka.api.companies

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client.akka._
import org.upstartcommerce.avataxsdk.client.akka.api._
import org.upstartcommerce.avataxsdk.client.akka.internal._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.companies.{CompanyReportsApi, CompanyReportsRootApi}
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object CompanyReportsRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyReportsRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyReportsRootApi[Future, Stream] {
      def forId(reportId: Long): CompanyReportsApi[Future, Stream] =
        CompanyReportsApiImpl(requester, security, clientHeaders)(companyId, reportId)

      def exportDocumentLine(model: ExportDocumentLineModel): AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/companies/$companyId/reports/exportdocumentline")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[ExportDocumentLineModel, String](req, model)
      }

      def initiateExportDocumentLineReport(model: ExportDocumentLineModel): AvataxSimpleCall[List[ReportModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/reports/exportdocumentline/initiate")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[ExportDocumentLineModel, List[ReportModel]](req, model)
      }
    }
}

object CompanyReportsApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      reportId: Long
  )(implicit system: ActorSystem, materializer: Materializer): CompanyReportsApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyReportsApi[Future, Stream] {}
}
