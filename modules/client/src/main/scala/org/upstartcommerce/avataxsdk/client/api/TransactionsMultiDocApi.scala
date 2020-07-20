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

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

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

object TransactionsRootApi {
  def apply(
      requester: Requester,
      security: Option[Authorization]
  )(implicit system: ActorSystem, materializer: Materializer): TransactionsRootApi =
    new ApiRoot(requester, security) with TransactionsRootApi {
      def forTransactionId(transactionId: Long): TransactionsApi = TransactionsApi(requester, security)(transactionId)
      def forMultiDocTransId(multiDocTransId: Long): TransactionsMultiDocApi = TransactionsMultiDocApi(requester, security)(multiDocTransId)

      def bulkLock(model: BulkLockTransactionModel): AvataxSimpleCall[BulkLockTransactionResult] = {
        val uri = Uri(s"/api/v2/transactions/lock")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[BulkLockTransactionModel, BulkLockTransactionResult](req, model)
      }

      def createOrAdjustTransaction(include: Include, model: CreateOrAdjustTransactionModel): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/transactions/createoradjust").withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[CreateOrAdjustTransactionModel, TransactionModel](req, model)
      }

      def createTransaction(include: Include, model: CreateTransactionModel): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/transactions/create").withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[CreateTransactionModel, TransactionModel](req, model)
      }

      def deleteLines(include: Include, model: RemoveTransactionLineModel): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/transactions/lines/delete").withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[RemoveTransactionLineModel, TransactionModel](req, model)
      }

      def adjust(
          code: String,
          `type`: DocumentType,
          include: Include,
          model: AdjustMultiDocumentModel
      ): AvataxSimpleCall[MultiDocumentModel] = {
        val uri = Uri(s"/api/v2/transactions/multidocument/$code/type/${`type`}/adjust")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[AdjustMultiDocumentModel, MultiDocumentModel](req, model)
      }

      def audit(code: String, `type`: DocumentType): AvataxSimpleCall[AuditMultiDocumentModel] = {
        val uri = Uri(s"/api/v2/transactions/multidocument/$code/type/${`type`}/audit")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[AuditMultiDocumentModel](req)
      }

      def commit(model: CommitMultiDocumentModel): AvataxSimpleCall[MultiDocumentModel] = {
        val uri = Uri(s"/api/v2/transactions/multidocument/commit")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[CommitMultiDocumentModel, MultiDocumentModel](req, model)
      }

      def create(include: Include, model: CreateMultiDocumentModel): AvataxSimpleCall[MultiDocumentModel] = {
        val uri = Uri(s"/api/v2/transactions/multidocument").withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[CreateMultiDocumentModel, MultiDocumentModel](req, model)
      }

      def getByCodeAndType(code: String, `type`: DocumentType, include: Include): AvataxSimpleCall[MultiDocumentModel] = {
        val uri = Uri(s"/api/v2/transactions/multidocument/$code/type/${`type`}").withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[MultiDocumentModel](req)
      }

      def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[MultiDocumentModel] = {
        val uri = Uri(s"/api/v2/transactions/multidocument").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[MultiDocumentModel](req)
      }

      def refund(
          code: String,
          `type`: DocumentType,
          include: Include,
          model: RefundTransactionModel
      ): AvataxSimpleCall[MultiDocumentModel] = {
        val uri = Uri(s"/api/v2/transactions/multidocument/$code/type/${`type`}/refund").withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[RefundTransactionModel, MultiDocumentModel](req, model)
      }

      def verify(model: VerifyMultiDocumentModel): AvataxSimpleCall[MultiDocumentModel] = {
        val uri = Uri(s"/api/v2/transactions/multidocument/verify")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[VerifyMultiDocumentModel, MultiDocumentModel](req, model)
      }

      def void(code: String, `type`: DocumentType, model: VoidTransactionModel): AvataxSimpleCall[MultiDocumentModel] = {
        val uri = Uri(s"/api/v2/transactions/multidocument/$code/type/${`type`}/void")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[VoidTransactionModel, MultiDocumentModel](req, model)
      }
    }
}

/** /api/v2/transactions/multidocument/$multiDocTransId */
trait TransactionsMultiDocApi {
  def get(include: Include): AvataxSimpleCall[MultiDocumentModel]
}
object TransactionsMultiDocApi {
  def apply(requester: Requester, security: Option[Authorization])(
      multiDocTransId: Long
  )(implicit system: ActorSystem, materializer: Materializer): TransactionsMultiDocApi =
    new ApiRoot(requester, security) with TransactionsMultiDocApi {
      def get(include: Include): AvataxSimpleCall[MultiDocumentModel] = {
        val uri = Uri(s"/api/v2/transactions/multidocument/$multiDocTransId").withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[MultiDocumentModel](req)
      }
    }
}

/** /api/v2/transactions/$transId */
trait TransactionsApi {
  def get(include: Include): AvataxSimpleCall[TransactionModel]
}
object TransactionsApi {
  def apply(requester: Requester, security: Option[Authorization])(
      transactionId: Long
  )(implicit system: ActorSystem, materializer: Materializer): TransactionsApi =
    new ApiRoot(requester, security) with TransactionsApi {
      def get(include: Include): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/transactions/$transactionId").withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[TransactionModel](req)
      }
    }
}
