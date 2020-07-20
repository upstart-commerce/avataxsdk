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

package org.upstartcommerce.avataxsdk.json

import java.sql.Date

import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._
import play.api.libs.json._
import ai.x.play.json.Jsonx

/** defines formats for all models that are not generated (probably due to amount of columns)
  * use external derivation for now */
private[json] trait ModelFormats extends GenModelFormats {
  implicit val createMultiDocumentModelOFormat: OFormat[CreateMultiDocumentModel] = Jsonx.formatCaseClass[CreateMultiDocumentModel]
  implicit val createMultiCompanyTransactionModelOFormat: OFormat[CreateMultiCompanyTransactionModel] =
    Jsonx.formatCaseClass[CreateMultiCompanyTransactionModel]
  implicit val filingCalendarModelOFormat: OFormat[FilingCalendarModel] = Jsonx.formatCaseClass[FilingCalendarModel]
  implicit val locationModelOFormat: OFormat[LocationModel] = Jsonx.formatCaseClass[LocationModel]
  implicit val nexusModelOFormat: OFormat[NexusModel] = Jsonx.formatCaseClass[NexusModel]
  implicit val createTransactionModelOFormat: OFormat[CreateTransactionModel] = Jsonx.formatCaseClass[CreateTransactionModel]
  implicit val filingRegionModelOFormat: OFormat[FilingRegionModel] = Jsonx.formatCaseClass[FilingRegionModel]
  implicit val transactionLineDetailModelOFormat: OFormat[TransactionLineDetailModel] = Jsonx.formatCaseClass[TransactionLineDetailModel]
  implicit val noticeModelOFormat: OFormat[NoticeModel] = Jsonx.formatCaseClass[NoticeModel]
  implicit val customerModelOFormat: OFormat[CustomerModel] = Jsonx.formatCaseClass[CustomerModel]
  implicit val filingReturnModelBasicOFormat: OFormat[FilingReturnModelBasic] = Jsonx.formatCaseClass[FilingReturnModelBasic]
  implicit val formMasterModelOFormat: OFormat[FormMasterModel] = Jsonx.formatCaseClass[FormMasterModel]
  implicit val transactionLineModelOFormat: OFormat[TransactionLineModel] = Jsonx.formatCaseClass[TransactionLineModel]
  implicit val filingReturnModelOFormat: OFormat[FilingReturnModel] = Jsonx.formatCaseClass[FilingReturnModel]
  implicit val auditModelOFormat: OFormat[AuditModel] = Jsonx.formatCaseClass[AuditModel]
  implicit val ecmsModelOFormat: OFormat[EcmsModel] = Jsonx.formatCaseClass[EcmsModel]
  implicit val companyModelOFormat: OFormat[CompanyModel] = Jsonx.formatCaseClass[CompanyModel]
  implicit val transactionModelOFormat: OFormat[TransactionModel] = Jsonx.formatCaseClass[TransactionModel]
  implicit val taxRuleModelOFormat: OFormat[TaxRuleModel] = Jsonx.formatCaseClass[TaxRuleModel]
}
