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

sealed trait BatchType
object BatchType {
  case object AvaCertUpdate extends BatchType
  case object AvaCertUpdateAll extends BatchType
  case object BatchMaintenance extends BatchType
  case object CompanyLocationImport extends BatchType
  case object DocumentImport extends BatchType
  case object ExemptCertImport extends BatchType
  case object ItemImport extends BatchType
  case object SalesAuditExport extends BatchType
  case object SstpTestDeckImport extends BatchType
  case object TaxRuleImport extends BatchType
  case object TransactionImport extends BatchType
  case object UPCBulkImport extends BatchType
  case object UPCValidationImport extends BatchType
}
