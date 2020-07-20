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

final case class PingResultModel(
    version: Option[String] = None,
    authenticated: Option[Boolean] = None,
    authenticationType: Option[AuthenticationTypeId] = None,
    authenticatedUserName: Option[String] = None,
    authenticatedUserId: Option[Int] = None,
    authenticatedAccountId: Option[Int] = None,
    crmid: Option[String] = None
) {

  def withVersion(value: String): PingResultModel = copy(version = Some(value))
  def withAuthenticated(value: Boolean): PingResultModel = copy(authenticated = Some(value))
  def withAuthenticationType(value: AuthenticationTypeId): PingResultModel = copy(authenticationType = Some(value))
  def withAuthenticatedUserName(value: String): PingResultModel = copy(authenticatedUserName = Some(value))
  def withAuthenticatedUserId(value: Int): PingResultModel = copy(authenticatedUserId = Some(value))
  def withAuthenticatedAccountId(value: Int): PingResultModel = copy(authenticatedAccountId = Some(value))
  def withCrmid(value: String): PingResultModel = copy(crmid = Some(value))
}
