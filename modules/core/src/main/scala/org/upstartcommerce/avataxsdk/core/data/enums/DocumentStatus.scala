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

sealed trait DocumentStatus
object DocumentStatus {
  case object Temporary extends DocumentStatus
  case object Saved extends DocumentStatus
  case object Posted extends DocumentStatus
  case object Committed extends DocumentStatus
  case object Cancelled extends DocumentStatus
  case object Adjusted extends DocumentStatus

  @deprecated("based on sdk", "unknown")
  case object Queued extends DocumentStatus

  case object PendingApproval extends DocumentStatus

  @deprecated("based on sdk", "unknown")
  case object Any extends DocumentStatus

}
