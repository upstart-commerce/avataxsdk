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

final case class FilingReturnModel(
    id: Option[Long] = None,
    filingRegionId: Option[Long] = None,
    filingCalendarId: Option[Long] = None,
    resourceFileId: Option[Long] = None,
    taxAuthorityId: Option[Int] = None,
    status: Option[FilingStatusId] = None,
    filingFrequency: Option[FilingFrequencyId] = None,
    filedDate: Option[Date] = None,
    startPeriod: Option[Date] = None,
    endPeriod: Option[Date] = None,
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
    consumerUseTaxDueAmount: Option[BigDecimal] = None,
    consumerUseNonTaxableAmount: Option[BigDecimal] = None,
    consumerUseTaxableAmount: Option[BigDecimal] = None,
    totalAdjustments: Option[BigDecimal] = None,
    excludedSalesAmount: Option[BigDecimal] = None,
    excludedNonTaxableAmount: Option[BigDecimal] = None,
    excludedTaxAmount: Option[BigDecimal] = None,
    carryOverSalesAmount: Option[BigDecimal] = None,
    carryOverNonTaxableAmount: Option[BigDecimal] = None,
    carryOverTaxAmount: Option[BigDecimal] = None,
    carryOverConsumerUseTaxAmount: Option[BigDecimal] = None,
    taxAccrualAmount: Option[BigDecimal] = None,
    salesAccrualAmount: Option[BigDecimal] = None,
    nonTaxableAccrualAmount: Option[BigDecimal] = None,
    taxableAccrualAmount: Option[BigDecimal] = None,
    salesTaxAccrualAmount: Option[BigDecimal] = None,
    sellersUseTaxAccrualAmount: Option[BigDecimal] = None,
    consumerUseTaxAccrualAmount: Option[BigDecimal] = None,
    consumerUseTaxableAccrualAmount: Option[BigDecimal] = None,
    consumerUseNonTaxableAccrualAmount: Option[BigDecimal] = None,
    adjustments: Option[List[FilingAdjustmentModel]] = None,
    totalAugmentations: Option[BigDecimal] = None,
    augmentations: Option[List[FilingAugmentationModel]] = None,
    totalPayments: Option[BigDecimal] = None,
    payments: Option[List[FilingPaymentModel]] = None,
    accrualType: Option[AccrualType] = None,
    month: Option[Int] = None,
    year: Option[Int] = None,
    attachments: Option[List[FilingAttachmentModel]] = None,
    excludedCarryOverCredits: Option[FilingReturnCreditModel] = None,
    appliedCarryOverCredits: Option[FilingReturnCreditModel] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None
) {
  lazy val adjustmentsRaw: List[FilingAdjustmentModel] = adjustments.getOrElse(List.empty)
  lazy val augmentationsRaw: List[FilingAugmentationModel] = augmentations.getOrElse(List.empty)
  lazy val paymentsRaw: List[FilingPaymentModel] = payments.getOrElse(List.empty)
  lazy val attachmentsRaw: List[FilingAttachmentModel] = attachments.getOrElse(List.empty)
  def withId(value: Long): FilingReturnModel = copy(id = Some(value))
  def withFilingRegionId(value: Long): FilingReturnModel = copy(filingRegionId = Some(value))
  def withFilingCalendarId(value: Long): FilingReturnModel = copy(filingCalendarId = Some(value))
  def withResourceFileId(value: Long): FilingReturnModel = copy(resourceFileId = Some(value))
  def withTaxAuthorityId(value: Int): FilingReturnModel = copy(taxAuthorityId = Some(value))
  def withStatus(value: FilingStatusId): FilingReturnModel = copy(status = Some(value))
  def withFilingFrequency(value: FilingFrequencyId): FilingReturnModel = copy(filingFrequency = Some(value))
  def withFiledDate(value: Date): FilingReturnModel = copy(filedDate = Some(value))
  def withStartPeriod(value: Date): FilingReturnModel = copy(startPeriod = Some(value))
  def withEndPeriod(value: Date): FilingReturnModel = copy(endPeriod = Some(value))
  def withSalesAmount(value: BigDecimal): FilingReturnModel = copy(salesAmount = Some(value))
  def withFilingType(value: FilingTypeId): FilingReturnModel = copy(filingType = Some(value))
  def withFormName(value: String): FilingReturnModel = copy(formName = Some(value))
  def withRemitAmount(value: BigDecimal): FilingReturnModel = copy(remitAmount = Some(value))
  def withFormCode(value: String): FilingReturnModel = copy(formCode = Some(value))
  def withDescription(value: String): FilingReturnModel = copy(description = Some(value))
  def withTaxableAmount(value: BigDecimal): FilingReturnModel = copy(taxableAmount = Some(value))
  def withTaxAmount(value: BigDecimal): FilingReturnModel = copy(taxAmount = Some(value))
  def withCollectAmount(value: BigDecimal): FilingReturnModel = copy(collectAmount = Some(value))
  def withTaxDueAmount(value: BigDecimal): FilingReturnModel = copy(taxDueAmount = Some(value))
  def withNonTaxableAmount(value: BigDecimal): FilingReturnModel = copy(nonTaxableAmount = Some(value))
  def withNonTaxableDueAmount(value: BigDecimal): FilingReturnModel = copy(nonTaxableDueAmount = Some(value))
  def withConsumerUseTaxAmount(value: BigDecimal): FilingReturnModel = copy(consumerUseTaxAmount = Some(value))
  def withConsumerUseTaxDueAmount(value: BigDecimal): FilingReturnModel = copy(consumerUseTaxDueAmount = Some(value))
  def withConsumerUseNonTaxableAmount(value: BigDecimal): FilingReturnModel = copy(consumerUseNonTaxableAmount = Some(value))
  def withConsumerUseTaxableAmount(value: BigDecimal): FilingReturnModel = copy(consumerUseTaxableAmount = Some(value))
  def withTotalAdjustments(value: BigDecimal): FilingReturnModel = copy(totalAdjustments = Some(value))
  def withExcludedSalesAmount(value: BigDecimal): FilingReturnModel = copy(excludedSalesAmount = Some(value))
  def withExcludedNonTaxableAmount(value: BigDecimal): FilingReturnModel = copy(excludedNonTaxableAmount = Some(value))
  def withExcludedTaxAmount(value: BigDecimal): FilingReturnModel = copy(excludedTaxAmount = Some(value))
  def withCarryOverSalesAmount(value: BigDecimal): FilingReturnModel = copy(carryOverSalesAmount = Some(value))
  def withCarryOverNonTaxableAmount(value: BigDecimal): FilingReturnModel = copy(carryOverNonTaxableAmount = Some(value))
  def withCarryOverTaxAmount(value: BigDecimal): FilingReturnModel = copy(carryOverTaxAmount = Some(value))
  def withCarryOverConsumerUseTaxAmount(value: BigDecimal): FilingReturnModel = copy(carryOverConsumerUseTaxAmount = Some(value))
  def withTaxAccrualAmount(value: BigDecimal): FilingReturnModel = copy(taxAccrualAmount = Some(value))
  def withSalesAccrualAmount(value: BigDecimal): FilingReturnModel = copy(salesAccrualAmount = Some(value))
  def withNonTaxableAccrualAmount(value: BigDecimal): FilingReturnModel = copy(nonTaxableAccrualAmount = Some(value))
  def withTaxableAccrualAmount(value: BigDecimal): FilingReturnModel = copy(taxableAccrualAmount = Some(value))
  def withSalesTaxAccrualAmount(value: BigDecimal): FilingReturnModel = copy(salesTaxAccrualAmount = Some(value))
  def withSellersUseTaxAccrualAmount(value: BigDecimal): FilingReturnModel = copy(sellersUseTaxAccrualAmount = Some(value))
  def withConsumerUseTaxAccrualAmount(value: BigDecimal): FilingReturnModel = copy(consumerUseTaxAccrualAmount = Some(value))
  def withConsumerUseTaxableAccrualAmount(value: BigDecimal): FilingReturnModel = copy(consumerUseTaxableAccrualAmount = Some(value))
  def withConsumerUseNonTaxableAccrualAmount(value: BigDecimal): FilingReturnModel = copy(consumerUseNonTaxableAccrualAmount = Some(value))
  def withAdjustments(value: List[FilingAdjustmentModel]): FilingReturnModel = copy(adjustments = Some(value))
  def withTotalAugmentations(value: BigDecimal): FilingReturnModel = copy(totalAugmentations = Some(value))
  def withAugmentations(value: List[FilingAugmentationModel]): FilingReturnModel = copy(augmentations = Some(value))
  def withTotalPayments(value: BigDecimal): FilingReturnModel = copy(totalPayments = Some(value))
  def withPayments(value: List[FilingPaymentModel]): FilingReturnModel = copy(payments = Some(value))
  def withAccrualType(value: AccrualType): FilingReturnModel = copy(accrualType = Some(value))
  def withMonth(value: Int): FilingReturnModel = copy(month = Some(value))
  def withYear(value: Int): FilingReturnModel = copy(year = Some(value))
  def withAttachments(value: List[FilingAttachmentModel]): FilingReturnModel = copy(attachments = Some(value))
  def withExcludedCarryOverCredits(value: FilingReturnCreditModel): FilingReturnModel = copy(excludedCarryOverCredits = Some(value))
  def withAppliedCarryOverCredits(value: FilingReturnCreditModel): FilingReturnModel = copy(appliedCarryOverCredits = Some(value))
  def withCreatedDate(value: Date): FilingReturnModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): FilingReturnModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): FilingReturnModel = copy(modifiedDate = Some(value))
}
