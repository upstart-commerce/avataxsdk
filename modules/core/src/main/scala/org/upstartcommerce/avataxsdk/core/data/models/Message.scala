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

final case class Message(
    details: Option[String] = None,
    helpLink: Option[String] = None,
    name: Option[String] = None,
    refersTo: Option[String] = None,
    severity: Option[String] = None,
    source: Option[String] = None,
    summary: Option[String] = None
) {

  def withDetails(value: String): Message = copy(details = Some(value))
  def withHelpLink(value: String): Message = copy(helpLink = Some(value))
  def withName(value: String): Message = copy(name = Some(value))
  def withRefersTo(value: String): Message = copy(refersTo = Some(value))
  def withSeverity(value: String): Message = copy(severity = Some(value))
  def withSource(value: String): Message = copy(source = Some(value))
  def withSummary(value: String): Message = copy(summary = Some(value))
}
