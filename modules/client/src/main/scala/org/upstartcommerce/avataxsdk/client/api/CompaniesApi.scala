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

package org.upstartcommerce.avataxsdk.client.api

import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.api.companies._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._

/** api/v2/companies */
trait CompaniesRootApi {
  def forCompanyId(companyId: Int): CompaniesApi
  def forCompanyCode(companyCode: String): CompaniesForCodeApi

  def initialize(model: CompanyInitializationModel): AvataxSimpleCall[CompanyModel]
  def create(model: List[CompanyModel]): AvataxSimpleCall[List[CompanyModel]]
  def listMrsCompanies: AvataxCollectionCall[MrsCompanyModel]
  def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[CompanyModel]

  def addTransactionLines(include: Include, model: AddTransactionLineModel): AvataxSimpleCall[TransactionModel]
}

/** api/v2/companies/$companyCode */
trait CompaniesForCodeApi {
  def transactions: CompanyTransactionsRootApi
}

/** api/v2/companies/$companyId */
trait CompaniesApi {
  def customers: CompanyCustomersRootApi
  def certificates: CompanyCertificatesRootApi
  def contacts: CompanyContactsRootApi
  def dataSources: CompanyDataSourcesRootApi
  def distanceThresholds: CompanyDistanceThresholdRootApi
  def filingRequests: CompanyFilingRequestsRootApi
  def companyRequests: CompanyFilingCalendarRootApi
  def locations: CompanyLocationsRootApi
  def nexuses: CompanyNexusRootApi
  def settings: CompanySettingsRootApi
  def taxCodes: CompanyTaxCodesRootApi
  def reports: CompanyReportsRootApi
  def taxRules: CompanyTaxRulesRootApi

  def listCertExpressInvitations(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[CertExpressInvitationModel]
  def changeFilingStatus(model: FilingStatusChangeModel): AvataxSimpleCall[String]
  def createFundingRequest(model: FundingInitiateModel): AvataxSimpleCall[FundingStatusModel]
  def delete: AvataxSimpleCall[List[ErrorDetail]]
  def fundingConfiguration: AvataxSimpleCall[FundingConfigurationModel]
  def fundingConfigurationsByCurrency(currency: String): AvataxSimpleCall[List[FundingConfigurationModel]]
  def get(include: Include): AvataxSimpleCall[CompanyModel]
  def getConfiguration: AvataxSimpleCall[List[CompanyConfigurationModel]]
  def getFilingStatus: AvataxSimpleCall[String]
  def listFundingRequests: AvataxSimpleCall[List[FundingConfigurationModel]]
  def setConfiguration(model: List[CompanyConfigurationModel]): AvataxSimpleCall[List[CompanyConfigurationModel]]
  def update(model: CompanyModel): AvataxSimpleCall[CompanyModel]

  def approveFilings(year: Short, month: Byte, model: ApproveFilingsModel): AvataxSimpleCall[List[FilingModel]]
  def approveFilingsCountry(year: Short, month: Byte, country: String, model: ApproveFilingsModel): AvataxSimpleCall[List[FilingModel]]
  def approveFilingsCountryRegion(
      year: Short,
      month: Byte,
      country: String,
      region: String,
      model: ApproveFilingsModel
  ): AvataxSimpleCall[List[FilingModel]]
  def createReturnAdjustment(
      year: Short,
      month: Byte,
      country: String,
      region: String,
      formCode: String,
      model: List[FilingAdjustmentModel]
  ): AvataxSimpleCall[List[FilingAdjustmentModel]]
  def createReturnAugmentation(
      year: Short,
      month: Byte,
      country: String,
      region: String,
      formCode: String,
      model: List[FilingAugmentationModel]
  ): AvataxSimpleCall[List[FilingAugmentationModel]]
  def createReturnPayment(
      year: Short,
      month: Byte,
      country: String,
      region: String,
      formCode: String,
      model: List[FilingPaymentModel]
  ): AvataxSimpleCall[List[FilingPaymentModel]]
  def deleteReturnAdjustment(adjustmentId: Long): AvataxSimpleCall[List[ErrorDetail]]
  def deleteReturnAugmentation(augmentId: Long): AvataxSimpleCall[List[ErrorDetail]]
  def deleteReturnPayment(paymentId: Long): AvataxSimpleCall[List[ErrorDetail]]
  def filingCheckupReport(filingsId: Int): AvataxSimpleCall[FilingsCheckupModel]
  def filingCheckupReports(year: Short, month: Byte): AvataxSimpleCall[FilingsCheckupModel]
  def getFilingsAttachment(filingReturnId: Long, fileId: Long): AvataxSimpleCall[String]
  def getFilingsAttachments(year: Short, month: Byte): AvataxSimpleCall[String]
  def getFilingsAttachmentsTraceFile(year: Short, month: Byte): AvataxSimpleCall[String]
  def getFilingReturn(filingId: Int, details: Boolean): AvataxSimpleCall[FilingReturnModel]
  def getFilings(year: Short, month: Byte): AvataxCollectionCall[FilingModel]
  def getFilingsByCountry(year: Short, month: Byte, country: String): AvataxCollectionCall[FilingModel]
  def getFilingsByCountryRegion(year: Short, month: Byte, country: String, region: String): AvataxCollectionCall[FilingModel]
  def getFilingsByReturnName(year: Short, month: Byte, country: String, region: String, formCode: String): AvataxCollectionCall[FilingModel]
  def getFilingReturns(
      endPeriodMonth: Int,
      endPeriodYear: Int,
      frequency: FilingFrequencyId,
      status: FilingStatusId,
      country: String,
      region: String,
      filingCalendarId: Long
  ): AvataxCollectionCall[FilingReturnModelBasic]
  def rebuildFilings(year: Short, month: Byte, model: RebuildFilingsModel): AvataxCollectionCall[FilingModel]
  def rebuildFilingsByCountry(year: Short, month: Byte, country: String, model: RebuildFilingsModel): AvataxCollectionCall[FilingModel]
  def rebuildFilingsByCountryRegion(
      year: Short,
      month: Byte,
      country: String,
      region: String,
      model: RebuildFilingsModel
  ): AvataxCollectionCall[FilingModel]
  def updateReturnAdjustment(adjustmentId: Long, model: FilingAdjustmentModel): AvataxSimpleCall[FilingAdjustmentModel]
  def updateReturnAugmentation(augmentId: Long, model: FilingAugmentationModel): AvataxSimpleCall[FilingAugmentationModel]
  def updateReturnPayment(paymentId: Long, model: FilingPaymentModel): AvataxSimpleCall[FilingPaymentModel]
}
