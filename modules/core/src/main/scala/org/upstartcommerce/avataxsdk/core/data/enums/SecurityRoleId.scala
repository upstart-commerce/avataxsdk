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

sealed trait SecurityRoleId
object SecurityRoleId {
  case object NoAccess extends SecurityRoleId
  case object SiteAdmin extends SecurityRoleId
  case object AccountOperator extends SecurityRoleId
  case object AccountAdmin extends SecurityRoleId
  case object AccountUser extends SecurityRoleId
  case object SystemAdmin extends SecurityRoleId
  case object Registrar extends SecurityRoleId
  case object CSPTester extends SecurityRoleId
  case object CSPAdmin extends SecurityRoleId
  case object SystemOperator extends SecurityRoleId
  case object TechnicalSupportUser extends SecurityRoleId
  case object TechnicalSupportAdmin extends SecurityRoleId
  case object TreasuryUser extends SecurityRoleId
  case object TreasuryAdmin extends SecurityRoleId
  case object ComplianceUser extends SecurityRoleId
  case object ComplianceAdmin extends SecurityRoleId
  case object ProStoresOperator extends SecurityRoleId
  case object CompanyUser extends SecurityRoleId
  case object CompanyAdmin extends SecurityRoleId
  case object ComplianceTempUser extends SecurityRoleId
  case object ComplianceRootUser extends SecurityRoleId
  case object ComplianceOperator extends SecurityRoleId
  case object SSTAdmin extends SecurityRoleId
}
