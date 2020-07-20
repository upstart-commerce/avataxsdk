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

final case class ContactModel(
    id: Int,
    companyId: Option[Int] = None,
    contactCode: String,
    firstName: Option[String] = None,
    middleName: Option[String] = None,
    lastName: Option[String] = None,
    title: Option[String] = None,
    line1: Option[String] = None,
    line2: Option[String] = None,
    line3: Option[String] = None,
    city: Option[String] = None,
    region: Option[String] = None,
    postalCode: Option[String] = None,
    country: Option[String] = None,
    email: Option[String] = None,
    phone: Option[String] = None,
    mobile: Option[String] = None,
    fax: Option[String] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None
) {

  def withId(value: Int): ContactModel = copy(id = value)
  def withCompanyId(value: Int): ContactModel = copy(companyId = Some(value))
  def withContactCode(value: String): ContactModel = copy(contactCode = value)
  def withFirstName(value: String): ContactModel = copy(firstName = Some(value))
  def withMiddleName(value: String): ContactModel = copy(middleName = Some(value))
  def withLastName(value: String): ContactModel = copy(lastName = Some(value))
  def withTitle(value: String): ContactModel = copy(title = Some(value))
  def withLine1(value: String): ContactModel = copy(line1 = Some(value))
  def withLine2(value: String): ContactModel = copy(line2 = Some(value))
  def withLine3(value: String): ContactModel = copy(line3 = Some(value))
  def withCity(value: String): ContactModel = copy(city = Some(value))
  def withRegion(value: String): ContactModel = copy(region = Some(value))
  def withPostalCode(value: String): ContactModel = copy(postalCode = Some(value))
  def withCountry(value: String): ContactModel = copy(country = Some(value))
  def withEmail(value: String): ContactModel = copy(email = Some(value))
  def withPhone(value: String): ContactModel = copy(phone = Some(value))
  def withMobile(value: String): ContactModel = copy(mobile = Some(value))
  def withFax(value: String): ContactModel = copy(fax = Some(value))
  def withCreatedDate(value: Date): ContactModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): ContactModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): ContactModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): ContactModel = copy(modifiedUserId = Some(value))
}
