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

final case class NoticeModel(
    id: Int,
    companyId: Int,
    statusId: Int,
    status: Option[String] = None,
    receivedDate: Date,
    closedDate: Option[Date] = None,
    totalRemit: Option[BigDecimal] = None,
    customerTypeId: NoticeCustomerType,
    country: Option[String] = None,
    region: Option[String] = None,
    taxAuthorityId: Option[Int] = None,
    filingFrequency: Option[FilingFrequencyId] = None,
    filingTypeId: Option[TaxNoticeFilingTypeId] = None,
    ticketReferenceNo: Option[String] = None,
    ticketReferenceUrl: Option[String] = None,
    salesForceCase: Option[String] = None,
    salesForceCaseUrl: Option[String] = None,
    taxPeriod: Option[String] = None,
    reasonId: Int,
    reason: Option[String] = None,
    typeId: Option[Int] = None,
    `type`: Option[String] = None,
    customerFundingOptionId: Option[FundingOption] = None,
    priorityId: NoticePriorityId,
    customerComment: Option[String] = None,
    hideFromCustomer: Boolean,
    expectedResolutionDate: Option[Date] = None,
    showResolutionDateToCustomer: Boolean,
    closedByUserId: Option[Int] = None,
    createdByUserName: Option[String] = None,
    ownedByUserId: Option[Int] = None,
    description: Option[String] = None,
    avaFileFormId: Option[Int] = None,
    revenueContactId: Option[Int] = None,
    complianceContactId: Option[Int] = None,
    taxFormCode: Option[String] = None,
    documentReference: Option[String] = None,
    jurisdictionName: Option[String] = None,
    jurisdictionType: Option[String] = None,
    comments: Option[List[NoticeCommentModel]] = None,
    finances: Option[List[NoticeFinanceModel]] = None,
    responsibility: Option[List[NoticeResponsibilityDetailModel]] = None,
    rootCause: Option[List[NoticeRootCauseDetailModel]] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None
) {
  lazy val commentsRaw: List[NoticeCommentModel] = comments.getOrElse(List.empty)
  lazy val financesRaw: List[NoticeFinanceModel] = finances.getOrElse(List.empty)
  lazy val responsibilityRaw: List[NoticeResponsibilityDetailModel] = responsibility.getOrElse(List.empty)
  lazy val rootCauseRaw: List[NoticeRootCauseDetailModel] = rootCause.getOrElse(List.empty)
  def withId(value: Int): NoticeModel = copy(id = value)
  def withCompanyId(value: Int): NoticeModel = copy(companyId = value)
  def withStatusId(value: Int): NoticeModel = copy(statusId = value)
  def withStatus(value: String): NoticeModel = copy(status = Some(value))
  def withReceivedDate(value: Date): NoticeModel = copy(receivedDate = value)
  def withClosedDate(value: Date): NoticeModel = copy(closedDate = Some(value))
  def withTotalRemit(value: BigDecimal): NoticeModel = copy(totalRemit = Some(value))
  def withCustomerTypeId(value: NoticeCustomerType): NoticeModel = copy(customerTypeId = value)
  def withCountry(value: String): NoticeModel = copy(country = Some(value))
  def withRegion(value: String): NoticeModel = copy(region = Some(value))
  def withTaxAuthorityId(value: Int): NoticeModel = copy(taxAuthorityId = Some(value))
  def withFilingFrequency(value: FilingFrequencyId): NoticeModel = copy(filingFrequency = Some(value))
  def withFilingTypeId(value: TaxNoticeFilingTypeId): NoticeModel = copy(filingTypeId = Some(value))
  def withTicketReferenceNo(value: String): NoticeModel = copy(ticketReferenceNo = Some(value))
  def withTicketReferenceUrl(value: String): NoticeModel = copy(ticketReferenceUrl = Some(value))
  def withSalesForceCase(value: String): NoticeModel = copy(salesForceCase = Some(value))
  def withSalesForceCaseUrl(value: String): NoticeModel = copy(salesForceCaseUrl = Some(value))
  def withTaxPeriod(value: String): NoticeModel = copy(taxPeriod = Some(value))
  def withReasonId(value: Int): NoticeModel = copy(reasonId = value)
  def withReason(value: String): NoticeModel = copy(reason = Some(value))
  def withTypeId(value: Int): NoticeModel = copy(typeId = Some(value))
  def withType(value: String): NoticeModel = copy(`type` = Some(value))
  def withCustomerFundingOptionId(value: FundingOption): NoticeModel = copy(customerFundingOptionId = Some(value))
  def withPriorityId(value: NoticePriorityId): NoticeModel = copy(priorityId = value)
  def withCustomerComment(value: String): NoticeModel = copy(customerComment = Some(value))
  def withHideFromCustomer(value: Boolean): NoticeModel = copy(hideFromCustomer = value)
  def withExpectedResolutionDate(value: Date): NoticeModel = copy(expectedResolutionDate = Some(value))
  def withShowResolutionDateToCustomer(value: Boolean): NoticeModel = copy(showResolutionDateToCustomer = value)
  def withClosedByUserId(value: Int): NoticeModel = copy(closedByUserId = Some(value))
  def withCreatedByUserName(value: String): NoticeModel = copy(createdByUserName = Some(value))
  def withOwnedByUserId(value: Int): NoticeModel = copy(ownedByUserId = Some(value))
  def withDescription(value: String): NoticeModel = copy(description = Some(value))
  def withAvaFileFormId(value: Int): NoticeModel = copy(avaFileFormId = Some(value))
  def withRevenueContactId(value: Int): NoticeModel = copy(revenueContactId = Some(value))
  def withComplianceContactId(value: Int): NoticeModel = copy(complianceContactId = Some(value))
  def withTaxFormCode(value: String): NoticeModel = copy(taxFormCode = Some(value))
  def withDocumentReference(value: String): NoticeModel = copy(documentReference = Some(value))
  def withJurisdictionName(value: String): NoticeModel = copy(jurisdictionName = Some(value))
  def withJurisdictionType(value: String): NoticeModel = copy(jurisdictionType = Some(value))
  def withComments(value: List[NoticeCommentModel]): NoticeModel = copy(comments = Some(value))
  def withFinances(value: List[NoticeFinanceModel]): NoticeModel = copy(finances = Some(value))
  def withResponsibility(value: List[NoticeResponsibilityDetailModel]): NoticeModel = copy(responsibility = Some(value))
  def withRootCause(value: List[NoticeRootCauseDetailModel]): NoticeModel = copy(rootCause = Some(value))
  def withCreatedDate(value: Date): NoticeModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): NoticeModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): NoticeModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): NoticeModel = copy(modifiedUserId = Some(value))
}
