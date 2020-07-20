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

final case class ErrorDetail(
    code: Option[ErrorCodeId] = None,
    number: Option[Int] = None,
    message: Option[String] = None,
    description: Option[String] = None,
    faultCode: Option[String] = None,
    helpLink: Option[String] = None,
    refersTo: Option[String] = None,
    severity: Option[SeverityLevel] = None
) {

  def withCode(value: ErrorCodeId): ErrorDetail = copy(code = Some(value))
  def withNumber(value: Int): ErrorDetail = copy(number = Some(value))
  def withMessage(value: String): ErrorDetail = copy(message = Some(value))
  def withDescription(value: String): ErrorDetail = copy(description = Some(value))
  def withFaultCode(value: String): ErrorDetail = copy(faultCode = Some(value))
  def withHelpLink(value: String): ErrorDetail = copy(helpLink = Some(value))
  def withRefersTo(value: String): ErrorDetail = copy(refersTo = Some(value))
  def withSeverity(value: SeverityLevel): ErrorDetail = copy(severity = Some(value))
}
