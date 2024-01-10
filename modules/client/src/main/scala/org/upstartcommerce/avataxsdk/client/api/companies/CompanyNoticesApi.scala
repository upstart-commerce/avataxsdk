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

import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders

/** /api/v2/companies/$companyId */
trait CompanyNoticesRootApi {
  def forNoticeId(noticeId: Int): CompanyNoticesApi

  def create(model: List[NoticeModel]): AvataxSimpleCall[List[NoticeModel]]
  def downloadNoticeAttachment(resourceFileId: Long): AvataxSimpleCall[String]
  def list(include: Include, options: QueryOptions): AvataxCollectionCall[NoticeModel]
  def uploadAttachment(model: ResourceFileUploadRequestModel): AvataxSimpleCall[String]
}

/** /api/v2/companies/$companyId/notices/$noticeId */
trait CompanyNoticesApi {
  def createComment(model: List[NoticeCommentModel]): AvataxSimpleCall[List[NoticeCommentModel]]
  def createFinanceDetails(model: List[NoticeFinanceModel]): AvataxSimpleCall[List[NoticeFinanceModel]]
  def createResponsibilities(model: List[NoticeResponsibilityDetailModel]): AvataxSimpleCall[List[NoticeResponsibilityDetailModel]]
  def createRootCauses(model: List[NoticeRootCauseDetailModel]): AvataxSimpleCall[List[NoticeRootCauseDetailModel]]
  def deleteCommentDetails(commentDetailsId: Int): AvataxSimpleCall[List[ErrorDetail]]
  def deleteFinanceDetails(financeDetailsId: Int): AvataxSimpleCall[List[ErrorDetail]]
  def deleteNotice(): AvataxSimpleCall[List[ErrorDetail]]
  def deleteResponsibilities(responsibilityId: Int): AvataxSimpleCall[List[ErrorDetail]]
  def deleteRootCauses(rootCauseId: Int): AvataxSimpleCall[List[ErrorDetail]]
  def get: AvataxSimpleCall[NoticeModel]
  def getComments: AvataxSimpleCall[NoticeCommentModel]
  def getFinanceDetails: AvataxCollectionCall[NoticeFinanceModel]
  def getResponsibilities: AvataxCollectionCall[NoticeResponsibilityDetailModel]
  def getRootCauses: AvataxCollectionCall[NoticeRootCauseDetailModel]
  def updateFinanceDetails(financeDetailsId: Int, model: NoticeFinanceModel): AvataxSimpleCall[NoticeFinanceModel]
  def update(model: NoticeModel): AvataxSimpleCall[NoticeModel]
  def updateComments(commentDetailsId: Int, model: NoticeCommentModel): AvataxSimpleCall[NoticeCommentModel]
}
