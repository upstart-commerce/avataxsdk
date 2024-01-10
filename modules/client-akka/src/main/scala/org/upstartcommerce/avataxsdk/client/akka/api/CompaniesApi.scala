/* Copyright 2024 UpStart Commerce, Inc.
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

package org.upstartcommerce.avataxsdk.client.akka.api

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model.Uri.Query
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client.akka._
import org.upstartcommerce.avataxsdk.client.akka.api.companies._
import org.upstartcommerce.avataxsdk.client.akka.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.api.companies._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.{CompaniesApi, CompaniesForCodeApi, CompaniesRootApi}
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object CompaniesRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      implicit system: ActorSystem,
      materializer: Materializer
  ): CompaniesRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompaniesRootApi[Future, Stream] {
      def forCompanyId(companyId: Int): CompaniesApi[Future, Stream] = CompaniesApiImpl(requester, security, clientHeaders)(companyId)
      def forCompanyCode(companyCode: String): CompaniesForCodeApi[Future, Stream] =
        CompaniesForCodeApiImpl(requester, security, clientHeaders)(companyCode)

      def initialize(model: CompanyInitializationModel): AvataxSimpleCall[CompanyModel] = {
        val uri = Uri(s"/api/v2/companies/initialize")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[CompanyInitializationModel, CompanyModel](req, model)
      }

      def create(model: List[CompanyModel]): AvataxSimpleCall[List[CompanyModel]] = {
        val uri = Uri(s"/api/v2/companies")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[CompanyModel], List[CompanyModel]](req, model)
      }

      def listMrsCompanies: AvataxCollectionCall[MrsCompanyModel] = {
        val uri = Uri(s"/api/v2/companies/mrs")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[MrsCompanyModel](req)
      }

      def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[CompanyModel] = {
        val uri = Uri(s"/api/v2/companies").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CompanyModel](req)
      }

      def addTransactionLines(include: Include, model: AddTransactionLineModel): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/companies/transactions/lines/add")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[AddTransactionLineModel, TransactionModel](req, model)
      }
    }
}

object CompaniesForCodeApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyCode: String
  )(implicit system: ActorSystem, materializer: Materializer): CompaniesForCodeApi[Future, Stream] = {
    new ApiRoot(requester, security, clientHeaders) with CompaniesForCodeApi[Future, Stream] {
      val transactions: CompanyTransactionsRootApi[Future, Stream] =
        CompanyTransactionsRootApiImpl(requester, security, clientHeaders)(companyCode)
    }
  }
}

object CompaniesApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyId: Int
  )(implicit system: ActorSystem, materializer: Materializer): CompaniesApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompaniesApi[Future, Stream] {
      val customers: CompanyCustomersRootApi[Future, Stream] = CompanyCustomersRootApiImpl(requester, security, clientHeaders)(companyId)
      val certificates: CompanyCertificatesRootApi[Future, Stream] =
        CompanyCertificatesRootApiImpl(requester, security, clientHeaders)(companyId)
      val contacts: CompanyContactsRootApi[Future, Stream] = CompanyContactsRootApiImpl(requester, security, clientHeaders)(companyId)
      val dataSources: CompanyDataSourcesRootApi[Future, Stream] =
        CompanyDataSourcesRootApiImpl(requester, security, clientHeaders)(companyId)
      val distanceThresholds: CompanyDistanceThresholdRootApi[Future, Stream] =
        CompanyDistanceThresholdRootApiImpl(requester, security, clientHeaders)(companyId)
      val filingRequests: CompanyFilingRequestsRootApi[Future, Stream] =
        CompanyFilingRequestsRootApiImpl(requester, security, clientHeaders)(companyId)
      val companyRequests: CompanyFilingCalendarRootApi[Future, Stream] =
        CompanyFilingCalendarRootApiImpl(requester, security, clientHeaders)(companyId)
      val locations: CompanyLocationsRootApi[Future, Stream] = CompanyLocationsRootApiImpl(requester, security, clientHeaders)(companyId)
      val nexuses: CompanyNexusRootApi[Future, Stream] = CompanyNexusRootApiImpl(requester, security, clientHeaders)(companyId)
      val notices: CompanyNoticesRootApi[Future, Stream] = CompanyNoticesRootApiImpl(requester, security, clientHeaders)(companyId)
      val settings: CompanySettingsRootApi[Future, Stream] = CompanySettingsRootApiImpl(requester, security, clientHeaders)(companyId)
      val taxCodes: CompanyTaxCodesRootApi[Future, Stream] = CompanyTaxCodesRootApiImpl(requester, security, clientHeaders)(companyId)
      val reports: CompanyReportsRootApi[Future, Stream] = CompanyReportsRootApiImpl(requester, security, clientHeaders)(companyId)
      val taxRules: CompanyTaxRulesRootApi[Future, Stream] = CompanyTaxRulesRootApiImpl(requester, security, clientHeaders)(companyId)
      val upcs: CompanyUPCsRootApi[Future, Stream] = CompanyUPCsRootApiImpl(requester, security, clientHeaders)(companyId)

      def listCertExpressInvitations(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[CertExpressInvitationModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/certexpressinvites").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CertExpressInvitationModel](req)
      }

      def changeFilingStatus(model: FilingStatusChangeModel): AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingstatus")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[FilingStatusChangeModel, String](req, model)
      }

      def createFundingRequest(model: FundingInitiateModel): AvataxSimpleCall[FundingStatusModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/funding/setup")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[FundingInitiateModel, FundingStatusModel](req, model)
      }

      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def fundingConfiguration: AvataxSimpleCall[FundingConfigurationModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/funding/configuration")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[FundingConfigurationModel](req)
      }

      def fundingConfigurationsByCurrency(currency: String): AvataxSimpleCall[List[FundingConfigurationModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/funding/configuration").withQuery(Query("currency" -> currency))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[List[FundingConfigurationModel]](req)
      }

      def get(include: Include): AvataxSimpleCall[CompanyModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[CompanyModel](req)
      }

      def getConfiguration: AvataxSimpleCall[List[CompanyConfigurationModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/configuration")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[List[CompanyConfigurationModel]](req)
      }

      def getFilingStatus: AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filingstatus")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[String](req)
      }

      def listFundingRequests: AvataxSimpleCall[List[FundingConfigurationModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/funding")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[List[FundingConfigurationModel]](req)
      }

      def setConfiguration(model: List[CompanyConfigurationModel]): AvataxSimpleCall[List[CompanyConfigurationModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/configuration")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[CompanyConfigurationModel], List[CompanyConfigurationModel]](req, model)
      }

      def update(model: CompanyModel): AvataxSimpleCall[CompanyModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[CompanyModel, CompanyModel](req, model)
      }

      def approveFilings(year: Short, month: Byte, model: ApproveFilingsModel): AvataxSimpleCall[List[FilingModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/approve")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[ApproveFilingsModel, List[FilingModel]](req, model)
      }

      def approveFilingsCountry(
          year: Short,
          month: Byte,
          country: String,
          model: ApproveFilingsModel
      ): AvataxSimpleCall[List[FilingModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/$country/approve")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[ApproveFilingsModel, List[FilingModel]](req, model)
      }

      def approveFilingsCountryRegion(
          year: Short,
          month: Byte,
          country: String,
          region: String,
          model: ApproveFilingsModel
      ): AvataxSimpleCall[List[FilingModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/$country/$region/approve")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[ApproveFilingsModel, List[FilingModel]](req, model)
      }

      def createReturnAdjustment(
          year: Short,
          month: Byte,
          country: String,
          region: String,
          formCode: String,
          model: List[FilingAdjustmentModel]
      ): AvataxSimpleCall[List[FilingAdjustmentModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/$country/$region/$formCode/adjust")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[FilingAdjustmentModel], List[FilingAdjustmentModel]](req, model)
      }

      def createReturnAugmentation(
          year: Short,
          month: Byte,
          country: String,
          region: String,
          formCode: String,
          model: List[FilingAugmentationModel]
      ): AvataxSimpleCall[List[FilingAugmentationModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/$country/$region/$formCode/augment")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[FilingAugmentationModel], List[FilingAugmentationModel]](req, model)
      }

      def createReturnPayment(
          year: Short,
          month: Byte,
          country: String,
          region: String,
          formCode: String,
          model: List[FilingPaymentModel]
      ): AvataxSimpleCall[List[FilingPaymentModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/$country/$region/$formCode/payment")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[FilingPaymentModel], List[FilingPaymentModel]](req, model)
      }

      def deleteReturnAdjustment(adjustmentId: Long): AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/adjust/$adjustmentId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def deleteReturnAugmentation(augumentId: Long): AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/augument/$augumentId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def deleteReturnPayment(paymentId: Long): AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/payment/$paymentId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def filingCheckupReport(filingsId: Int): AvataxSimpleCall[FilingsCheckupModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$filingsId/checkup")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[FilingsCheckupModel](req)
      }

      def filingCheckupReports(year: Short, month: Byte): AvataxSimpleCall[FilingsCheckupModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/checkup")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[FilingsCheckupModel](req)
      }

      def getFilingsAttachment(filingReturnId: Long, fileId: Long): AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$filingReturnId/attachment").withQuery(Query("fileId" -> fileId.toString))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[String](req)
      }

      def getFilingsAttachments(year: Short, month: Byte): AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/attachments")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[String](req)
      }

      def getFilingsAttachmentsTraceFile(year: Short, month: Byte): AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/attachments/tracefile")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[String](req)
      }

      def getFilingReturn(filingId: Int, details: Boolean): AvataxSimpleCall[FilingReturnModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/returns/$filingId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[FilingReturnModel](req)
      }

      def getFilings(year: Short, month: Byte): AvataxCollectionCall[FilingModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[FilingModel](req)
      }

      def getFilingsByCountry(year: Short, month: Byte, country: String): AvataxCollectionCall[FilingModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/$country")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[FilingModel](req)
      }

      def getFilingsByCountryRegion(year: Short, month: Byte, country: String, region: String): AvataxCollectionCall[FilingModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/$country/$region")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[FilingModel](req)
      }

      def getFilingsByReturnName(
          year: Short,
          month: Byte,
          country: String,
          region: String,
          formCode: String
      ): AvataxCollectionCall[FilingModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/$country/$region/$formCode")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[FilingModel](req)
      }

      def getFilingReturns(
          endPeriodMonth: Int,
          endPeriodYear: Int,
          frequency: FilingFrequencyId,
          status: FilingStatusId,
          country: String,
          region: String,
          filingCalendarId: Long
      ): AvataxCollectionCall[FilingReturnModelBasic] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/returns").withQuery(
          Query(
            "endPeriodMonth" -> endPeriodMonth.toString,
            "endPeriodYear" -> endPeriodYear.toString,
            "frequency" -> frequency.toString,
            "status" -> status.toString,
            "country" -> country,
            "region" -> region,
            "filingCalendarId" -> filingCalendarId.toString
          )
        )
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[FilingReturnModelBasic](req)
      }

      def rebuildFilings(year: Short, month: Byte, model: RebuildFilingsModel): AvataxCollectionCall[FilingModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/rebuild")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxCollectionBodyCall[RebuildFilingsModel, FilingModel](req, model)
      }

      def rebuildFilingsByCountry(
          year: Short,
          month: Byte,
          country: String,
          model: RebuildFilingsModel
      ): AvataxCollectionCall[FilingModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/$country/rebuild")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxCollectionBodyCall[RebuildFilingsModel, FilingModel](req, model)
      }

      def rebuildFilingsByCountryRegion(
          year: Short,
          month: Byte,
          country: String,
          region: String,
          model: RebuildFilingsModel
      ): AvataxCollectionCall[FilingModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/$year/$month/$country/$region/rebuild")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxCollectionBodyCall[RebuildFilingsModel, FilingModel](req, model)
      }

      def updateReturnAdjustment(adjustmentId: Long, model: FilingAdjustmentModel): AvataxSimpleCall[FilingAdjustmentModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/adjust/$adjustmentId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[FilingAdjustmentModel, FilingAdjustmentModel](req, model)
      }

      def updateReturnAugmentation(augmentId: Long, model: FilingAugmentationModel): AvataxSimpleCall[FilingAugmentationModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/augment/$augmentId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[FilingAugmentationModel, FilingAugmentationModel](req, model)
      }

      def updateReturnPayment(paymentId: Long, model: FilingPaymentModel): AvataxSimpleCall[FilingPaymentModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/filings/payment/$paymentId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[FilingPaymentModel, FilingPaymentModel](req, model)
      }
    }
}
