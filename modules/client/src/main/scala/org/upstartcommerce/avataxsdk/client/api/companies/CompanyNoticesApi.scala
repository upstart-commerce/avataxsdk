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

import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders

/** /api/v2/companies/$companyId */
trait CompanyNoticesRootApi[F[_], S[_]] {
  def forNoticeId(noticeId: Int): CompanyNoticesApi[F, S]

  def create(model: List[NoticeModel]): AvataxSimpleCall[F, List[NoticeModel]]
  def downloadNoticeAttachment(resourceFileId: Long): AvataxSimpleCall[F, String]
  def list(include: Include, options: QueryOptions): AvataxCollectionCall[F, S, NoticeModel]
  def uploadAttachment(model: ResourceFileUploadRequestModel): AvataxSimpleCall[F, String]
}

/** /api/v2/companies/$companyId/notices/$noticeId */
trait CompanyNoticesApi[F[_], S[_]] {
  def createComment(model: List[NoticeCommentModel]): AvataxSimpleCall[F, List[NoticeCommentModel]]
  def createFinanceDetails(model: List[NoticeFinanceModel]): AvataxSimpleCall[F, List[NoticeFinanceModel]]
  def createResponsibilities(model: List[NoticeResponsibilityDetailModel]): AvataxSimpleCall[F, List[NoticeResponsibilityDetailModel]]
  def createRootCauses(model: List[NoticeRootCauseDetailModel]): AvataxSimpleCall[F, List[NoticeRootCauseDetailModel]]
  def deleteCommentDetails(commentDetailsId: Int): AvataxSimpleCall[F, List[ErrorDetail]]
  def deleteFinanceDetails(financeDetailsId: Int): AvataxSimpleCall[F, List[ErrorDetail]]
  def deleteNotice(): AvataxSimpleCall[F, List[ErrorDetail]]
  def deleteResponsibilities(responsibilityId: Int): AvataxSimpleCall[F, List[ErrorDetail]]
  def deleteRootCauses(rootCauseId: Int): AvataxSimpleCall[F, List[ErrorDetail]]
  def get: AvataxSimpleCall[F, NoticeModel]
  def getComments: AvataxSimpleCall[F, NoticeCommentModel]
  def getFinanceDetails: AvataxCollectionCall[F, S, NoticeFinanceModel]
  def getResponsibilities: AvataxCollectionCall[F, S, NoticeResponsibilityDetailModel]
  def getRootCauses: AvataxCollectionCall[F, S, NoticeRootCauseDetailModel]
  def updateFinanceDetails(financeDetailsId: Int, model: NoticeFinanceModel): AvataxSimpleCall[F, NoticeFinanceModel]
  def update(model: NoticeModel): AvataxSimpleCall[F, NoticeModel]
  def updateComments(commentDetailsId: Int, model: NoticeCommentModel): AvataxSimpleCall[F, NoticeCommentModel]
}
