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

package org.upstartcommerce.avataxsdk.client.api.companies

import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders

/** /api/v2/companies/$companyCode/transactions */
trait CompanyTransactionsRootApi {
  def forId(transactionCode: String): CompanyTransactionsApi

  def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[TransactionModel]
}

/** /api/v2/companies/$companyCode/transactions/$transactionCode */
trait CompanyTransactionsApi {

  def adjust(documentType: DocumentType, model: AdjustTransactionModel): AvataxSimpleCall[TransactionModel]
  def audit: AvataxSimpleCall[AuditTransactionModel]
  def auditWithType(documentType: DocumentType): AvataxSimpleCall[AuditTransactionModel]
  def changeCode(documentType: DocumentType, model: ChangeTransactionCodeModel): AvataxSimpleCall[TransactionModel]
  def commit(documentType: DocumentType, model: CommitTransactionModel): AvataxSimpleCall[TransactionModel]
  def get(documentType: DocumentType, include: Include): AvataxSimpleCall[TransactionModel]
  def getByType(documentType: DocumentType, include: Include): AvataxSimpleCall[TransactionModel]

  def lock(documentType: DocumentType, model: LockTransactionModel): AvataxSimpleCall[TransactionModel]
  def refund(
      documentType: DocumentType,
      include: Include,
      useTaxDateOverride: Boolean,
      model: RefundTransactionModel
  ): AvataxSimpleCall[TransactionModel]
  def settle(documentType: DocumentType, model: SettleTransactionModel): AvataxSimpleCall[TransactionModel]
  def uncommit(documentType: DocumentType): AvataxSimpleCall[TransactionModel]
  def verify(documentType: DocumentType, model: VerifyTransactionModel): AvataxSimpleCall[TransactionModel]
  def void(documentType: DocumentType, model: VoidTransactionModel): AvataxSimpleCall[TransactionModel]
}
