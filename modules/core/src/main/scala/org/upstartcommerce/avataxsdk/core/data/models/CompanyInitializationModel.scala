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

final case class CompanyInitializationModel(
    name: String,
    companyCode: String,
    vatRegistrationId: Option[String] = None,
    taxpayerIdNumber: Option[String] = None,
    line1: String,
    line2: Option[String] = None,
    line3: Option[String] = None,
    city: String,
    region: String,
    postalCode: String,
    country: String,
    firstName: String,
    lastName: String,
    title: Option[String] = None,
    email: Option[String] = None,
    phoneNumber: String,
    mobileNumber: Option[String] = None,
    faxNumber: Option[String] = None,
    parentCompanyId: Option[Int] = None
) {

  def withName(value: String): CompanyInitializationModel = copy(name = value)
  def withCompanyCode(value: String): CompanyInitializationModel = copy(companyCode = value)
  def withVatRegistrationId(value: String): CompanyInitializationModel = copy(vatRegistrationId = Some(value))
  def withTaxpayerIdNumber(value: String): CompanyInitializationModel = copy(taxpayerIdNumber = Some(value))
  def withLine1(value: String): CompanyInitializationModel = copy(line1 = value)
  def withLine2(value: String): CompanyInitializationModel = copy(line2 = Some(value))
  def withLine3(value: String): CompanyInitializationModel = copy(line3 = Some(value))
  def withCity(value: String): CompanyInitializationModel = copy(city = value)
  def withRegion(value: String): CompanyInitializationModel = copy(region = value)
  def withPostalCode(value: String): CompanyInitializationModel = copy(postalCode = value)
  def withCountry(value: String): CompanyInitializationModel = copy(country = value)
  def withFirstName(value: String): CompanyInitializationModel = copy(firstName = value)
  def withLastName(value: String): CompanyInitializationModel = copy(lastName = value)
  def withTitle(value: String): CompanyInitializationModel = copy(title = Some(value))
  def withEmail(value: String): CompanyInitializationModel = copy(email = Some(value))
  def withPhoneNumber(value: String): CompanyInitializationModel = copy(phoneNumber = value)
  def withMobileNumber(value: String): CompanyInitializationModel = copy(mobileNumber = Some(value))
  def withFaxNumber(value: String): CompanyInitializationModel = copy(faxNumber = Some(value))
  def withParentCompanyId(value: Int): CompanyInitializationModel = copy(parentCompanyId = Some(value))
}
