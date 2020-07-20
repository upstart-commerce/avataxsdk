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

sealed trait ErrorTargetCode
object ErrorTargetCode {
  case object Unknown extends ErrorTargetCode
  case object HttpRequest extends ErrorTargetCode
  case object HttpRequestHeaders extends ErrorTargetCode
  case object IncorrectData extends ErrorTargetCode
  case object AvaTaxApiServer extends ErrorTargetCode
  case object AvalaraIdentityServer extends ErrorTargetCode
  case object CustomerAccountSetup extends ErrorTargetCode
}
