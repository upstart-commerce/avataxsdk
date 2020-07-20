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

final case class FundingStatusModel(
    requestId: Option[Long] = None,
    subledgerProfileID: Option[Int] = None,
    companyID: Option[String] = None,
    domain: Option[String] = None,
    recipient: Option[String] = None,
    sender: Option[String] = None,
    documentKey: Option[String] = None,
    documentType: Option[String] = None,
    documentName: Option[String] = None,
    methodReturn: Option[FundingESignMethodReturn] = None,
    status: Option[String] = None,
    errorMessage: Option[String] = None,
    lastPolled: Option[Date] = None,
    lastSigned: Option[Date] = None,
    lastActivated: Option[Date] = None,
    templateRequestId: Option[Long] = None
) {

  def withRequestId(value: Long): FundingStatusModel = copy(requestId = Some(value))
  def withSubledgerProfileID(value: Int): FundingStatusModel = copy(subledgerProfileID = Some(value))
  def withCompanyID(value: String): FundingStatusModel = copy(companyID = Some(value))
  def withDomain(value: String): FundingStatusModel = copy(domain = Some(value))
  def withRecipient(value: String): FundingStatusModel = copy(recipient = Some(value))
  def withSender(value: String): FundingStatusModel = copy(sender = Some(value))
  def withDocumentKey(value: String): FundingStatusModel = copy(documentKey = Some(value))
  def withDocumentType(value: String): FundingStatusModel = copy(documentType = Some(value))
  def withDocumentName(value: String): FundingStatusModel = copy(documentName = Some(value))
  def withMethodReturn(value: FundingESignMethodReturn): FundingStatusModel = copy(methodReturn = Some(value))
  def withStatus(value: String): FundingStatusModel = copy(status = Some(value))
  def withErrorMessage(value: String): FundingStatusModel = copy(errorMessage = Some(value))
  def withLastPolled(value: Date): FundingStatusModel = copy(lastPolled = Some(value))
  def withLastSigned(value: Date): FundingStatusModel = copy(lastSigned = Some(value))
  def withLastActivated(value: Date): FundingStatusModel = copy(lastActivated = Some(value))
  def withTemplateRequestId(value: Long): FundingStatusModel = copy(templateRequestId = Some(value))
}
