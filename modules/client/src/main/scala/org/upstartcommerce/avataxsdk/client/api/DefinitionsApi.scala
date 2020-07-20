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

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model.Uri.Query
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

trait DefinitionsRootApi {
  def getCrossBorderCode(country: String, hsCode: String): AvataxCollectionCall[HsCodeModel]
  def getLoginVerifierByForm(form: String, options: FiltrableQueryOptions): AvataxCollectionCall[SkyscraperStatusModel]
  def listAvaFileForms(options: FiltrableQueryOptions): AvataxCollectionCall[AvaFileFormModel]
  def listCertificateAttributes(options: FiltrableQueryOptions): AvataxCollectionCall[CertificateAttributeModel]
  def listCertificateExemptReasons(options: FiltrableQueryOptions): AvataxCollectionCall[ExemptionReasonModel]
  def listCertificatesExposureZones(options: FiltrableQueryOptions): AvataxCollectionCall[ExposureZoneModel]
  def listCommunicationsServiceTypes(id: Int, options: FiltrableQueryOptions): AvataxCollectionCall[CommunicationsTSPairModel]
  def listCommunicationsTransactionTypes(options: FiltrableQueryOptions): AvataxCollectionCall[CommunicationsTransactionTypeModel]
  def listCommunicationsTSPairs(options: FiltrableQueryOptions): AvataxCollectionCall[CommunicationsTSPairModel]
  def listCountries(options: FiltrableQueryOptions): AvataxCollectionCall[IsoCountryModel]
  def listCoverLetters(options: FiltrableQueryOptions): AvataxCollectionCall[CoverLetterModel]
  def listCrossBorderCodes(country: String, hsCode: String, options: FiltrableQueryOptions): AvataxCollectionCall[HsCodeModel]
  def listCrossBorderSections(): AvataxCollectionCall[HsCodeModel]
  def listCurrencies(options: FiltrableQueryOptions): AvataxCollectionCall[CurrencyModel]
  def listEntityUseCodes(options: FiltrableQueryOptions): AvataxCollectionCall[EntityUseCodeModel]
  def listFilingFrequencies(options: FiltrableQueryOptions): AvataxCollectionCall[FilingFrequencyModel]
  def listJurisdictions(options: FiltrableQueryOptions): AvataxCollectionCall[JurisdictionModel]
  def listJurisdictionsByAddress(
      line1: String,
      line2: String,
      line3: String,
      city: String,
      region: String,
      postalCode: String,
      country: String,
      options: FiltrableQueryOptions
  ): AvataxCollectionCall[JurisdictionOverrideModel]
  def listLocationQuestionsByAddress(
      line1: String,
      line2: String,
      line3: String,
      city: String,
      region: String,
      postalCode: String,
      country: String,
      latitude: BigDecimal,
      longitude: BigDecimal,
      options: FiltrableQueryOptions
  ): AvataxCollectionCall[LocationQuestionModel]
  def listLoginVerifiers(options: FiltrableQueryOptions): AvataxCollectionCall[SkyscraperStatusModel]
  def listNexus(options: FiltrableQueryOptions): AvataxCollectionCall[NexusModel]
  def listNexusByAddress(
      line1: String,
      line2: String,
      line3: String,
      city: String,
      region: String,
      postalCode: String,
      country: String,
      options: FiltrableQueryOptions
  ): AvataxCollectionCall[NexusModel]
  def listNexusByCountry(country: String, options: FiltrableQueryOptions): AvataxCollectionCall[NexusModel]
  def listNexusByCountryAndRegion(country: String, region: String, options: FiltrableQueryOptions): AvataxCollectionCall[NexusModel]
  def listNexusByFormCode(formCode: String, options: FiltrableQueryOptions): AvataxCollectionCall[NexusModel]
  def listNexusTaxTypeGroups(options: FiltrableQueryOptions): AvataxCollectionCall[NexusTaxTypeGroupModel]
  def listNoticeCustomerFundingOptions(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeCustomerFundingOptionModel]
  def listNoticeCustomerTypes(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeCustomerTypeModel]
  def listNoticeFilingTypes(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeFilingTypeModel]
  def listNoticePriorities(options: FiltrableQueryOptions): AvataxCollectionCall[NoticePriorityModel]
  def listNoticeReasons(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeReasonModel]
  def listNoticeResponsibilities(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeResponsibilityModel]
  def listNoticeRootCauses(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeRootCauseModel]
  def listNoticeStatuses(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeStatusModel]
  def listNoticeTypes(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeTypeModel]
  def listParameters(options: FiltrableQueryOptions): AvataxCollectionCall[ParameterModel]
  def listParametersByItem(companyCode: String, itemCode: String, options: FiltrableQueryOptions): AvataxCollectionCall[ParameterModel]
  def listPermissions(options: BasicQueryOptions): AvataxCollectionCall[String]
  def listPostalCodes(options: FiltrableQueryOptions): AvataxCollectionCall[PostalCodeModel]
  def listPreferredPrograms(options: FiltrableQueryOptions): AvataxCollectionCall[PreferredProgramModel]
  def listProductClassificationSystems(options: FiltrableQueryOptions): AvataxCollectionCall[ProductClassificationSystemModel]
  def listProductClassificationSystemsByCompany(
      companyCode: String,
      options: FiltrableQueryOptions
  ): AvataxCollectionCall[ProductClassificationSystemModel]
  def listRateTypesByCountry(country: String, options: FiltrableQueryOptions): AvataxCollectionCall[RateTypeModel]
  def listRegions(options: FiltrableQueryOptions): AvataxCollectionCall[IsoRegionModel]
  def listRegionsByCountry(country: String, options: FiltrableQueryOptions): AvataxCollectionCall[IsoRegionModel]
  def listResourceFileTypes(options: FiltrableQueryOptions): AvataxCollectionCall[ResourceFileTypeModel]
  def listSecurityRoles(options: FiltrableQueryOptions): AvataxCollectionCall[SecurityRoleModel]
  def listSubscriptionTypes(options: FiltrableQueryOptions): AvataxCollectionCall[SubscriptionTypeModel]
  def listTaxAuthorities(options: FiltrableQueryOptions): AvataxCollectionCall[TaxAuthorityModel]
  def listTaxAuthorityForms(options: FiltrableQueryOptions): AvataxCollectionCall[TaxAuthorityFormModel]
  def listTaxAuthorityTypes(options: FiltrableQueryOptions): AvataxCollectionCall[TaxAuthorityTypeModel]
  def listTaxCodes(options: FiltrableQueryOptions): AvataxCollectionCall[TaxCodeModel]
  def listTaxCodeTypes(options: FiltrableQueryOptions): AvataxCollectionCall[TaxCodeTypesModel]
  def listTaxForms(options: FiltrableQueryOptions): AvataxCollectionCall[FormMasterModel]
  def listTaxSubTypes(options: FiltrableQueryOptions): AvataxCollectionCall[TaxSubTypeModel]
  def listTaxTypeGroups(options: FiltrableQueryOptions): AvataxCollectionCall[TaxTypeGroupModel]
  def listUnitOfMeasurement(options: FiltrableQueryOptions): AvataxCollectionCall[UomModel]
}

object DefinitionsRootApi {
  def apply(
      requester: Requester,
      security: Option[Authorization]
  )(implicit system: ActorSystem, materializer: Materializer): DefinitionsRootApi =
    new ApiRoot(requester, security) with DefinitionsRootApi {
      def getCrossBorderCode(country: String, hsCode: String): AvataxCollectionCall[HsCodeModel] = {
        val uri = Uri(s"/api/v2/definitions/crossborder/$country/$hsCode/hierarchy")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[HsCodeModel](req)
      }

      def getLoginVerifierByForm(form: String, options: FiltrableQueryOptions): AvataxCollectionCall[SkyscraperStatusModel] = {
        val uri = Uri(s"/api/v2/definitions/filingcalendars/loginverifiers/$form").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[SkyscraperStatusModel](req)
      }

      def listAvaFileForms(options: FiltrableQueryOptions): AvataxCollectionCall[AvaFileFormModel] = {
        val uri = Uri("/api/v2/definitions/avafileforms").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[AvaFileFormModel](req)
      }

      def listCertificateAttributes(options: FiltrableQueryOptions): AvataxCollectionCall[CertificateAttributeModel] = {
        val uri = Uri("/api/v2/definitions/certificateattributes").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CertificateAttributeModel](req)
      }

      def listCertificateExemptReasons(options: FiltrableQueryOptions): AvataxCollectionCall[ExemptionReasonModel] = {
        val uri = Uri("/api/v2/definitions/certificateexemptreasons").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ExemptionReasonModel](req)
      }

      def listCertificatesExposureZones(options: FiltrableQueryOptions): AvataxCollectionCall[ExposureZoneModel] = {
        val uri = Uri("/api/v2/definitions/certificateexposurezones").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ExposureZoneModel](req)
      }

      def listCommunicationsServiceTypes(id: Int, options: FiltrableQueryOptions): AvataxCollectionCall[CommunicationsTSPairModel] = {
        val uri = Uri(s"/api/v2/definitions/communications/transactiontypes/$id/servicetypes").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CommunicationsTSPairModel](req)
      }

      def listCommunicationsTransactionTypes(options: FiltrableQueryOptions): AvataxCollectionCall[CommunicationsTransactionTypeModel] = {
        val uri = Uri("/api/v2/definitions/communications/transactiontypes").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CommunicationsTransactionTypeModel](req)
      }

      def listCommunicationsTSPairs(options: FiltrableQueryOptions): AvataxCollectionCall[CommunicationsTSPairModel] = {
        val uri = Uri("/api/v2/definitions/communications/tspairs").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CommunicationsTSPairModel](req)
      }

      def listCountries(options: FiltrableQueryOptions): AvataxCollectionCall[IsoCountryModel] = {
        val uri = Uri("/api/v2/definitions/countries").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[IsoCountryModel](req)
      }

      def listCoverLetters(options: FiltrableQueryOptions): AvataxCollectionCall[CoverLetterModel] = {
        val uri = Uri("/api/v2/definitions/coverletters").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CoverLetterModel](req)
      }

      def listCrossBorderCodes(country: String, hsCode: String, options: FiltrableQueryOptions): AvataxCollectionCall[HsCodeModel] = {
        val uri = Uri(s"/api/v2/definitions/crossborder/$country/$hsCode").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[HsCodeModel](req)
      }

      def listCrossBorderSections(): AvataxCollectionCall[HsCodeModel] = {
        val uri = Uri("/api/v2/definitions/crossborder/sections")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[HsCodeModel](req)
      }

      def listCurrencies(options: FiltrableQueryOptions): AvataxCollectionCall[CurrencyModel] = {
        val uri = Uri("/api/v2/definitions/currencies").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[CurrencyModel](req)
      }

      def listEntityUseCodes(options: FiltrableQueryOptions): AvataxCollectionCall[EntityUseCodeModel] = {
        val uri = Uri("/api/v2/definitions/entityusecodes")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[EntityUseCodeModel](req)
      }
      def listFilingFrequencies(options: FiltrableQueryOptions): AvataxCollectionCall[FilingFrequencyModel] = {
        val uri = Uri("/api/v2/definitions/filingfrequencies")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[FilingFrequencyModel](req)
      }
      def listJurisdictions(options: FiltrableQueryOptions): AvataxCollectionCall[JurisdictionModel] = {
        val uri = Uri("/api/v2/definitions/jurisdictions")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[JurisdictionModel](req)
      }
      def listJurisdictionsByAddress(
          line1: String,
          line2: String,
          line3: String,
          city: String,
          region: String,
          postalCode: String,
          country: String,
          options: FiltrableQueryOptions
      ): AvataxCollectionCall[JurisdictionOverrideModel] = {
        val uri = Uri(s"/api/v2/definitions/jurisdictionsnearaddress").withQuery(
          Query(
            "line1" -> line1,
            "line2" -> line2,
            "line3" -> line3,
            "city" -> city,
            "region" -> region,
            "postalCode" -> postalCode,
            country -> "country"
          )
        )
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[JurisdictionOverrideModel](req)
      }
      def listLocationQuestionsByAddress(
          line1: String,
          line2: String,
          line3: String,
          city: String,
          region: String,
          postalCode: String,
          country: String,
          latitude: BigDecimal,
          longitude: BigDecimal,
          options: FiltrableQueryOptions
      ): AvataxCollectionCall[LocationQuestionModel] = {
        val uri = Uri(s"/api/v2/definitions/locationquestions").withQuery(
          Query(
            "line1" -> line1,
            "line2" -> line2,
            "line3" -> line3,
            "city" -> city,
            "region" -> region,
            "postalCode" -> postalCode,
            country -> "country",
            "latitude" -> latitude.toString,
            "longitude" -> longitude.toString
          )
        )

        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[LocationQuestionModel](req)
      }
      def listLoginVerifiers(options: FiltrableQueryOptions): AvataxCollectionCall[SkyscraperStatusModel] = {
        val uri = Uri("/api/v2/definitions/filingcalendars/loginverifiers")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[SkyscraperStatusModel](req)
      }
      def listNexus(options: FiltrableQueryOptions): AvataxCollectionCall[NexusModel] = {
        val uri = Uri("/api/v2/definitions/nexus")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NexusModel](req)
      }
      def listNexusByAddress(
          line1: String,
          line2: String,
          line3: String,
          city: String,
          region: String,
          postalCode: String,
          country: String,
          options: FiltrableQueryOptions
      ): AvataxCollectionCall[NexusModel] = {
        val uri = Uri(s"/api/v2/definitions/nexus/byaddress").withQuery(
          Query(
            "line1" -> line1,
            "line2" -> line2,
            "line3" -> line3,
            "city" -> city,
            "region" -> region,
            "postalCode" -> postalCode,
            country -> "country"
          )
        )
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NexusModel](req)
      }
      def listNexusByCountry(country: String, options: FiltrableQueryOptions): AvataxCollectionCall[NexusModel] = {
        val uri = Uri(s"/api/v2/definitions/nexus/$country")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NexusModel](req)
      }
      def listNexusByCountryAndRegion(country: String, region: String, options: FiltrableQueryOptions): AvataxCollectionCall[NexusModel] = {
        val uri = Uri(s"/api/v2/definitions/nexus/$country/$region")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NexusModel](req)
      }
      def listNexusByFormCode(formCode: String, options: FiltrableQueryOptions): AvataxCollectionCall[NexusModel] = {
        val uri = Uri(s"/api/v2/definitions/nexus/byform/$formCode")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NexusModel](req)
      }
      def listNexusTaxTypeGroups(options: FiltrableQueryOptions): AvataxCollectionCall[NexusTaxTypeGroupModel] = {
        val uri = Uri(s"/api/v2/definitions/nexustaxtypegroups")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NexusTaxTypeGroupModel](req)
      }
      def listNoticeCustomerFundingOptions(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeCustomerFundingOptionModel] = {
        val uri = Uri("/api/v2/definitions/noticecustomerfundingoptions")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NoticeCustomerFundingOptionModel](req)
      }
      def listNoticeCustomerTypes(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeCustomerTypeModel] = {
        val uri = Uri("/api/v2/definitions/noticecustomertypes")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NoticeCustomerTypeModel](req)
      }
      def listNoticeFilingTypes(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeFilingTypeModel] = {
        val uri = Uri("/api/v2/definitions/noticefilingtypes")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NoticeFilingTypeModel](req)
      }
      def listNoticePriorities(options: FiltrableQueryOptions): AvataxCollectionCall[NoticePriorityModel] = {
        val uri = Uri("/api/v2/definitions/noticepriorities")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NoticePriorityModel](req)
      }
      def listNoticeReasons(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeReasonModel] = {
        val uri = Uri("/api/v2/definitions/noticereasons")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NoticeReasonModel](req)
      }
      def listNoticeResponsibilities(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeResponsibilityModel] = {
        val uri = Uri("/api/v2/definitions/noticeresponsibilities")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NoticeResponsibilityModel](req)
      }
      def listNoticeRootCauses(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeRootCauseModel] = {
        val uri = Uri("/api/v2/definitions/noticerootcauses")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NoticeRootCauseModel](req)
      }
      def listNoticeStatuses(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeStatusModel] = {
        val uri = Uri("/api/v2/definitions/noticestatuses")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NoticeStatusModel](req)
      }
      def listNoticeTypes(options: FiltrableQueryOptions): AvataxCollectionCall[NoticeTypeModel] = {
        val uri = Uri("/api/v2/definitions/noticetypes")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NoticeTypeModel](req)
      }
      def listParameters(options: FiltrableQueryOptions): AvataxCollectionCall[ParameterModel] = {
        val uri = Uri("/api/v2/definitions/parameters")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ParameterModel](req)
      }
      def listParametersByItem(
          companyCode: String,
          itemCode: String,
          options: FiltrableQueryOptions
      ): AvataxCollectionCall[ParameterModel] = {
        val uri = Uri(s"/api/v2/definitions/parameters/byitem/$companyCode/$itemCode")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ParameterModel](req)
      }
      def listPermissions(options: BasicQueryOptions): AvataxCollectionCall[String] = {
        val uri = Uri("/api/v2/definitions/permissions")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[String](req)
      }
      def listPostalCodes(options: FiltrableQueryOptions): AvataxCollectionCall[PostalCodeModel] = {
        val uri = Uri("/api/v2/definitions/postalcodes")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[PostalCodeModel](req)
      }
      def listPreferredPrograms(options: FiltrableQueryOptions): AvataxCollectionCall[PreferredProgramModel] = {
        val uri = Uri("/api/v2/definitions/preferredprograms")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[PreferredProgramModel](req)
      }
      def listProductClassificationSystems(options: FiltrableQueryOptions): AvataxCollectionCall[ProductClassificationSystemModel] = {
        val uri = Uri("/api/v2/definitions/productclassificationsystems")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ProductClassificationSystemModel](req)
      }
      def listProductClassificationSystemsByCompany(
          companyCode: String,
          options: FiltrableQueryOptions
      ): AvataxCollectionCall[ProductClassificationSystemModel] = {
        val uri = Uri(s"/api/v2/definitions/productclassificationsystems/bycompany/$companyCode")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ProductClassificationSystemModel](req)
      }
      def listRateTypesByCountry(country: String, options: FiltrableQueryOptions): AvataxCollectionCall[RateTypeModel] = {
        val uri = Uri(s"/api/v2/definitions/countries/$country/ratetypes")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[RateTypeModel](req)
      }
      def listRegions(options: FiltrableQueryOptions): AvataxCollectionCall[IsoRegionModel] = {
        val uri = Uri("/api/v2/definitions/regions")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[IsoRegionModel](req)
      }
      def listRegionsByCountry(country: String, options: FiltrableQueryOptions): AvataxCollectionCall[IsoRegionModel] = {
        val uri = Uri(s"/api/v2/definitions/countries/$country/regions")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[IsoRegionModel](req)
      }
      def listResourceFileTypes(options: FiltrableQueryOptions): AvataxCollectionCall[ResourceFileTypeModel] = {
        val uri = Uri("/api/v2/definitions/resourcefiletypes")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ResourceFileTypeModel](req)
      }
      def listSecurityRoles(options: FiltrableQueryOptions): AvataxCollectionCall[SecurityRoleModel] = {
        val uri = Uri("/api/v2/definitions/securityroles")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[SecurityRoleModel](req)
      }
      def listSubscriptionTypes(options: FiltrableQueryOptions): AvataxCollectionCall[SubscriptionTypeModel] = {
        val uri = Uri("/api/v2/definitions/subscriptiontypes")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[SubscriptionTypeModel](req)
      }
      def listTaxAuthorities(options: FiltrableQueryOptions): AvataxCollectionCall[TaxAuthorityModel] = {
        val uri = Uri("/api/v2/definitions/taxauthorities")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[TaxAuthorityModel](req)
      }
      def listTaxAuthorityForms(options: FiltrableQueryOptions): AvataxCollectionCall[TaxAuthorityFormModel] = {
        val uri = Uri("/api/v2/definitions/taxauthorityforms")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[TaxAuthorityFormModel](req)
      }
      def listTaxAuthorityTypes(options: FiltrableQueryOptions): AvataxCollectionCall[TaxAuthorityTypeModel] = {
        val uri = Uri("/api/v2/definitions/taxauthoritytypes")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[TaxAuthorityTypeModel](req)
      }
      def listTaxCodes(options: FiltrableQueryOptions): AvataxCollectionCall[TaxCodeModel] = {
        val uri = Uri("/api/v2/definitions/taxcodes")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[TaxCodeModel](req)
      }
      def listTaxCodeTypes(options: FiltrableQueryOptions): AvataxCollectionCall[TaxCodeTypesModel] = {
        val uri = Uri("/api/v2/definitions/taxcodetypes")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[TaxCodeTypesModel](req)
      }
      def listTaxForms(options: FiltrableQueryOptions): AvataxCollectionCall[FormMasterModel] = {
        val uri = Uri("/api/v2/definitions/taxforms")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[FormMasterModel](req)
      }
      def listTaxSubTypes(options: FiltrableQueryOptions): AvataxCollectionCall[TaxSubTypeModel] = {
        val uri = Uri("/api/v2/definitions/taxsubtypes")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[TaxSubTypeModel](req)
      }
      def listTaxTypeGroups(options: FiltrableQueryOptions): AvataxCollectionCall[TaxTypeGroupModel] = {
        val uri = Uri("/api/v2/definitions/taxtypegroups")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[TaxTypeGroupModel](req)
      }
      def listUnitOfMeasurement(options: FiltrableQueryOptions): AvataxCollectionCall[UomModel] = {
        val uri = Uri("/api/v2/definitions/unitofmeasurements")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[UomModel](req)
      }
    }
}
