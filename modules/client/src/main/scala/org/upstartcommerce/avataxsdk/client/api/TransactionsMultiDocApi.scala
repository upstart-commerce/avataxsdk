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

package org.upstartcommerce.avataxsdk.client.api

import org.upstartcommerce.avataxsdk.client._

import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._

/** /api/v2/transactions */
trait TransactionsRootApi {
  def forTransactionId(transactionId: Long): TransactionsApi
  def forMultiDocTransId(multiDocTransId: Long): TransactionsMultiDocApi

  def bulkLock(model: BulkLockTransactionModel): AvataxSimpleCall[BulkLockTransactionResult]
  def createOrAdjustTransaction(include: Include, model: CreateOrAdjustTransactionModel): AvataxSimpleCall[TransactionModel]
  def createTransaction(include: Include, model: CreateTransactionModel): AvataxSimpleCall[TransactionModel]

  def adjust(code: String, `type`: DocumentType, include: Include, model: AdjustMultiDocumentModel): AvataxSimpleCall[MultiDocumentModel]
  def audit(code: String, `type`: DocumentType): AvataxSimpleCall[AuditMultiDocumentModel]
  def commit(model: CommitMultiDocumentModel): AvataxSimpleCall[MultiDocumentModel]
  def create(include: Include, model: CreateMultiDocumentModel): AvataxSimpleCall[MultiDocumentModel]
  def getByCodeAndType(code: String, `type`: DocumentType, include: Include): AvataxSimpleCall[MultiDocumentModel]
  def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[MultiDocumentModel]
  def refund(code: String, `type`: DocumentType, include: Include, model: RefundTransactionModel): AvataxSimpleCall[MultiDocumentModel]
  def verify(model: VerifyMultiDocumentModel): AvataxSimpleCall[MultiDocumentModel]
  def void(code: String, `type`: DocumentType, model: VoidTransactionModel): AvataxSimpleCall[MultiDocumentModel]
}

/** /api/v2/transactions/multidocument/$multiDocTransId */
trait TransactionsMultiDocApi {
  def get(include: Include): AvataxSimpleCall[MultiDocumentModel]
}

/** /api/v2/transactions/$transId */
trait TransactionsApi {
  def get(include: Include): AvataxSimpleCall[TransactionModel]
}
