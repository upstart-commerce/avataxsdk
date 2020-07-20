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

final case class EcmsModel(
    exemptCertId: Int,
    companyId: Int,
    customerCode: String,
    customerName: Option[String] = None,
    address1: Option[String] = None,
    address2: Option[String] = None,
    address3: Option[String] = None,
    city: Option[String] = None,
    region: String,
    postalCode: Option[String] = None,
    country: Option[String] = None,
    exemptCertTypeId: ExemptCertTypeId,
    documentRefNo: Option[String] = None,
    businessTypeId: Int,
    businessTypeOtherDescription: Option[String] = None,
    exemptReasonId: Option[String] = None,
    exemptReasonOtherDescription: Option[String] = None,
    effectiveDate: Option[Date] = None,
    regionsApplicable: String,
    exemptCertStatusId: ExemptCertStatusId,
    createdDate: Option[Date] = None,
    lastTransactionDate: Option[Date] = None,
    expiryDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None,
    countryIssued: Option[String] = None,
    avaCertId: Option[String] = None,
    exemptCertReviewStatusId: Option[ExemptCertReviewStatusId] = None,
    details: Option[List[EcmsDetailModel]] = None
) {
  lazy val detailsRaw: List[EcmsDetailModel] = details.getOrElse(List.empty)
  def withExemptCertId(value: Int): EcmsModel = copy(exemptCertId = value)
  def withCompanyId(value: Int): EcmsModel = copy(companyId = value)
  def withCustomerCode(value: String): EcmsModel = copy(customerCode = value)
  def withCustomerName(value: String): EcmsModel = copy(customerName = Some(value))
  def withAddress1(value: String): EcmsModel = copy(address1 = Some(value))
  def withAddress2(value: String): EcmsModel = copy(address2 = Some(value))
  def withAddress3(value: String): EcmsModel = copy(address3 = Some(value))
  def withCity(value: String): EcmsModel = copy(city = Some(value))
  def withRegion(value: String): EcmsModel = copy(region = value)
  def withPostalCode(value: String): EcmsModel = copy(postalCode = Some(value))
  def withCountry(value: String): EcmsModel = copy(country = Some(value))
  def withExemptCertTypeId(value: ExemptCertTypeId): EcmsModel = copy(exemptCertTypeId = value)
  def withDocumentRefNo(value: String): EcmsModel = copy(documentRefNo = Some(value))
  def withBusinessTypeId(value: Int): EcmsModel = copy(businessTypeId = value)
  def withBusinessTypeOtherDescription(value: String): EcmsModel = copy(businessTypeOtherDescription = Some(value))
  def withExemptReasonId(value: String): EcmsModel = copy(exemptReasonId = Some(value))
  def withExemptReasonOtherDescription(value: String): EcmsModel = copy(exemptReasonOtherDescription = Some(value))
  def withEffectiveDate(value: Date): EcmsModel = copy(effectiveDate = Some(value))
  def withRegionsApplicable(value: String): EcmsModel = copy(regionsApplicable = value)
  def withExemptCertStatusId(value: ExemptCertStatusId): EcmsModel = copy(exemptCertStatusId = value)
  def withCreatedDate(value: Date): EcmsModel = copy(createdDate = Some(value))
  def withLastTransactionDate(value: Date): EcmsModel = copy(lastTransactionDate = Some(value))
  def withExpiryDate(value: Date): EcmsModel = copy(expiryDate = Some(value))
  def withCreatedUserId(value: Int): EcmsModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): EcmsModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): EcmsModel = copy(modifiedUserId = Some(value))
  def withCountryIssued(value: String): EcmsModel = copy(countryIssued = Some(value))
  def withAvaCertId(value: String): EcmsModel = copy(avaCertId = Some(value))
  def withExemptCertReviewStatusId(value: ExemptCertReviewStatusId): EcmsModel = copy(exemptCertReviewStatusId = Some(value))
  def withDetails(value: List[EcmsDetailModel]): EcmsModel = copy(details = Some(value))
}
