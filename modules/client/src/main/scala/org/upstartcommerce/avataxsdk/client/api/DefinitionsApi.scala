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

trait DefinitionsRootApi[F[_], S[_]] {
  def getCrossBorderCode(country: String, hsCode: String): AvataxCollectionCall[F, S, HsCodeModel]
  def getLoginVerifierByForm(form: String, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, SkyscraperStatusModel]
  def listAvaFileForms(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, AvaFileFormModel]
  def listCertificateAttributes(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, CertificateAttributeModel]
  def listCertificateExemptReasons(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, ExemptionReasonModel]
  def listCertificatesExposureZones(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, ExposureZoneModel]
  def listCommunicationsServiceTypes(id: Int, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, CommunicationsTSPairModel]
  def listCommunicationsTransactionTypes(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, CommunicationsTransactionTypeModel]
  def listCommunicationsTSPairs(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, CommunicationsTSPairModel]
  def listCountries(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, IsoCountryModel]
  def listCoverLetters(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, CoverLetterModel]
  def listCrossBorderCodes(country: String, hsCode: String, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, HsCodeModel]
  def listCrossBorderSections(): AvataxCollectionCall[F, S, HsCodeModel]
  def listCurrencies(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, CurrencyModel]
  def listEntityUseCodes(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, EntityUseCodeModel]
  def listFilingFrequencies(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, FilingFrequencyModel]
  def listJurisdictions(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, JurisdictionModel]
  def listJurisdictionsByAddress(
      line1: String,
      line2: String,
      line3: String,
      city: String,
      region: String,
      postalCode: String,
      country: String,
      options: FiltrableQueryOptions
  ): AvataxCollectionCall[F, S, JurisdictionOverrideModel]
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
  ): AvataxCollectionCall[F, S, LocationQuestionModel]
  def listLoginVerifiers(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, SkyscraperStatusModel]
  def listNexus(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NexusModel]
  def listNexusByAddress(
      line1: String,
      line2: String,
      line3: String,
      city: String,
      region: String,
      postalCode: String,
      country: String,
      options: FiltrableQueryOptions
  ): AvataxCollectionCall[F, S, NexusModel]
  def listNexusByCountry(country: String, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NexusModel]
  def listNexusByCountryAndRegion(country: String, region: String, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NexusModel]
  def listNexusByFormCode(formCode: String, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NexusModel]
  def listNexusTaxTypeGroups(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NexusTaxTypeGroupModel]
  def listNoticeCustomerFundingOptions(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NoticeCustomerFundingOptionModel]
  def listNoticeCustomerTypes(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NoticeCustomerTypeModel]
  def listNoticeFilingTypes(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NoticeFilingTypeModel]
  def listNoticePriorities(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NoticePriorityModel]
  def listNoticeReasons(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NoticeReasonModel]
  def listNoticeResponsibilities(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NoticeResponsibilityModel]
  def listNoticeRootCauses(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NoticeRootCauseModel]
  def listNoticeStatuses(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NoticeStatusModel]
  def listNoticeTypes(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NoticeTypeModel]
  def listParameters(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, ParameterModel]
  def listParametersByItem(
      companyCode: String,
      itemCode: String,
      options: FiltrableQueryOptions
  ): AvataxCollectionCall[F, S, ParameterModel]
  def listPermissions(options: BasicQueryOptions): AvataxCollectionCall[F, S, String]
  def listPostalCodes(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, PostalCodeModel]
  def listPreferredPrograms(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, PreferredProgramModel]
  def listProductClassificationSystems(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, ProductClassificationSystemModel]
  def listProductClassificationSystemsByCompany(
      companyCode: String,
      options: FiltrableQueryOptions
  ): AvataxCollectionCall[F, S, ProductClassificationSystemModel]
  def listRateTypesByCountry(country: String, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, RateTypeModel]
  def listRegions(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, IsoRegionModel]
  def listRegionsByCountry(country: String, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, IsoRegionModel]
  def listResourceFileTypes(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, ResourceFileTypeModel]
  def listSecurityRoles(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, SecurityRoleModel]
  def listSubscriptionTypes(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, SubscriptionTypeModel]
  def listTaxAuthorities(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, TaxAuthorityModel]
  def listTaxAuthorityForms(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, TaxAuthorityFormModel]
  def listTaxAuthorityTypes(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, TaxAuthorityTypeModel]
  def listTaxCodes(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, TaxCodeModel]
  def listTaxCodeTypes(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, TaxCodeTypesModel]
  def listTaxForms(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, FormMasterModel]
  def listTaxSubTypes(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, TaxSubTypeModel]
  def listTaxTypeGroups(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, TaxTypeGroupModel]
  def listUnitOfMeasurement(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, UomModel]
}
