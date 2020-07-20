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

final case class FormMasterModel(
    id: Option[Int] = None,
    formTypeId: Option[Int] = None,
    taxFormCode: Option[String] = None,
    legacyReturnName: Option[String] = None,
    taxFormName: Option[String] = None,
    description: Option[String] = None,
    isEffective: Option[Boolean] = None,
    country: Option[String] = None,
    region: Option[String] = None,
    authorityName: Option[String] = None,
    shortCode: Option[String] = None,
    dueDay: Option[Int] = None,
    delinquentDay: Option[Int] = None,
    fiscalYearStartMonth: Option[Int] = None,
    hasMultiFrequencies: Option[Boolean] = None,
    isPOARequired: Option[Boolean] = None,
    isRegistrationRequired: Option[Boolean] = None,
    hasMultiRegistrationMethods: Option[Boolean] = None,
    hasSchedules: Option[Boolean] = None,
    hasMultiFilingMethods: Option[Boolean] = None,
    hasMultiPayMethods: Option[Boolean] = None,
    isEFTRequired: Option[Boolean] = None,
    isFilePayMethodLinked: Option[Boolean] = None,
    mailingReceivedRuleId: Option[Int] = None,
    proofOfMailingId: Option[Int] = None,
    isNegAmountAllowed: Option[Boolean] = None,
    allowNegativeOverallTax: Option[Boolean] = None,
    isNettingRequired: Option[Boolean] = None,
    roundingMethodId: Option[Int] = None,
    vendorDiscountAnnualMax: Option[BigDecimal] = None,
    versionsRequireAuthorityApproval: Option[Boolean] = None,
    outletReportingMethodId: Option[Int] = None,
    hasReportingCodes: Option[Boolean] = None,
    hasPrepayments: Option[Boolean] = None,
    grossIncludesInterstateSales: Option[Boolean] = None,
    grossIncludesTax: Option[String] = None,
    hasEfileFee: Option[Boolean] = None,
    hasEpayFee: Option[Boolean] = None,
    hasDependencies: Option[Boolean] = None,
    requiredEfileTrigger: Option[String] = None,
    requiredEftTrigger: Option[String] = None,
    vendorDiscountEfile: Option[Boolean] = None,
    vendorDiscountPaper: Option[Boolean] = None,
    peerReviewed: Option[String] = None,
    peerReviewedId: Option[String] = None,
    peerReviewedDate: Option[String] = None,
    createdUserId: Option[Int] = None,
    createdDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    dorAddressMailTo: Option[String] = None,
    dorAddress1: Option[String] = None,
    dorAddress2: Option[String] = None,
    dorAddressCity: Option[String] = None,
    dorAddressRegion: Option[String] = None,
    dorAddressPostalCode: Option[String] = None,
    dorAddressCountry: Option[String] = None,
    zeroAddressMailTo: Option[String] = None,
    zeroAddress1: Option[String] = None,
    zeroAddress2: Option[String] = None,
    zeroAddressCity: Option[String] = None,
    zeroAddressRegion: Option[String] = None,
    zeroAddressPostalCode: Option[String] = None,
    zeroAddressCountry: Option[String] = None,
    amendedAddressMailTo: Option[String] = None,
    amendedAddress1: Option[String] = None,
    amendedAddress2: Option[String] = None,
    amendedAddressCity: Option[String] = None,
    amendedAddressRegion: Option[String] = None,
    amendedAddressPostalCode: Option[String] = None,
    amendedAddressCountry: Option[String] = None,
    onlineBackFiling: Option[Boolean] = None,
    onlineAmendedReturns: Option[Boolean] = None,
    prepaymentFrequency: Option[String] = None,
    outletLocationIdentifiersRequired: Option[Boolean] = None,
    listingSortOrder: Option[String] = None,
    dorWebsite: Option[String] = None,
    fileForAllOutlets: Option[Boolean] = None,
    paperFormsDoNotHaveDiscounts: Option[Boolean] = None,
    stackAggregation: Option[Boolean] = None,
    roundingPrecision: Option[String] = None,
    inconsistencyTolerance: Option[String] = None,
    effDate: Option[Date] = None,
    endDate: Option[Date] = None,
    visibleToCustomers: Option[Boolean] = None,
    requiresOutletSetup: Option[Boolean] = None,
    achCreditAllowed: Option[Boolean] = None,
    reportLevel: Option[String] = None,
    postOfficeValidated: Option[Boolean] = None,
    stackAggregationOption: Option[String] = None,
    sstBehavior: Option[String] = None,
    nonSstBehavior: Option[String] = None,
    dorPhoneNumber: Option[String] = None,
    averageCheckClearDays: Option[String] = None,
    filterZeroRatedLineDetails: Option[Boolean] = None,
    allowsBulkFilingAccounts: Option[Boolean] = None,
    bulkAccountInstructionLink: Option[String] = None,
    registrationIdFormat: Option[String] = None,
    thresholdTrigger: Option[String] = None,
    transactionSortingOption: Option[String] = None,
    contentReviewFrequencyId: Option[Int] = None,
    aliasForFormMasterId: Option[String] = None
) {

  def withId(value: Int): FormMasterModel = copy(id = Some(value))
  def withFormTypeId(value: Int): FormMasterModel = copy(formTypeId = Some(value))
  def withTaxFormCode(value: String): FormMasterModel = copy(taxFormCode = Some(value))
  def withLegacyReturnName(value: String): FormMasterModel = copy(legacyReturnName = Some(value))
  def withTaxFormName(value: String): FormMasterModel = copy(taxFormName = Some(value))
  def withDescription(value: String): FormMasterModel = copy(description = Some(value))
  def withIsEffective(value: Boolean): FormMasterModel = copy(isEffective = Some(value))
  def withCountry(value: String): FormMasterModel = copy(country = Some(value))
  def withRegion(value: String): FormMasterModel = copy(region = Some(value))
  def withAuthorityName(value: String): FormMasterModel = copy(authorityName = Some(value))
  def withShortCode(value: String): FormMasterModel = copy(shortCode = Some(value))
  def withDueDay(value: Int): FormMasterModel = copy(dueDay = Some(value))
  def withDelinquentDay(value: Int): FormMasterModel = copy(delinquentDay = Some(value))
  def withFiscalYearStartMonth(value: Int): FormMasterModel = copy(fiscalYearStartMonth = Some(value))
  def withHasMultiFrequencies(value: Boolean): FormMasterModel = copy(hasMultiFrequencies = Some(value))
  def withIsPOARequired(value: Boolean): FormMasterModel = copy(isPOARequired = Some(value))
  def withIsRegistrationRequired(value: Boolean): FormMasterModel = copy(isRegistrationRequired = Some(value))
  def withHasMultiRegistrationMethods(value: Boolean): FormMasterModel = copy(hasMultiRegistrationMethods = Some(value))
  def withHasSchedules(value: Boolean): FormMasterModel = copy(hasSchedules = Some(value))
  def withHasMultiFilingMethods(value: Boolean): FormMasterModel = copy(hasMultiFilingMethods = Some(value))
  def withHasMultiPayMethods(value: Boolean): FormMasterModel = copy(hasMultiPayMethods = Some(value))
  def withIsEFTRequired(value: Boolean): FormMasterModel = copy(isEFTRequired = Some(value))
  def withIsFilePayMethodLinked(value: Boolean): FormMasterModel = copy(isFilePayMethodLinked = Some(value))
  def withMailingReceivedRuleId(value: Int): FormMasterModel = copy(mailingReceivedRuleId = Some(value))
  def withProofOfMailingId(value: Int): FormMasterModel = copy(proofOfMailingId = Some(value))
  def withIsNegAmountAllowed(value: Boolean): FormMasterModel = copy(isNegAmountAllowed = Some(value))
  def withAllowNegativeOverallTax(value: Boolean): FormMasterModel = copy(allowNegativeOverallTax = Some(value))
  def withIsNettingRequired(value: Boolean): FormMasterModel = copy(isNettingRequired = Some(value))
  def withRoundingMethodId(value: Int): FormMasterModel = copy(roundingMethodId = Some(value))
  def withVendorDiscountAnnualMax(value: BigDecimal): FormMasterModel = copy(vendorDiscountAnnualMax = Some(value))
  def withVersionsRequireAuthorityApproval(value: Boolean): FormMasterModel = copy(versionsRequireAuthorityApproval = Some(value))
  def withOutletReportingMethodId(value: Int): FormMasterModel = copy(outletReportingMethodId = Some(value))
  def withHasReportingCodes(value: Boolean): FormMasterModel = copy(hasReportingCodes = Some(value))
  def withHasPrepayments(value: Boolean): FormMasterModel = copy(hasPrepayments = Some(value))
  def withGrossIncludesInterstateSales(value: Boolean): FormMasterModel = copy(grossIncludesInterstateSales = Some(value))
  def withGrossIncludesTax(value: String): FormMasterModel = copy(grossIncludesTax = Some(value))
  def withHasEfileFee(value: Boolean): FormMasterModel = copy(hasEfileFee = Some(value))
  def withHasEpayFee(value: Boolean): FormMasterModel = copy(hasEpayFee = Some(value))
  def withHasDependencies(value: Boolean): FormMasterModel = copy(hasDependencies = Some(value))
  def withRequiredEfileTrigger(value: String): FormMasterModel = copy(requiredEfileTrigger = Some(value))
  def withRequiredEftTrigger(value: String): FormMasterModel = copy(requiredEftTrigger = Some(value))
  def withVendorDiscountEfile(value: Boolean): FormMasterModel = copy(vendorDiscountEfile = Some(value))
  def withVendorDiscountPaper(value: Boolean): FormMasterModel = copy(vendorDiscountPaper = Some(value))
  def withPeerReviewed(value: String): FormMasterModel = copy(peerReviewed = Some(value))
  def withPeerReviewedId(value: String): FormMasterModel = copy(peerReviewedId = Some(value))
  def withPeerReviewedDate(value: String): FormMasterModel = copy(peerReviewedDate = Some(value))
  def withCreatedUserId(value: Int): FormMasterModel = copy(createdUserId = Some(value))
  def withCreatedDate(value: Date): FormMasterModel = copy(createdDate = Some(value))
  def withModifiedUserId(value: Int): FormMasterModel = copy(modifiedUserId = Some(value))
  def withModifiedDate(value: Date): FormMasterModel = copy(modifiedDate = Some(value))
  def withDorAddressMailTo(value: String): FormMasterModel = copy(dorAddressMailTo = Some(value))
  def withDorAddress1(value: String): FormMasterModel = copy(dorAddress1 = Some(value))
  def withDorAddress2(value: String): FormMasterModel = copy(dorAddress2 = Some(value))
  def withDorAddressCity(value: String): FormMasterModel = copy(dorAddressCity = Some(value))
  def withDorAddressRegion(value: String): FormMasterModel = copy(dorAddressRegion = Some(value))
  def withDorAddressPostalCode(value: String): FormMasterModel = copy(dorAddressPostalCode = Some(value))
  def withDorAddressCountry(value: String): FormMasterModel = copy(dorAddressCountry = Some(value))
  def withZeroAddressMailTo(value: String): FormMasterModel = copy(zeroAddressMailTo = Some(value))
  def withZeroAddress1(value: String): FormMasterModel = copy(zeroAddress1 = Some(value))
  def withZeroAddress2(value: String): FormMasterModel = copy(zeroAddress2 = Some(value))
  def withZeroAddressCity(value: String): FormMasterModel = copy(zeroAddressCity = Some(value))
  def withZeroAddressRegion(value: String): FormMasterModel = copy(zeroAddressRegion = Some(value))
  def withZeroAddressPostalCode(value: String): FormMasterModel = copy(zeroAddressPostalCode = Some(value))
  def withZeroAddressCountry(value: String): FormMasterModel = copy(zeroAddressCountry = Some(value))
  def withAmendedAddressMailTo(value: String): FormMasterModel = copy(amendedAddressMailTo = Some(value))
  def withAmendedAddress1(value: String): FormMasterModel = copy(amendedAddress1 = Some(value))
  def withAmendedAddress2(value: String): FormMasterModel = copy(amendedAddress2 = Some(value))
  def withAmendedAddressCity(value: String): FormMasterModel = copy(amendedAddressCity = Some(value))
  def withAmendedAddressRegion(value: String): FormMasterModel = copy(amendedAddressRegion = Some(value))
  def withAmendedAddressPostalCode(value: String): FormMasterModel = copy(amendedAddressPostalCode = Some(value))
  def withAmendedAddressCountry(value: String): FormMasterModel = copy(amendedAddressCountry = Some(value))
  def withOnlineBackFiling(value: Boolean): FormMasterModel = copy(onlineBackFiling = Some(value))
  def withOnlineAmendedReturns(value: Boolean): FormMasterModel = copy(onlineAmendedReturns = Some(value))
  def withPrepaymentFrequency(value: String): FormMasterModel = copy(prepaymentFrequency = Some(value))
  def withOutletLocationIdentifiersRequired(value: Boolean): FormMasterModel = copy(outletLocationIdentifiersRequired = Some(value))
  def withListingSortOrder(value: String): FormMasterModel = copy(listingSortOrder = Some(value))
  def withDorWebsite(value: String): FormMasterModel = copy(dorWebsite = Some(value))
  def withFileForAllOutlets(value: Boolean): FormMasterModel = copy(fileForAllOutlets = Some(value))
  def withPaperFormsDoNotHaveDiscounts(value: Boolean): FormMasterModel = copy(paperFormsDoNotHaveDiscounts = Some(value))
  def withStackAggregation(value: Boolean): FormMasterModel = copy(stackAggregation = Some(value))
  def withRoundingPrecision(value: String): FormMasterModel = copy(roundingPrecision = Some(value))
  def withInconsistencyTolerance(value: String): FormMasterModel = copy(inconsistencyTolerance = Some(value))
  def withEffDate(value: Date): FormMasterModel = copy(effDate = Some(value))
  def withEndDate(value: Date): FormMasterModel = copy(endDate = Some(value))
  def withVisibleToCustomers(value: Boolean): FormMasterModel = copy(visibleToCustomers = Some(value))
  def withRequiresOutletSetup(value: Boolean): FormMasterModel = copy(requiresOutletSetup = Some(value))
  def withAchCreditAllowed(value: Boolean): FormMasterModel = copy(achCreditAllowed = Some(value))
  def withReportLevel(value: String): FormMasterModel = copy(reportLevel = Some(value))
  def withPostOfficeValidated(value: Boolean): FormMasterModel = copy(postOfficeValidated = Some(value))
  def withStackAggregationOption(value: String): FormMasterModel = copy(stackAggregationOption = Some(value))
  def withSstBehavior(value: String): FormMasterModel = copy(sstBehavior = Some(value))
  def withNonSstBehavior(value: String): FormMasterModel = copy(nonSstBehavior = Some(value))
  def withDorPhoneNumber(value: String): FormMasterModel = copy(dorPhoneNumber = Some(value))
  def withAverageCheckClearDays(value: String): FormMasterModel = copy(averageCheckClearDays = Some(value))
  def withFilterZeroRatedLineDetails(value: Boolean): FormMasterModel = copy(filterZeroRatedLineDetails = Some(value))
  def withAllowsBulkFilingAccounts(value: Boolean): FormMasterModel = copy(allowsBulkFilingAccounts = Some(value))
  def withBulkAccountInstructionLink(value: String): FormMasterModel = copy(bulkAccountInstructionLink = Some(value))
  def withRegistrationIdFormat(value: String): FormMasterModel = copy(registrationIdFormat = Some(value))
  def withThresholdTrigger(value: String): FormMasterModel = copy(thresholdTrigger = Some(value))
  def withTransactionSortingOption(value: String): FormMasterModel = copy(transactionSortingOption = Some(value))
  def withContentReviewFrequencyId(value: Int): FormMasterModel = copy(contentReviewFrequencyId = Some(value))
  def withAliasForFormMasterId(value: String): FormMasterModel = copy(aliasForFormMasterId = Some(value))
}
