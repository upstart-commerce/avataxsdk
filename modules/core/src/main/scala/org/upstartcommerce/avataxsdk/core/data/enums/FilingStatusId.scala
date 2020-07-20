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

package org.upstartcommerce.avataxsdk.core.data.enums

sealed trait FilingStatusId
object FilingStatusId {
  case object PendingApproval extends FilingStatusId
  case object Dirty extends FilingStatusId
  case object ApprovedToFile extends FilingStatusId
  case object PendingFiling extends FilingStatusId
  case object PendingFilingOnBehalf extends FilingStatusId
  case object Filed extends FilingStatusId
  case object FiledOnBehalf extends FilingStatusId
  case object ReturnAccepted extends FilingStatusId
  case object ReturnAcceptedOnBehalf extends FilingStatusId
  case object PaymentRemitted extends FilingStatusId
  case object Voided extends FilingStatusId
  case object PendingReturn extends FilingStatusId
  case object PendingReturnOnBehalf extends FilingStatusId
  case object DoNotFile extends FilingStatusId
  case object ReturnRejected extends FilingStatusId
  case object ReturnRejectedOnBehalf extends FilingStatusId
  case object ApprovedToFileOnBehalf extends FilingStatusId
}
