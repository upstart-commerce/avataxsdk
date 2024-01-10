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
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.companies.{CompanyNoticesApi, CompanyNoticesRootApi}
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object CompanyNoticesRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyNoticesRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyNoticesRootApi[Future, Stream] {
      def forNoticeId(noticeId: Int): CompanyNoticesApi[Future, Stream] =
        CompanyNoticesApiImpl(requester, security, clientHeaders)(companyId, noticeId)

      def create(model: List[NoticeModel]): AvataxSimpleCall[List[NoticeModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[NoticeModel], List[NoticeModel]](req, model)
      }

      def downloadNoticeAttachment(resourceFileId: Long): AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/files/$resourceFileId/attachment")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[String](req)
      }

      def list(include: Include, options: QueryOptions): AvataxCollectionCall[NoticeModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NoticeModel](req)
      }

      def uploadAttachment(model: ResourceFileUploadRequestModel): AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/files/attachment")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[ResourceFileUploadRequestModel, String](req, model)
      }
    }
}

object CompanyNoticesApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int,
      noticeId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompanyNoticesApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyNoticesApi[Future, Stream] {
      def createComment(model: List[NoticeCommentModel]): AvataxSimpleCall[List[NoticeCommentModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId/comments")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[NoticeCommentModel], List[NoticeCommentModel]](req, model)
      }

      def createFinanceDetails(model: List[NoticeFinanceModel]): AvataxSimpleCall[List[NoticeFinanceModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId/financedetails")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[NoticeFinanceModel], List[NoticeFinanceModel]](req, model)
      }

      def createResponsibilities(model: List[NoticeResponsibilityDetailModel]): AvataxSimpleCall[List[NoticeResponsibilityDetailModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId/responsibilities")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[NoticeResponsibilityDetailModel], List[NoticeResponsibilityDetailModel]](req, model)
      }

      def createRootCauses(model: List[NoticeRootCauseDetailModel]): AvataxSimpleCall[List[NoticeRootCauseDetailModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId/rootcauses")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[NoticeRootCauseDetailModel], List[NoticeRootCauseDetailModel]](req, model)
      }

      def deleteCommentDetails(commentDetailsId: Int): AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId/commentdetails/$commentDetailsId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def deleteFinanceDetails(financeDetailsId: Int): AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId/financedetails/$financeDetailsId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def deleteNotice(): AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def deleteResponsibilities(responsibilityId: Int): AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId/responsibilities/$responsibilityId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def deleteRootCauses(rootCauseId: Int): AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId/rootcauses/$rootCauseId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get: AvataxSimpleCall[NoticeModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[NoticeModel](req)
      }

      def getComments: AvataxSimpleCall[NoticeCommentModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId/comments")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[NoticeCommentModel](req)
      }

      def getFinanceDetails: AvataxCollectionCall[NoticeFinanceModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId/financedetails")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NoticeFinanceModel](req)
      }

      def getResponsibilities: AvataxCollectionCall[NoticeResponsibilityDetailModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId/responsibilities")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NoticeResponsibilityDetailModel](req)
      }

      def getRootCauses: AvataxCollectionCall[NoticeRootCauseDetailModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId/rootcauses")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NoticeRootCauseDetailModel](req)
      }

      def updateFinanceDetails(financeDetailsId: Int, model: NoticeFinanceModel): AvataxSimpleCall[NoticeFinanceModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId/financedetails/$financeDetailsId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[NoticeFinanceModel, NoticeFinanceModel](req, model)
      }

      def update(model: NoticeModel): AvataxSimpleCall[NoticeModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[NoticeModel, NoticeModel](req, model)
      }

      def updateComments(commentDetailsId: Int, model: NoticeCommentModel): AvataxSimpleCall[NoticeCommentModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/notices/$noticeId/commentdetails/$commentDetailsId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[NoticeCommentModel, NoticeCommentModel](req, model)
      }
    }
}
