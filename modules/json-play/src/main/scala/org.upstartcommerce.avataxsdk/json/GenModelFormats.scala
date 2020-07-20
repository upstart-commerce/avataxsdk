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

package org.upstartcommerce.avataxsdk.json

import org.upstartcommerce.avataxsdk.core.data.models._
import play.api.libs.json._

/** formats that are generated, defs for jvm class size limit - play macros generate lots of code */
private[json] trait GenModelFormats {
  implicit def multiCompanyLineItemModelOFormat: OFormat[MultiCompanyLineItemModel] =
    Json.format[MultiCompanyLineItemModel]
  implicit def coverLetterModelOFormat: OFormat[CoverLetterModel] = Json.format[CoverLetterModel]
  implicit def itemClassificationOutputModelOFormat: OFormat[ItemClassificationOutputModel] =
    Json.format[ItemClassificationOutputModel]
  implicit def validatedAddressInfoOFormat: OFormat[ValidatedAddressInfo] =
    Json.format[ValidatedAddressInfo]
  implicit def certExpressInvitationStatusModelOFormat: OFormat[CertExpressInvitationStatusModel] =
    Json.format[CertExpressInvitationStatusModel]
  implicit def certificateAttributeModelOFormat: OFormat[CertificateAttributeModel] =
    Json.format[CertificateAttributeModel]
  implicit def jurisdictionOverrideModelOFormat: OFormat[JurisdictionOverrideModel] =
    Json.format[JurisdictionOverrideModel]
  implicit def filingModelOFormat: OFormat[FilingModel] = Json.format[FilingModel]
  implicit def offerModelOFormat: OFormat[OfferModel] = Json.format[OfferModel]
  implicit def createOrAdjustTransactionModelOFormat: OFormat[CreateOrAdjustTransactionModel] =
    Json.format[CreateOrAdjustTransactionModel]
  implicit def certificateModelOFormat: OFormat[CertificateModel] = Json.format[CertificateModel]
  implicit def loginVerificationInputModelOFormat: OFormat[LoginVerificationInputModel] =
    Json.format[LoginVerificationInputModel]
  implicit def taxCodeTypesModelOFormat: OFormat[TaxCodeTypesModel] =
    Json.format[TaxCodeTypesModel]
  implicit def filingAugmentationModelOFormat: OFormat[FilingAugmentationModel] =
    Json.format[FilingAugmentationModel]
  implicit def rebuildFilingsModelOFormat: OFormat[RebuildFilingsModel] =
    Json.format[RebuildFilingsModel]
  implicit def transactionLocationTypeModelOFormat: OFormat[TransactionLocationTypeModel] =
    Json.format[TransactionLocationTypeModel]
  implicit def advancedRuleScriptModelOFormat: OFormat[AdvancedRuleScriptModel] =
    Json.format[AdvancedRuleScriptModel]
  implicit def adjustMultiDocumentModelOFormat: OFormat[AdjustMultiDocumentModel] =
    Json.format[AdjustMultiDocumentModel]
  implicit def lockTransactionModelOFormat: OFormat[LockTransactionModel] =
    Json.format[LockTransactionModel]
  implicit def voidTransactionModelOFormat: OFormat[VoidTransactionModel] =
    Json.format[VoidTransactionModel]
  implicit def nexusTaxTypeGroupCountModelOFormat: OFormat[NexusTaxTypeGroupCountModel] =
    Json.format[NexusTaxTypeGroupCountModel]
  implicit def filingAttachmentModelOFormat: OFormat[FilingAttachmentModel] =
    Json.format[FilingAttachmentModel]
  implicit def exposureZoneModelOFormat: OFormat[ExposureZoneModel] =
    Json.format[ExposureZoneModel]
  implicit def worksheetDocumentLineOFormat: OFormat[WorksheetDocumentLine] =
    Json.format[WorksheetDocumentLine]
  implicit def parameterModelOFormat: OFormat[ParameterModel] = Json.format[ParameterModel]
  implicit def productSystemCountryModelOFormat: OFormat[ProductSystemCountryModel] =
    Json.format[ProductSystemCountryModel]
  implicit def newAccountModelOFormat: OFormat[NewAccountModel] = Json.format[NewAccountModel]
  implicit def taxSubTypeModelOFormat: OFormat[TaxSubTypeModel] = Json.format[TaxSubTypeModel]
  implicit def reportParametersModelOFormat: OFormat[ReportParametersModel] =
    Json.format[ReportParametersModel]
  implicit def companyConfigurationModelOFormat: OFormat[CompanyConfigurationModel] =
    Json.format[CompanyConfigurationModel]
  implicit def classificationModelOFormat: OFormat[ClassificationModel] =
    Json.format[ClassificationModel]
  implicit def cycleExpireOptionModelOFormat: OFormat[CycleExpireOptionModel] =
    Json.format[CycleExpireOptionModel]
  implicit def exportDocumentLineModelOFormat: OFormat[ExportDocumentLineModel] =
    Json.format[ExportDocumentLineModel]
  implicit def invoiceMessageModelOFormat: OFormat[InvoiceMessageModel] =
    Json.format[InvoiceMessageModel]
  implicit def pingResultModelOFormat: OFormat[PingResultModel] = Json.format[PingResultModel]
  implicit def addressResolutionModelOFormat: OFormat[AddressResolutionModel] =
    Json.format[AddressResolutionModel]
  implicit def activateAccountModelOFormat: OFormat[ActivateAccountModel] =
    Json.format[ActivateAccountModel]
  implicit def resetLicenseKeyModelOFormat: OFormat[ResetLicenseKeyModel] =
    Json.format[ResetLicenseKeyModel]
  implicit def provisionStatusModelOFormat: OFormat[ProvisionStatusModel] =
    Json.format[ProvisionStatusModel]
  implicit def contactModelOFormat: OFormat[ContactModel] = Json.format[ContactModel]
  implicit def transactionLineLocationTypeModelOFormat: OFormat[TransactionLineLocationTypeModel] =
    Json.format[TransactionLineLocationTypeModel]
  implicit def locationQuestionModelOFormat: OFormat[LocationQuestionModel] =
    Json.format[LocationQuestionModel]
  implicit def noticeCommentModelOFormat: OFormat[NoticeCommentModel] =
    Json.format[NoticeCommentModel]
  implicit def batchModelOFormat: OFormat[BatchModel] = Json.format[BatchModel]
  implicit def passwordChangeModelOFormat: OFormat[PasswordChangeModel] =
    Json.format[PasswordChangeModel]
  implicit def transactionSummaryOFormat: OFormat[TransactionSummary] =
    Json.format[TransactionSummary]
  implicit def itemClassificationInputModelOFormat: OFormat[ItemClassificationInputModel] =
    Json.format[ItemClassificationInputModel]
  implicit def newAccountRequestModelOFormat: OFormat[NewAccountRequestModel] =
    Json.format[NewAccountRequestModel]
  implicit def advancedRuleTableModelOFormat: OFormat[AdvancedRuleTableModel] =
    Json.format[AdvancedRuleTableModel]
  implicit def requiredFilingCalendarDataFieldModelOFormat: OFormat[RequiredFilingCalendarDataFieldModel] =
    Json.format[RequiredFilingCalendarDataFieldModel]
  implicit def reportModelOFormat: OFormat[ReportModel] = Json.format[ReportModel]
  implicit def noticeResponsibilityDetailModelOFormat: OFormat[NoticeResponsibilityDetailModel] =
    Json.format[NoticeResponsibilityDetailModel]
  implicit def verifyTransactionModelOFormat: OFormat[VerifyTransactionModel] =
    Json.format[VerifyTransactionModel]
  implicit def auditEventOFormat: OFormat[AuditEvent] = Json.format[AuditEvent]
  implicit def taxAuthorityInfoOFormat: OFormat[TaxAuthorityInfo] = Json.format[TaxAuthorityInfo]
  implicit def customFieldModelOFormat: OFormat[CustomFieldModel] = Json.format[CustomFieldModel]
  implicit def taxAuthorityModelOFormat: OFormat[TaxAuthorityModel] =
    Json.format[TaxAuthorityModel]
  implicit def taxDetailsByTaxTypeOFormat: OFormat[TaxDetailsByTaxType] =
    Json.format[TaxDetailsByTaxType]
  implicit def communicationsTransactionTypeModelOFormat: OFormat[CommunicationsTransactionTypeModel] =
    Json.format[CommunicationsTransactionTypeModel]
  implicit def setPasswordModelOFormat: OFormat[SetPasswordModel] = Json.format[SetPasswordModel]
  implicit def addressValidationInfoOFormat: OFormat[AddressValidationInfo] =
    Json.format[AddressValidationInfo]
  implicit def productClassificationSystemModelOFormat: OFormat[ProductClassificationSystemModel] =
    Json.format[ProductClassificationSystemModel]
  implicit def reconstructedApiRequestResponseModelOFormat: OFormat[ReconstructedApiRequestResponseModel] =
    Json.format[ReconstructedApiRequestResponseModel]
  implicit def pointOfSaleDataRequestModelOFormat: OFormat[PointOfSaleDataRequestModel] =
    Json.format[PointOfSaleDataRequestModel]
  implicit def worksheetDocumentOFormat: OFormat[WorksheetDocument] =
    Json.format[WorksheetDocument]
  implicit def fundingESignMethodReturnOFormat: OFormat[FundingESignMethodReturn] =
    Json.format[FundingESignMethodReturn]
  implicit def accountModelOFormat: OFormat[AccountModel] = Json.format[AccountModel]
  implicit def bulkLockTransactionModelOFormat: OFormat[BulkLockTransactionModel] =
    Json.format[BulkLockTransactionModel]
  implicit def syncItemsResponseModelOFormat: OFormat[SyncItemsResponseModel] =
    Json.format[SyncItemsResponseModel]
  implicit def ecmsDetailTaxCodeModelOFormat: OFormat[EcmsDetailTaxCodeModel] =
    Json.format[EcmsDetailTaxCodeModel]
  implicit def isoRegionModelOFormat: OFormat[IsoRegionModel] = Json.format[IsoRegionModel]
  implicit def noticeReasonModelOFormat: OFormat[NoticeReasonModel] =
    Json.format[NoticeReasonModel]
  implicit def nexusSummaryModelOFormat: OFormat[NexusSummaryModel] =
    Json.format[NexusSummaryModel]
  implicit def commitTransactionModelOFormat: OFormat[CommitTransactionModel] =
    Json.format[CommitTransactionModel]
  implicit def commitMultiDocumentModelOFormat: OFormat[CommitMultiDocumentModel] =
    Json.format[CommitMultiDocumentModel]
  implicit def bulkLockTransactionResultOFormat: OFormat[BulkLockTransactionResult] =
    Json.format[BulkLockTransactionResult]
  implicit def auditTransactionModelOFormat: OFormat[AuditTransactionModel] =
    Json.format[AuditTransactionModel]
  implicit def isoCountryModelOFormat: OFormat[IsoCountryModel] = Json.format[IsoCountryModel]
  implicit def noticeRootCauseModelOFormat: OFormat[NoticeRootCauseModel] =
    Json.format[NoticeRootCauseModel]
  implicit def nexusByAddressModelOFormat: OFormat[NexusByAddressModel] =
    Json.format[NexusByAddressModel]
  implicit def taxAuthorityTypeModelOFormat: OFormat[TaxAuthorityTypeModel] =
    Json.format[TaxAuthorityTypeModel]
  implicit def filingRequestModelOFormat: OFormat[FilingRequestModel] =
    Json.format[FilingRequestModel]
  implicit def subscriptionModelOFormat: OFormat[SubscriptionModel] =
    Json.format[SubscriptionModel]
  implicit def refundTransactionModelOFormat: OFormat[RefundTransactionModel] =
    Json.format[RefundTransactionModel]
  implicit def noticeCustomerFundingOptionModelOFormat: OFormat[NoticeCustomerFundingOptionModel] =
    Json.format[NoticeCustomerFundingOptionModel]
  implicit def addressesModelOFormat: OFormat[AddressesModel] = Json.format[AddressesModel]
  implicit def hsCodeModelOFormat: OFormat[HsCodeModel] = Json.format[HsCodeModel]
  implicit def errorDetailOFormat: OFormat[ErrorDetail] = Json.format[ErrorDetail]
  implicit def usernameModelOFormat: OFormat[UsernameModel] = Json.format[UsernameModel]
  implicit def coordinateInfoOFormat: OFormat[CoordinateInfo] = Json.format[CoordinateInfo]
  implicit def cycleExpireModelOFormat: OFormat[CycleExpireModel] = Json.format[CycleExpireModel]
  implicit def exemptionStatusModelOFormat: OFormat[ExemptionStatusModel] =
    Json.format[ExemptionStatusModel]
  implicit def fileContentResultOFormat: OFormat[FileContentResult] =
    Json.format[FileContentResult]
  implicit def licenseKeyModelOFormat: OFormat[LicenseKeyModel] = Json.format[LicenseKeyModel]
  implicit def taxRegionModelOFormat: OFormat[TaxRegionModel] = Json.format[TaxRegionModel]
  implicit def locationValidationModelOFormat: OFormat[LocationValidationModel] =
    Json.format[LocationValidationModel]
  implicit def fundingInitiateModelOFormat: OFormat[FundingInitiateModel] =
    Json.format[FundingInitiateModel]
  implicit def entityUseCodeModelOFormat: OFormat[EntityUseCodeModel] =
    Json.format[EntityUseCodeModel]
  implicit def addTransactionLineModelOFormat: OFormat[AddTransactionLineModel] =
    Json.format[AddTransactionLineModel]
  implicit def rateTypeModelOFormat: OFormat[RateTypeModel] = Json.format[RateTypeModel]
  implicit def filingFrequencyModelOFormat: OFormat[FilingFrequencyModel] =
    Json.format[FilingFrequencyModel]
  implicit def userModelOFormat: OFormat[UserModel] = Json.format[UserModel]
  implicit def itemParameterModelOFormat: OFormat[ItemParameterModel] =
    Json.format[ItemParameterModel]
  implicit def noticeRootCauseDetailModelOFormat: OFormat[NoticeRootCauseDetailModel] =
    Json.format[NoticeRootCauseDetailModel]
  implicit def certExpressInvitationModelOFormat: OFormat[CertExpressInvitationModel] =
    Json.format[CertExpressInvitationModel]
  implicit def fundingStatusModelOFormat: OFormat[FundingStatusModel] =
    Json.format[FundingStatusModel]
  implicit def batchFileModelOFormat: OFormat[BatchFileModel] = Json.format[BatchFileModel]
  implicit def cycleEditOptionModelOFormat: OFormat[CycleEditOptionModel] =
    Json.format[CycleEditOptionModel]
  implicit def taxRateModelOFormat: OFormat[TaxRateModel] = Json.format[TaxRateModel]
  implicit def taxRegionJurisdictionModelOFormat: OFormat[TaxRegionJurisdictionModel] =
    Json.format[TaxRegionJurisdictionModel]
  implicit def changeTransactionCodeModelOFormat: OFormat[ChangeTransactionCodeModel] =
    Json.format[ChangeTransactionCodeModel]
  implicit def ecmsDetailModelOFormat: OFormat[EcmsDetailModel] = Json.format[EcmsDetailModel]
  implicit def exemptionReasonModelOFormat: OFormat[ExemptionReasonModel] =
    Json.format[ExemptionReasonModel]
  implicit def noticeCustomerTypeModelOFormat: OFormat[NoticeCustomerTypeModel] =
    Json.format[NoticeCustomerTypeModel]
  implicit def itemModelOFormat: OFormat[ItemModel] = Json.format[ItemModel]
  implicit def notificationModelOFormat: OFormat[NotificationModel] =
    Json.format[NotificationModel]
  implicit def freeTrialRequestModelOFormat: OFormat[FreeTrialRequestModel] =
    Json.format[FreeTrialRequestModel]
  implicit def createCertExpressInvitationModelOFormat: OFormat[CreateCertExpressInvitationModel] =
    Json.format[CreateCertExpressInvitationModel]
  implicit def mrsCompanyModelOFormat: OFormat[MrsCompanyModel] = Json.format[MrsCompanyModel]
  implicit def linkCustomersModelOFormat: OFormat[LinkCustomersModel] =
    Json.format[LinkCustomersModel]
  implicit def noticePriorityModelOFormat: OFormat[NoticePriorityModel] =
    Json.format[NoticePriorityModel]
  implicit def adjustTransactionModelOFormat: OFormat[AdjustTransactionModel] =
    Json.format[AdjustTransactionModel]
  implicit def transactionAddressModelOFormat: OFormat[TransactionAddressModel] =
    Json.format[TransactionAddressModel]
  implicit def communicationsTSPairModelOFormat: OFormat[CommunicationsTSPairModel] =
    Json.format[CommunicationsTSPairModel]
  implicit def isoLocalizedNameOFormat: OFormat[IsoLocalizedName] = Json.format[IsoLocalizedName]
  implicit def dataSourceModelOFormat: OFormat[DataSourceModel] = Json.format[DataSourceModel]
  implicit def subscriptionTypeModelOFormat: OFormat[SubscriptionTypeModel] =
    Json.format[SubscriptionTypeModel]
  implicit def reconstructedMultiDocumentModelOFormat: OFormat[ReconstructedMultiDocumentModel] =
    Json.format[ReconstructedMultiDocumentModel]
  implicit def linkCertificatesModelOFormat: OFormat[LinkCertificatesModel] =
    Json.format[LinkCertificatesModel]
  implicit def filingStatusChangeModelOFormat: OFormat[FilingStatusChangeModel] =
    Json.format[FilingStatusChangeModel]
  implicit def taxTypeGroupModelOFormat: OFormat[TaxTypeGroupModel] =
    Json.format[TaxTypeGroupModel]
  implicit def noticeFinanceModelOFormat: OFormat[NoticeFinanceModel] =
    Json.format[NoticeFinanceModel]
  implicit def avaTaxMessageOFormat: OFormat[AvaTaxMessage] = Json.format[AvaTaxMessage]
  implicit def uPCModelOFormat: OFormat[UPCModel] = Json.format[UPCModel]
  implicit def addressLocationInfoOFormat: OFormat[AddressLocationInfo] =
    Json.format[AddressLocationInfo]
  implicit def filingRequestDataModelOFormat: OFormat[FilingRequestDataModel] =
    Json.format[FilingRequestDataModel]
  implicit def taxCodeModelOFormat: OFormat[TaxCodeModel] = Json.format[TaxCodeModel]
  implicit def jurisdictionModelOFormat: OFormat[JurisdictionModel] =
    Json.format[JurisdictionModel]
  implicit def filingsCheckupModelOFormat: OFormat[FilingsCheckupModel] =
    Json.format[FilingsCheckupModel]
  implicit def filingAnswerOFormat: OFormat[FilingAnswer] = Json.format[FilingAnswer]
  implicit def poNumberModelOFormat: OFormat[PoNumberModel] = Json.format[PoNumberModel]
  implicit def preferredProgramModelOFormat: OFormat[PreferredProgramModel] =
    Json.format[PreferredProgramModel]
  implicit def filingPaymentModelOFormat: OFormat[FilingPaymentModel] =
    Json.format[FilingPaymentModel]
  implicit def taxOverrideModelOFormat: OFormat[TaxOverrideModel] = Json.format[TaxOverrideModel]
  implicit def companyReturnSettingModelOFormat: OFormat[CompanyReturnSettingModel] =
    Json.format[CompanyReturnSettingModel]
  implicit def complianceTaxRateModelOFormat: OFormat[ComplianceTaxRateModel] =
    Json.format[ComplianceTaxRateModel]
  implicit def companyInitializationModelOFormat: OFormat[CompanyInitializationModel] =
    Json.format[CompanyInitializationModel]
  implicit def certificateTaxCodeModelOFormat: OFormat[CertificateTaxCodeModel] =
    Json.format[CertificateTaxCodeModel]
  implicit def complianceAggregatedTaxRateModelOFormat: OFormat[ComplianceAggregatedTaxRateModel] =
    Json.format[ComplianceAggregatedTaxRateModel]
  implicit def declareNexusByAddressModelOFormat: OFormat[DeclareNexusByAddressModel] =
    Json.format[DeclareNexusByAddressModel]
  implicit def approveFilingsModelOFormat: OFormat[ApproveFilingsModel] =
    Json.format[ApproveFilingsModel]
  implicit def multiDocumentModelOFormat: OFormat[MultiDocumentModel] =
    Json.format[MultiDocumentModel]
  implicit def filingAnswerModelOFormat: OFormat[FilingAnswerModel] =
    Json.format[FilingAnswerModel]
  implicit def noticeTypeModelOFormat: OFormat[NoticeTypeModel] = Json.format[NoticeTypeModel]
  implicit def complianceJurisdictionRateModelOFormat: OFormat[ComplianceJurisdictionRateModel] =
    Json.format[ComplianceJurisdictionRateModel]
  implicit def lineDetailSERCodeModelOFormat: OFormat[LineDetailSERCodeModel] =
    Json.format[LineDetailSERCodeModel]
  implicit def removeTransactionLineModelOFormat: OFormat[RemoveTransactionLineModel] =
    Json.format[RemoveTransactionLineModel]
  implicit def taxAuthorityFormModelOFormat: OFormat[TaxAuthorityFormModel] =
    Json.format[TaxAuthorityFormModel]
  implicit def noticeStatusModelOFormat: OFormat[NoticeStatusModel] =
    Json.format[NoticeStatusModel]
  implicit def itemSyncModelOFormat: OFormat[ItemSyncModel] = Json.format[ItemSyncModel]
  implicit def verifyMultiDocumentModelOFormat: OFormat[VerifyMultiDocumentModel] =
    Json.format[VerifyMultiDocumentModel]
  implicit def lineItemModelOFormat: OFormat[LineItemModel] = Json.format[LineItemModel]
  implicit def settingModelOFormat: OFormat[SettingModel] = Json.format[SettingModel]
  implicit def resourceFileTypeModelOFormat: OFormat[ResourceFileTypeModel] =
    Json.format[ResourceFileTypeModel]
  implicit def filingsCheckupSuggestedFormModelOFormat: OFormat[FilingsCheckupSuggestedFormModel] =
    Json.format[FilingsCheckupSuggestedFormModel]
  implicit def filingsCheckupAuthorityModelOFormat: OFormat[FilingsCheckupAuthorityModel] =
    Json.format[FilingsCheckupAuthorityModel]
  implicit def userEntitlementModelOFormat: OFormat[UserEntitlementModel] =
    Json.format[UserEntitlementModel]
  implicit def uomModelOFormat: OFormat[UomModel] = Json.format[UomModel]
  implicit def loginVerificationOutputModelOFormat: OFormat[LoginVerificationOutputModel] =
    Json.format[LoginVerificationOutputModel]
  implicit def complianceJurisdictionModelOFormat: OFormat[ComplianceJurisdictionModel] =
    Json.format[ComplianceJurisdictionModel]
  implicit def currencyModelOFormat: OFormat[CurrencyModel] = Json.format[CurrencyModel]
  implicit def resourceFileUploadRequestModelOFormat: OFormat[ResourceFileUploadRequestModel] =
    Json.format[ResourceFileUploadRequestModel]
  implicit def originalApiRequestResponseModelOFormat: OFormat[OriginalApiRequestResponseModel] =
    Json.format[OriginalApiRequestResponseModel]
  implicit def multiDocumentLineItemModelOFormat: OFormat[MultiDocumentLineItemModel] =
    Json.format[MultiDocumentLineItemModel]
  implicit def cycleAddOptionModelOFormat: OFormat[CycleAddOptionModel] =
    Json.format[CycleAddOptionModel]
  implicit def syncItemsRequestModelOFormat: OFormat[SyncItemsRequestModel] =
    Json.format[SyncItemsRequestModel]
  implicit def errorInfoOFormat: OFormat[ErrorInfo] = Json.format[ErrorInfo]
  implicit def noticeFilingTypeModelOFormat: OFormat[NoticeFilingTypeModel] =
    Json.format[NoticeFilingTypeModel]
  implicit def filingAdjustmentModelOFormat: OFormat[FilingAdjustmentModel] =
    Json.format[FilingAdjustmentModel]
  implicit def fundingConfigurationModelOFormat: OFormat[FundingConfigurationModel] =
    Json.format[FundingConfigurationModel]
  implicit def companyAddressOFormat: OFormat[CompanyAddress] = Json.format[CompanyAddress]
  implicit def accountConfigurationModelOFormat: OFormat[AccountConfigurationModel] =
    Json.format[AccountConfigurationModel]
  implicit def locationSettingModelOFormat: OFormat[LocationSettingModel] =
    Json.format[LocationSettingModel]
  implicit def nexusByTaxFormModelOFormat: OFormat[NexusByTaxFormModel] =
    Json.format[NexusByTaxFormModel]
  implicit def companyDistanceThresholdModelOFormat: OFormat[CompanyDistanceThresholdModel] =
    Json.format[CompanyDistanceThresholdModel]
  implicit def settleTransactionModelOFormat: OFormat[SettleTransactionModel] =
    Json.format[SettleTransactionModel]
  implicit def filingCalendarEditModelOFormat: OFormat[FilingCalendarEditModel] =
    Json.format[FilingCalendarEditModel]
  implicit def skyscraperStatusModelOFormat: OFormat[SkyscraperStatusModel] =
    Json.format[SkyscraperStatusModel]
  implicit def auditMultiDocumentModelOFormat: OFormat[AuditMultiDocumentModel] =
    Json.format[AuditMultiDocumentModel]
  implicit def transactionReferenceFieldModelOFormat: OFormat[TransactionReferenceFieldModel] =
    Json.format[TransactionReferenceFieldModel]
  implicit def nexusTaxTypeGroupModelOFormat: OFormat[NexusTaxTypeGroupModel] =
    Json.format[NexusTaxTypeGroupModel]
  implicit def postalCodeModelOFormat: OFormat[PostalCodeModel] = Json.format[PostalCodeModel]
  implicit def errorResultOFormat: OFormat[ErrorResult] = Json.format[ErrorResult]
  implicit def noticeResponsibilityModelOFormat: OFormat[NoticeResponsibilityModel] =
    Json.format[NoticeResponsibilityModel]
  implicit def addressInfoOFormat: OFormat[AddressInfo] = Json.format[AddressInfo]
  implicit def messageOFormat: OFormat[Message] = Json.format[Message]
  implicit def filingReturnCreditModelOFormat: OFormat[FilingReturnCreditModel] =
    Json.format[FilingReturnCreditModel]
  implicit def rateModelOFormat: OFormat[RateModel] = Json.format[RateModel]
  implicit def securityRoleModelOFormat: OFormat[SecurityRoleModel] =
    Json.format[SecurityRoleModel]
  implicit def avaFileFormModelOFormat: OFormat[AvaFileFormModel] = Json.format[AvaFileFormModel]
}
