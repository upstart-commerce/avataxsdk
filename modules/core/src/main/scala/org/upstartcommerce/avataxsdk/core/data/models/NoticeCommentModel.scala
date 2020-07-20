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

package org.upstartcommerce.avataxsdk.core.data.models
import java.sql.Date
import org.upstartcommerce.avataxsdk.core.data.enums._

final case class NoticeCommentModel(
    id: Option[Int] = None,
    noticeId: Int,
    date: Option[Date] = None,
    comment: Option[String] = None,
    commentUserId: Option[Int] = None,
    commentUserName: Option[String] = None,
    commentTypeId: Option[Int] = None,
    commentType: CommentType,
    commentLink: Option[String] = None,
    taxNoticeFileName: Option[String] = None,
    resourceFileId: Option[Long] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None,
    attachmentUploadRequest: Option[ResourceFileUploadRequestModel] = None
) {

  def withId(value: Int): NoticeCommentModel = copy(id = Some(value))
  def withNoticeId(value: Int): NoticeCommentModel = copy(noticeId = value)
  def withDate(value: Date): NoticeCommentModel = copy(date = Some(value))
  def withComment(value: String): NoticeCommentModel = copy(comment = Some(value))
  def withCommentUserId(value: Int): NoticeCommentModel = copy(commentUserId = Some(value))
  def withCommentUserName(value: String): NoticeCommentModel = copy(commentUserName = Some(value))
  def withCommentTypeId(value: Int): NoticeCommentModel = copy(commentTypeId = Some(value))
  def withCommentType(value: CommentType): NoticeCommentModel = copy(commentType = value)
  def withCommentLink(value: String): NoticeCommentModel = copy(commentLink = Some(value))
  def withTaxNoticeFileName(value: String): NoticeCommentModel = copy(taxNoticeFileName = Some(value))
  def withResourceFileId(value: Long): NoticeCommentModel = copy(resourceFileId = Some(value))
  def withModifiedDate(value: Date): NoticeCommentModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): NoticeCommentModel = copy(modifiedUserId = Some(value))
  def withAttachmentUploadRequest(value: ResourceFileUploadRequestModel): NoticeCommentModel = copy(attachmentUploadRequest = Some(value))
}
