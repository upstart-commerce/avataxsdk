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

final case class FilingReturnModelBasic(
    companyId: Option[Long] = None,
    id: Option[Long] = None,
    filingId: Option[Long] = None,
    resourceFileId: Option[Long] = None,
    filingRegionId: Option[Long] = None,
    filingCalendarId: Option[Long] = None,
    country: Option[String] = None,
    region: Option[String] = None,
    endPeriodMonth: Option[Int] = None,
    endPeriodYear: Option[Short] = None,
    status: Option[FilingStatusId] = None,
    filingFrequency: Option[FilingFrequencyId] = None,
    filedDate: Option[Date] = None,
    salesAmount: Option[BigDecimal] = None,
    filingType: Option[FilingTypeId] = None,
    formName: Option[String] = None,
    remitAmount: Option[BigDecimal] = None,
    formCode: Option[String] = None,
    description: Option[String] = None,
    taxableAmount: Option[BigDecimal] = None,
    taxAmount: Option[BigDecimal] = None,
    collectAmount: Option[BigDecimal] = None,
    taxDueAmount: Option[BigDecimal] = None,
    nonTaxableAmount: Option[BigDecimal] = None,
    nonTaxableDueAmount: Option[BigDecimal] = None,
    consumerUseTaxAmount: Option[BigDecimal] = None,
    consumerUseNonTaxableAmount: Option[BigDecimal] = None,
    consumerUseTaxableAmount: Option[BigDecimal] = None,
    excludedSalesAmount: Option[BigDecimal] = None,
    excludedNonTaxableAmount: Option[BigDecimal] = None,
    excludedTaxAmount: Option[BigDecimal] = None,
    accrualType: Option[AccrualType] = None,
    attachments: Option[List[FilingAttachmentModel]] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None
) {
  lazy val attachmentsRaw: List[FilingAttachmentModel] = attachments.getOrElse(List.empty)
  def withCompanyId(value: Long): FilingReturnModelBasic = copy(companyId = Some(value))
  def withId(value: Long): FilingReturnModelBasic = copy(id = Some(value))
  def withFilingId(value: Long): FilingReturnModelBasic = copy(filingId = Some(value))
  def withResourceFileId(value: Long): FilingReturnModelBasic = copy(resourceFileId = Some(value))
  def withFilingRegionId(value: Long): FilingReturnModelBasic = copy(filingRegionId = Some(value))
  def withFilingCalendarId(value: Long): FilingReturnModelBasic = copy(filingCalendarId = Some(value))
  def withCountry(value: String): FilingReturnModelBasic = copy(country = Some(value))
  def withRegion(value: String): FilingReturnModelBasic = copy(region = Some(value))
  def withEndPeriodMonth(value: Int): FilingReturnModelBasic = copy(endPeriodMonth = Some(value))
  def withEndPeriodYear(value: Short): FilingReturnModelBasic = copy(endPeriodYear = Some(value))
  def withStatus(value: FilingStatusId): FilingReturnModelBasic = copy(status = Some(value))
  def withFilingFrequency(value: FilingFrequencyId): FilingReturnModelBasic = copy(filingFrequency = Some(value))
  def withFiledDate(value: Date): FilingReturnModelBasic = copy(filedDate = Some(value))
  def withSalesAmount(value: BigDecimal): FilingReturnModelBasic = copy(salesAmount = Some(value))
  def withFilingType(value: FilingTypeId): FilingReturnModelBasic = copy(filingType = Some(value))
  def withFormName(value: String): FilingReturnModelBasic = copy(formName = Some(value))
  def withRemitAmount(value: BigDecimal): FilingReturnModelBasic = copy(remitAmount = Some(value))
  def withFormCode(value: String): FilingReturnModelBasic = copy(formCode = Some(value))
  def withDescription(value: String): FilingReturnModelBasic = copy(description = Some(value))
  def withTaxableAmount(value: BigDecimal): FilingReturnModelBasic = copy(taxableAmount = Some(value))
  def withTaxAmount(value: BigDecimal): FilingReturnModelBasic = copy(taxAmount = Some(value))
  def withCollectAmount(value: BigDecimal): FilingReturnModelBasic = copy(collectAmount = Some(value))
  def withTaxDueAmount(value: BigDecimal): FilingReturnModelBasic = copy(taxDueAmount = Some(value))
  def withNonTaxableAmount(value: BigDecimal): FilingReturnModelBasic = copy(nonTaxableAmount = Some(value))
  def withNonTaxableDueAmount(value: BigDecimal): FilingReturnModelBasic = copy(nonTaxableDueAmount = Some(value))
  def withConsumerUseTaxAmount(value: BigDecimal): FilingReturnModelBasic = copy(consumerUseTaxAmount = Some(value))
  def withConsumerUseNonTaxableAmount(value: BigDecimal): FilingReturnModelBasic = copy(consumerUseNonTaxableAmount = Some(value))
  def withConsumerUseTaxableAmount(value: BigDecimal): FilingReturnModelBasic = copy(consumerUseTaxableAmount = Some(value))
  def withExcludedSalesAmount(value: BigDecimal): FilingReturnModelBasic = copy(excludedSalesAmount = Some(value))
  def withExcludedNonTaxableAmount(value: BigDecimal): FilingReturnModelBasic = copy(excludedNonTaxableAmount = Some(value))
  def withExcludedTaxAmount(value: BigDecimal): FilingReturnModelBasic = copy(excludedTaxAmount = Some(value))
  def withAccrualType(value: AccrualType): FilingReturnModelBasic = copy(accrualType = Some(value))
  def withAttachments(value: List[FilingAttachmentModel]): FilingReturnModelBasic = copy(attachments = Some(value))
  def withCreatedDate(value: Date): FilingReturnModelBasic = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): FilingReturnModelBasic = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): FilingReturnModelBasic = copy(modifiedDate = Some(value))
}
