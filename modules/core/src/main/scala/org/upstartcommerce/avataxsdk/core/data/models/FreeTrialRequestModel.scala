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

final case class FreeTrialRequestModel(
    firstName: String,
    lastName: String,
    email: String,
    company: String,
    phone: String,
    campaign: Option[String] = None,
    companyAddress: CompanyAddress,
    website: Option[String] = None,
    haveReadAvalaraTermsAndConditions: Boolean,
    acceptAvalaraTermsAndConditions: Boolean
) {

  def withFirstName(value: String): FreeTrialRequestModel = copy(firstName = value)
  def withLastName(value: String): FreeTrialRequestModel = copy(lastName = value)
  def withEmail(value: String): FreeTrialRequestModel = copy(email = value)
  def withCompany(value: String): FreeTrialRequestModel = copy(company = value)
  def withPhone(value: String): FreeTrialRequestModel = copy(phone = value)
  def withCampaign(value: String): FreeTrialRequestModel = copy(campaign = Some(value))
  def withCompanyAddress(value: CompanyAddress): FreeTrialRequestModel = copy(companyAddress = value)
  def withWebsite(value: String): FreeTrialRequestModel = copy(website = Some(value))
  def withHaveReadAvalaraTermsAndConditions(value: Boolean): FreeTrialRequestModel = copy(haveReadAvalaraTermsAndConditions = value)
  def withAcceptAvalaraTermsAndConditions(value: Boolean): FreeTrialRequestModel = copy(acceptAvalaraTermsAndConditions = value)
}
