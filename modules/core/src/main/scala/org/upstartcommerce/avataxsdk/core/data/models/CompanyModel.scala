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

final case class CompanyModel(
    id: Int,
    accountId: Int,
    parentCompanyId: Option[Int] = None,
    sstPid: Option[String] = None,
    companyCode: String,
    name: String,
    isDefault: Option[Boolean] = None,
    defaultLocationId: Option[Int] = None,
    isActive: Option[Boolean] = None,
    taxpayerIdNumber: Option[String] = None,
    hasProfile: Option[Boolean] = None,
    isReportingEntity: Option[Boolean] = None,
    sstEffectiveDate: Option[Date] = None,
    defaultCountry: String,
    baseCurrencyCode: Option[String] = None,
    roundingLevelId: Option[RoundingLevelId] = None,
    warningsEnabled: Option[Boolean] = None,
    isTest: Option[Boolean] = None,
    taxDependencyLevelId: Option[TaxDependencyLevelId] = None,
    inProgress: Option[Boolean] = None,
    businessIdentificationNo: Option[String] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None,
    contacts: Option[List[ContactModel]] = None,
    items: Option[List[ItemModel]] = None,
    locations: Option[List[LocationModel]] = None,
    nexus: Option[List[NexusModel]] = None,
    settings: Option[List[SettingModel]] = None,
    taxCodes: Option[List[TaxCodeModel]] = None,
    taxRules: Option[List[TaxRuleModel]] = None,
    upcs: Option[List[UPCModel]] = None,
    exemptCerts: Option[List[EcmsModel]] = None,
    mossId: Option[String] = None,
    mossCountry: Option[String] = None
) {
  lazy val contactsRaw: List[ContactModel] = contacts.getOrElse(List.empty)
  lazy val itemsRaw: List[ItemModel] = items.getOrElse(List.empty)
  lazy val locationsRaw: List[LocationModel] = locations.getOrElse(List.empty)
  lazy val nexusRaw: List[NexusModel] = nexus.getOrElse(List.empty)
  lazy val settingsRaw: List[SettingModel] = settings.getOrElse(List.empty)
  lazy val taxCodesRaw: List[TaxCodeModel] = taxCodes.getOrElse(List.empty)
  lazy val taxRulesRaw: List[TaxRuleModel] = taxRules.getOrElse(List.empty)
  lazy val upcsRaw: List[UPCModel] = upcs.getOrElse(List.empty)
  lazy val exemptCertsRaw: List[EcmsModel] = exemptCerts.getOrElse(List.empty)
  def withId(value: Int): CompanyModel = copy(id = value)
  def withAccountId(value: Int): CompanyModel = copy(accountId = value)
  def withParentCompanyId(value: Int): CompanyModel = copy(parentCompanyId = Some(value))
  def withSstPid(value: String): CompanyModel = copy(sstPid = Some(value))
  def withCompanyCode(value: String): CompanyModel = copy(companyCode = value)
  def withName(value: String): CompanyModel = copy(name = value)
  def withIsDefault(value: Boolean): CompanyModel = copy(isDefault = Some(value))
  def withDefaultLocationId(value: Int): CompanyModel = copy(defaultLocationId = Some(value))
  def withIsActive(value: Boolean): CompanyModel = copy(isActive = Some(value))
  def withTaxpayerIdNumber(value: String): CompanyModel = copy(taxpayerIdNumber = Some(value))
  def withHasProfile(value: Boolean): CompanyModel = copy(hasProfile = Some(value))
  def withIsReportingEntity(value: Boolean): CompanyModel = copy(isReportingEntity = Some(value))
  def withSstEffectiveDate(value: Date): CompanyModel = copy(sstEffectiveDate = Some(value))
  def withDefaultCountry(value: String): CompanyModel = copy(defaultCountry = value)
  def withBaseCurrencyCode(value: String): CompanyModel = copy(baseCurrencyCode = Some(value))
  def withRoundingLevelId(value: RoundingLevelId): CompanyModel = copy(roundingLevelId = Some(value))
  def withWarningsEnabled(value: Boolean): CompanyModel = copy(warningsEnabled = Some(value))
  def withIsTest(value: Boolean): CompanyModel = copy(isTest = Some(value))
  def withTaxDependencyLevelId(value: TaxDependencyLevelId): CompanyModel = copy(taxDependencyLevelId = Some(value))
  def withInProgress(value: Boolean): CompanyModel = copy(inProgress = Some(value))
  def withBusinessIdentificationNo(value: String): CompanyModel = copy(businessIdentificationNo = Some(value))
  def withCreatedDate(value: Date): CompanyModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): CompanyModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): CompanyModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): CompanyModel = copy(modifiedUserId = Some(value))
  def withContacts(value: List[ContactModel]): CompanyModel = copy(contacts = Some(value))
  def withItems(value: List[ItemModel]): CompanyModel = copy(items = Some(value))
  def withLocations(value: List[LocationModel]): CompanyModel = copy(locations = Some(value))
  def withNexus(value: List[NexusModel]): CompanyModel = copy(nexus = Some(value))
  def withSettings(value: List[SettingModel]): CompanyModel = copy(settings = Some(value))
  def withTaxCodes(value: List[TaxCodeModel]): CompanyModel = copy(taxCodes = Some(value))
  def withTaxRules(value: List[TaxRuleModel]): CompanyModel = copy(taxRules = Some(value))
  def withUpcs(value: List[UPCModel]): CompanyModel = copy(upcs = Some(value))
  def withExemptCerts(value: List[EcmsModel]): CompanyModel = copy(exemptCerts = Some(value))
  def withMossId(value: String): CompanyModel = copy(mossId = Some(value))
  def withMossCountry(value: String): CompanyModel = copy(mossCountry = Some(value))
}
