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

final case class NoticeFinanceModel(
    id: Option[Int] = None,
    noticeId: Option[Int] = None,
    noticeDate: Option[Date] = None,
    dueDate: Option[Date] = None,
    noticeNumber: Option[String] = None,
    taxDue: Option[BigDecimal] = None,
    penalty: Option[BigDecimal] = None,
    interest: Option[BigDecimal] = None,
    credits: Option[BigDecimal] = None,
    taxAbated: Option[BigDecimal] = None,
    customerPenalty: Option[BigDecimal] = None,
    customerInterest: Option[BigDecimal] = None,
    cspFeeRefund: Option[BigDecimal] = None,
    fileName: Option[String] = None,
    resourceFileId: Option[Long] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None,
    attachmentUploadRequest: Option[ResourceFileUploadRequestModel] = None
) {

  def withId(value: Int): NoticeFinanceModel = copy(id = Some(value))
  def withNoticeId(value: Int): NoticeFinanceModel = copy(noticeId = Some(value))
  def withNoticeDate(value: Date): NoticeFinanceModel = copy(noticeDate = Some(value))
  def withDueDate(value: Date): NoticeFinanceModel = copy(dueDate = Some(value))
  def withNoticeNumber(value: String): NoticeFinanceModel = copy(noticeNumber = Some(value))
  def withTaxDue(value: BigDecimal): NoticeFinanceModel = copy(taxDue = Some(value))
  def withPenalty(value: BigDecimal): NoticeFinanceModel = copy(penalty = Some(value))
  def withInterest(value: BigDecimal): NoticeFinanceModel = copy(interest = Some(value))
  def withCredits(value: BigDecimal): NoticeFinanceModel = copy(credits = Some(value))
  def withTaxAbated(value: BigDecimal): NoticeFinanceModel = copy(taxAbated = Some(value))
  def withCustomerPenalty(value: BigDecimal): NoticeFinanceModel = copy(customerPenalty = Some(value))
  def withCustomerInterest(value: BigDecimal): NoticeFinanceModel = copy(customerInterest = Some(value))
  def withCspFeeRefund(value: BigDecimal): NoticeFinanceModel = copy(cspFeeRefund = Some(value))
  def withFileName(value: String): NoticeFinanceModel = copy(fileName = Some(value))
  def withResourceFileId(value: Long): NoticeFinanceModel = copy(resourceFileId = Some(value))
  def withCreatedDate(value: Date): NoticeFinanceModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): NoticeFinanceModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): NoticeFinanceModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): NoticeFinanceModel = copy(modifiedUserId = Some(value))
  def withAttachmentUploadRequest(value: ResourceFileUploadRequestModel): NoticeFinanceModel = copy(attachmentUploadRequest = Some(value))
}
