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

final case class CertExpressInvitationModel(
    id: Option[Int] = None,
    companyId: Option[Int] = None,
    recipient: Option[String] = None,
    customerCode: Option[String] = None,
    customer: Option[CustomerModel] = None,
    coverLetter: Option[CoverLetterModel] = None,
    emailStatus: Option[String] = None,
    coverLettersOnly: Option[Boolean] = None,
    exposureZones: Option[List[Int]] = None,
    exemptReasons: Option[List[Int]] = None,
    deliveryMethod: Option[CertificateRequestDeliveryMethod] = None,
    message: Option[String] = None,
    date: Option[Date] = None,
    requestLink: Option[String] = None
) {
  lazy val exposureZonesRaw: List[Int] = exposureZones.getOrElse(List.empty)
  lazy val exemptReasonsRaw: List[Int] = exemptReasons.getOrElse(List.empty)
  def withId(value: Int): CertExpressInvitationModel = copy(id = Some(value))
  def withCompanyId(value: Int): CertExpressInvitationModel = copy(companyId = Some(value))
  def withRecipient(value: String): CertExpressInvitationModel = copy(recipient = Some(value))
  def withCustomerCode(value: String): CertExpressInvitationModel = copy(customerCode = Some(value))
  def withCustomer(value: CustomerModel): CertExpressInvitationModel = copy(customer = Some(value))
  def withCoverLetter(value: CoverLetterModel): CertExpressInvitationModel = copy(coverLetter = Some(value))
  def withEmailStatus(value: String): CertExpressInvitationModel = copy(emailStatus = Some(value))
  def withCoverLettersOnly(value: Boolean): CertExpressInvitationModel = copy(coverLettersOnly = Some(value))
  def withExposureZones(value: List[Int]): CertExpressInvitationModel = copy(exposureZones = Some(value))
  def withExemptReasons(value: List[Int]): CertExpressInvitationModel = copy(exemptReasons = Some(value))
  def withDeliveryMethod(value: CertificateRequestDeliveryMethod): CertExpressInvitationModel = copy(deliveryMethod = Some(value))
  def withMessage(value: String): CertExpressInvitationModel = copy(message = Some(value))
  def withDate(value: Date): CertExpressInvitationModel = copy(date = Some(value))
  def withRequestLink(value: String): CertExpressInvitationModel = copy(requestLink = Some(value))
}
