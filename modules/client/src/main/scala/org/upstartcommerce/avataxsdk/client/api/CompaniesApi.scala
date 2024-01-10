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
trait CompaniesRootApi[F[_], S[_]] {
  def forCompanyId(companyId: Int): CompaniesApi[F, S]
  def forCompanyCode(companyCode: String): CompaniesForCodeApi[F, S]

  def initialize(model: CompanyInitializationModel): AvataxSimpleCall[F, CompanyModel]
  def create(model: List[CompanyModel]): AvataxSimpleCall[F, List[CompanyModel]]
  def listMrsCompanies: AvataxCollectionCall[F, S, MrsCompanyModel]
  def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, CompanyModel]

  def addTransactionLines(include: Include, model: AddTransactionLineModel): AvataxSimpleCall[F, TransactionModel]
}

/** api/v2/companies/$companyCode */
trait CompaniesForCodeApi[F[_], S[_]] {
  def transactions: CompanyTransactionsRootApi[F, S]
}

/** api/v2/companies/$companyId */
trait CompaniesApi[F[_], S[_]] {
  def customers: CompanyCustomersRootApi[F, S]
  def certificates: CompanyCertificatesRootApi[F, S]
  def contacts: CompanyContactsRootApi[F, S]
  def dataSources: CompanyDataSourcesRootApi[F, S]
  def distanceThresholds: CompanyDistanceThresholdRootApi[F, S]
  def filingRequests: CompanyFilingRequestsRootApi[F, S]
  def companyRequests: CompanyFilingCalendarRootApi[F, S]
  def locations: CompanyLocationsRootApi[F, S]
  def nexuses: CompanyNexusRootApi[F, S]
  def settings: CompanySettingsRootApi[F, S]
  def taxCodes: CompanyTaxCodesRootApi[F, S]
  def reports: CompanyReportsRootApi[F, S]
  def taxRules: CompanyTaxRulesRootApi[F, S]

  def listCertExpressInvitations(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, CertExpressInvitationModel]
  def changeFilingStatus(model: FilingStatusChangeModel): AvataxSimpleCall[F, String]
  def createFundingRequest(model: FundingInitiateModel): AvataxSimpleCall[F, FundingStatusModel]
  def delete: AvataxSimpleCall[F, List[ErrorDetail]]
  def fundingConfiguration: AvataxSimpleCall[F, FundingConfigurationModel]
  def fundingConfigurationsByCurrency(currency: String): AvataxSimpleCall[F, List[FundingConfigurationModel]]
  def get(include: Include): AvataxSimpleCall[F, CompanyModel]
  def getConfiguration: AvataxSimpleCall[F, List[CompanyConfigurationModel]]
  def getFilingStatus: AvataxSimpleCall[F, String]
  def listFundingRequests: AvataxSimpleCall[F, List[FundingConfigurationModel]]
  def setConfiguration(model: List[CompanyConfigurationModel]): AvataxSimpleCall[F, List[CompanyConfigurationModel]]
  def update(model: CompanyModel): AvataxSimpleCall[F, CompanyModel]

  def approveFilings(year: Short, month: Byte, model: ApproveFilingsModel): AvataxSimpleCall[F, List[FilingModel]]
  def approveFilingsCountry(year: Short, month: Byte, country: String, model: ApproveFilingsModel): AvataxSimpleCall[F, List[FilingModel]]
  def approveFilingsCountryRegion(
      year: Short,
      month: Byte,
      country: String,
      region: String,
      model: ApproveFilingsModel
  ): AvataxSimpleCall[F, List[FilingModel]]
  def createReturnAdjustment(
      year: Short,
      month: Byte,
      country: String,
      region: String,
      formCode: String,
      model: List[FilingAdjustmentModel]
  ): AvataxSimpleCall[F, List[FilingAdjustmentModel]]
  def createReturnAugmentation(
      year: Short,
      month: Byte,
      country: String,
      region: String,
      formCode: String,
      model: List[FilingAugmentationModel]
  ): AvataxSimpleCall[F, List[FilingAugmentationModel]]
  def createReturnPayment(
      year: Short,
      month: Byte,
      country: String,
      region: String,
      formCode: String,
      model: List[FilingPaymentModel]
  ): AvataxSimpleCall[F, List[FilingPaymentModel]]
  def deleteReturnAdjustment(adjustmentId: Long): AvataxSimpleCall[F, List[ErrorDetail]]
  def deleteReturnAugmentation(augmentId: Long): AvataxSimpleCall[F, List[ErrorDetail]]
  def deleteReturnPayment(paymentId: Long): AvataxSimpleCall[F, List[ErrorDetail]]
  def filingCheckupReport(filingsId: Int): AvataxSimpleCall[F, FilingsCheckupModel]
  def filingCheckupReports(year: Short, month: Byte): AvataxSimpleCall[F, FilingsCheckupModel]
  def getFilingsAttachment(filingReturnId: Long, fileId: Long): AvataxSimpleCall[F, String]
  def getFilingsAttachments(year: Short, month: Byte): AvataxSimpleCall[F, String]
  def getFilingsAttachmentsTraceFile(year: Short, month: Byte): AvataxSimpleCall[F, String]
  def getFilingReturn(filingId: Int, details: Boolean): AvataxSimpleCall[F, FilingReturnModel]
  def getFilings(year: Short, month: Byte): AvataxCollectionCall[F, S, FilingModel]
  def getFilingsByCountry(year: Short, month: Byte, country: String): AvataxCollectionCall[F, S, FilingModel]
  def getFilingsByCountryRegion(year: Short, month: Byte, country: String, region: String): AvataxCollectionCall[F, S, FilingModel]
  def getFilingsByReturnName(
      year: Short,
      month: Byte,
      country: String,
      region: String,
      formCode: String
  ): AvataxCollectionCall[F, S, FilingModel]
  def getFilingReturns(
      endPeriodMonth: Int,
      endPeriodYear: Int,
      frequency: FilingFrequencyId,
      status: FilingStatusId,
      country: String,
      region: String,
      filingCalendarId: Long
  ): AvataxCollectionCall[F, S, FilingReturnModelBasic]
  def rebuildFilings(year: Short, month: Byte, model: RebuildFilingsModel): AvataxCollectionCall[F, S, FilingModel]
  def rebuildFilingsByCountry(
      year: Short,
      month: Byte,
      country: String,
      model: RebuildFilingsModel
  ): AvataxCollectionCall[F, S, FilingModel]
  def rebuildFilingsByCountryRegion(
      year: Short,
      month: Byte,
      country: String,
      region: String,
      model: RebuildFilingsModel
  ): AvataxCollectionCall[F, S, FilingModel]
  def updateReturnAdjustment(adjustmentId: Long, model: FilingAdjustmentModel): AvataxSimpleCall[F, FilingAdjustmentModel]
  def updateReturnAugmentation(augmentId: Long, model: FilingAugmentationModel): AvataxSimpleCall[F, FilingAugmentationModel]
  def updateReturnPayment(paymentId: Long, model: FilingPaymentModel): AvataxSimpleCall[F, FilingPaymentModel]
}
