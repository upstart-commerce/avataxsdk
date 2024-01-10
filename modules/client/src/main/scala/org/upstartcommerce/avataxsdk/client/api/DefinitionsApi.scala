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
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._

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
