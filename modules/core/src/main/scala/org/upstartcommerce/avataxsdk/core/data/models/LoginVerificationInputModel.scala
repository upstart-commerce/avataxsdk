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

final case class LoginVerificationInputModel(
    companyId: Int,
    accountId: Int,
    region: String,
    taxFormCode: Option[String] = None,
    username: String,
    password: String,
    additionalOptions: Option[Map[String, String]] = None,
    bulkRequestId: Option[Int] = None,
    priority: Option[Int] = None
) {
  lazy val additionalOptionsRaw: Map[String, String] = additionalOptions.getOrElse(Map.empty)
  def withCompanyId(value: Int): LoginVerificationInputModel = copy(companyId = value)
  def withAccountId(value: Int): LoginVerificationInputModel = copy(accountId = value)
  def withRegion(value: String): LoginVerificationInputModel = copy(region = value)
  def withTaxFormCode(value: String): LoginVerificationInputModel = copy(taxFormCode = Some(value))
  def withUsername(value: String): LoginVerificationInputModel = copy(username = value)
  def withPassword(value: String): LoginVerificationInputModel = copy(password = value)
  def withAdditionalOptions(value: Map[String, String]): LoginVerificationInputModel = copy(additionalOptions = Some(value))
  def withBulkRequestId(value: Int): LoginVerificationInputModel = copy(bulkRequestId = Some(value))
  def withPriority(value: Int): LoginVerificationInputModel = copy(priority = Some(value))
}
