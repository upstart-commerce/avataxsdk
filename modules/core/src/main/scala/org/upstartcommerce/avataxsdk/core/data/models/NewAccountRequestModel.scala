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

final case class NewAccountRequestModel(
    offer: String,
    connectorId: Option[String] = None,
    campaign: Option[String] = None,
    leadSource: Option[String] = None,
    effectiveDate: Option[Date] = None,
    endDate: Option[Date] = None,
    accountName: String,
    website: Option[String] = None,
    paymentMethodId: Option[String] = None,
    firstName: String,
    lastName: String,
    title: Option[String] = None,
    phoneNumber: Option[String] = None,
    email: String,
    userPassword: Option[String] = None,
    welcomeEmail: Option[WelcomeEmail] = None,
    companyAddress: CompanyAddress,
    companyCode: Option[String] = None,
    properties: Option[List[String]] = None,
    acceptAvalaraTermsAndConditions: Option[Boolean] = None,
    haveReadAvalaraTermsAndConditions: Option[Boolean] = None,
    marketingContext: Option[Map[String, String]] = None
) {
  lazy val propertiesRaw: List[String] = properties.getOrElse(List.empty)
  lazy val marketingContextRaw: Map[String, String] = marketingContext.getOrElse(Map.empty)
  def withOffer(value: String): NewAccountRequestModel = copy(offer = value)
  def withConnectorId(value: String): NewAccountRequestModel = copy(connectorId = Some(value))
  def withCampaign(value: String): NewAccountRequestModel = copy(campaign = Some(value))
  def withLeadSource(value: String): NewAccountRequestModel = copy(leadSource = Some(value))
  def withEffectiveDate(value: Date): NewAccountRequestModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Date): NewAccountRequestModel = copy(endDate = Some(value))
  def withAccountName(value: String): NewAccountRequestModel = copy(accountName = value)
  def withWebsite(value: String): NewAccountRequestModel = copy(website = Some(value))
  def withPaymentMethodId(value: String): NewAccountRequestModel = copy(paymentMethodId = Some(value))
  def withFirstName(value: String): NewAccountRequestModel = copy(firstName = value)
  def withLastName(value: String): NewAccountRequestModel = copy(lastName = value)
  def withTitle(value: String): NewAccountRequestModel = copy(title = Some(value))
  def withPhoneNumber(value: String): NewAccountRequestModel = copy(phoneNumber = Some(value))
  def withEmail(value: String): NewAccountRequestModel = copy(email = value)
  def withUserPassword(value: String): NewAccountRequestModel = copy(userPassword = Some(value))
  def withWelcomeEmail(value: WelcomeEmail): NewAccountRequestModel = copy(welcomeEmail = Some(value))
  def withCompanyAddress(value: CompanyAddress): NewAccountRequestModel = copy(companyAddress = value)
  def withCompanyCode(value: String): NewAccountRequestModel = copy(companyCode = Some(value))
  def withProperties(value: List[String]): NewAccountRequestModel = copy(properties = Some(value))
  def withAcceptAvalaraTermsAndConditions(value: Boolean): NewAccountRequestModel = copy(acceptAvalaraTermsAndConditions = Some(value))
  def withHaveReadAvalaraTermsAndConditions(value: Boolean): NewAccountRequestModel = copy(haveReadAvalaraTermsAndConditions = Some(value))
  def withMarketingContext(value: Map[String, String]): NewAccountRequestModel = copy(marketingContext = Some(value))
}
