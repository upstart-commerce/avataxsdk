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

final case class CreateCertExpressInvitationModel(
    recipient: Option[String] = None,
    coverLetterTitle: Option[String] = None,
    exposureZones: Option[List[Int]] = None,
    exemptReasons: Option[List[Int]] = None,
    deliveryMethod: Option[CertificateRequestDeliveryMethod] = None
) {
  lazy val exposureZonesRaw: List[Int] = exposureZones.getOrElse(List.empty)
  lazy val exemptReasonsRaw: List[Int] = exemptReasons.getOrElse(List.empty)
  def withRecipient(value: String): CreateCertExpressInvitationModel = copy(recipient = Some(value))
  def withCoverLetterTitle(value: String): CreateCertExpressInvitationModel = copy(coverLetterTitle = Some(value))
  def withExposureZones(value: List[Int]): CreateCertExpressInvitationModel = copy(exposureZones = Some(value))
  def withExemptReasons(value: List[Int]): CreateCertExpressInvitationModel = copy(exemptReasons = Some(value))
  def withDeliveryMethod(value: CertificateRequestDeliveryMethod): CreateCertExpressInvitationModel = copy(deliveryMethod = Some(value))
}
