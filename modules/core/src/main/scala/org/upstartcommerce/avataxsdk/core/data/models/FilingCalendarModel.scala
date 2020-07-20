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

final case class FilingCalendarModel(
    id: Long,
    companyId: Option[Int] = None,
    returnName: Option[String] = None,
    formCountry: Option[String] = None,
    formRegion: Option[String] = None,
    taxFormCode: Option[String] = None,
    locationCode: Option[String] = None,
    outletTypeId: Option[OutletTypeId] = None,
    paymentCurrency: Option[String] = None,
    filingFrequencyId: Option[FilingFrequencyId] = None,
    months: Option[Short] = None,
    stateRegistrationId: Option[String] = None,
    localRegistrationId: Option[String] = None,
    employerIdentificationNumber: Option[String] = None,
    line1: Option[String] = None,
    line2: Option[String] = None,
    city: Option[String] = None,
    region: Option[String] = None,
    postalCode: Option[String] = None,
    country: Option[String] = None,
    mailingAddressLine1: Option[String] = None,
    mailingAddressLine2: Option[String] = None,
    mailingAddressCity: Option[String] = None,
    mailingAddressRegion: Option[String] = None,
    mailingAddressPostalCode: Option[String] = None,
    mailingAddressCountry: Option[String] = None,
    phone: Option[String] = None,
    customerFilingInstructions: Option[String] = None,
    legalEntityName: Option[String] = None,
    effectiveDate: Option[Date] = None,
    endDate: Option[Date] = None,
    filingTypeId: Option[FilingTypeId] = None,
    eFileUsername: Option[String] = None,
    eFilePassword: Option[String] = None,
    prepayPercentage: Option[Int] = None,
    fixedPrepaymentAmount: Option[BigDecimal] = None,
    taxTypeId: MatchingTaxType,
    internalNotes: Option[String] = None,
    alSignOn: Option[String] = None,
    alAccessCode: Option[String] = None,
    meBusinessCode: Option[String] = None,
    iaBen: Option[String] = None,
    ctReg: Option[String] = None,
    other1Name: Option[String] = None,
    other1Value: Option[String] = None,
    other2Name: Option[String] = None,
    other2Value: Option[String] = None,
    other3Name: Option[String] = None,
    other3Value: Option[String] = None,
    taxAuthorityId: Option[Int] = None,
    taxAuthorityName: Option[String] = None,
    taxAuthorityType: Option[String] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None,
    settings: Option[List[CompanyReturnSettingModel]] = None
) {
  lazy val settingsRaw: List[CompanyReturnSettingModel] = settings.getOrElse(List.empty)
  def withId(value: Long): FilingCalendarModel = copy(id = value)
  def withCompanyId(value: Int): FilingCalendarModel = copy(companyId = Some(value))
  def withReturnName(value: String): FilingCalendarModel = copy(returnName = Some(value))
  def withFormCountry(value: String): FilingCalendarModel = copy(formCountry = Some(value))
  def withFormRegion(value: String): FilingCalendarModel = copy(formRegion = Some(value))
  def withTaxFormCode(value: String): FilingCalendarModel = copy(taxFormCode = Some(value))
  def withLocationCode(value: String): FilingCalendarModel = copy(locationCode = Some(value))
  def withOutletTypeId(value: OutletTypeId): FilingCalendarModel = copy(outletTypeId = Some(value))
  def withPaymentCurrency(value: String): FilingCalendarModel = copy(paymentCurrency = Some(value))
  def withFilingFrequencyId(value: FilingFrequencyId): FilingCalendarModel = copy(filingFrequencyId = Some(value))
  def withMonths(value: Short): FilingCalendarModel = copy(months = Some(value))
  def withStateRegistrationId(value: String): FilingCalendarModel = copy(stateRegistrationId = Some(value))
  def withLocalRegistrationId(value: String): FilingCalendarModel = copy(localRegistrationId = Some(value))
  def withEmployerIdentificationNumber(value: String): FilingCalendarModel = copy(employerIdentificationNumber = Some(value))
  def withLine1(value: String): FilingCalendarModel = copy(line1 = Some(value))
  def withLine2(value: String): FilingCalendarModel = copy(line2 = Some(value))
  def withCity(value: String): FilingCalendarModel = copy(city = Some(value))
  def withRegion(value: String): FilingCalendarModel = copy(region = Some(value))
  def withPostalCode(value: String): FilingCalendarModel = copy(postalCode = Some(value))
  def withCountry(value: String): FilingCalendarModel = copy(country = Some(value))
  def withMailingAddressLine1(value: String): FilingCalendarModel = copy(mailingAddressLine1 = Some(value))
  def withMailingAddressLine2(value: String): FilingCalendarModel = copy(mailingAddressLine2 = Some(value))
  def withMailingAddressCity(value: String): FilingCalendarModel = copy(mailingAddressCity = Some(value))
  def withMailingAddressRegion(value: String): FilingCalendarModel = copy(mailingAddressRegion = Some(value))
  def withMailingAddressPostalCode(value: String): FilingCalendarModel = copy(mailingAddressPostalCode = Some(value))
  def withMailingAddressCountry(value: String): FilingCalendarModel = copy(mailingAddressCountry = Some(value))
  def withPhone(value: String): FilingCalendarModel = copy(phone = Some(value))
  def withCustomerFilingInstructions(value: String): FilingCalendarModel = copy(customerFilingInstructions = Some(value))
  def withLegalEntityName(value: String): FilingCalendarModel = copy(legalEntityName = Some(value))
  def withEffectiveDate(value: Date): FilingCalendarModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Date): FilingCalendarModel = copy(endDate = Some(value))
  def withFilingTypeId(value: FilingTypeId): FilingCalendarModel = copy(filingTypeId = Some(value))
  def withEFileUsername(value: String): FilingCalendarModel = copy(eFileUsername = Some(value))
  def withEFilePassword(value: String): FilingCalendarModel = copy(eFilePassword = Some(value))
  def withPrepayPercentage(value: Int): FilingCalendarModel = copy(prepayPercentage = Some(value))
  def withFixedPrepaymentAmount(value: BigDecimal): FilingCalendarModel = copy(fixedPrepaymentAmount = Some(value))
  def withTaxTypeId(value: MatchingTaxType): FilingCalendarModel = copy(taxTypeId = value)
  def withInternalNotes(value: String): FilingCalendarModel = copy(internalNotes = Some(value))
  def withAlSignOn(value: String): FilingCalendarModel = copy(alSignOn = Some(value))
  def withAlAccessCode(value: String): FilingCalendarModel = copy(alAccessCode = Some(value))
  def withMeBusinessCode(value: String): FilingCalendarModel = copy(meBusinessCode = Some(value))
  def withIaBen(value: String): FilingCalendarModel = copy(iaBen = Some(value))
  def withCtReg(value: String): FilingCalendarModel = copy(ctReg = Some(value))
  def withOther1Name(value: String): FilingCalendarModel = copy(other1Name = Some(value))
  def withOther1Value(value: String): FilingCalendarModel = copy(other1Value = Some(value))
  def withOther2Name(value: String): FilingCalendarModel = copy(other2Name = Some(value))
  def withOther2Value(value: String): FilingCalendarModel = copy(other2Value = Some(value))
  def withOther3Name(value: String): FilingCalendarModel = copy(other3Name = Some(value))
  def withOther3Value(value: String): FilingCalendarModel = copy(other3Value = Some(value))
  def withTaxAuthorityId(value: Int): FilingCalendarModel = copy(taxAuthorityId = Some(value))
  def withTaxAuthorityName(value: String): FilingCalendarModel = copy(taxAuthorityName = Some(value))
  def withTaxAuthorityType(value: String): FilingCalendarModel = copy(taxAuthorityType = Some(value))
  def withCreatedDate(value: Date): FilingCalendarModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): FilingCalendarModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): FilingCalendarModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): FilingCalendarModel = copy(modifiedUserId = Some(value))
  def withSettings(value: List[CompanyReturnSettingModel]): FilingCalendarModel = copy(settings = Some(value))
}
