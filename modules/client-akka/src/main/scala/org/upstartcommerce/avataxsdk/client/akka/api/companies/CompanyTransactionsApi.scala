/* Copyright 2024 UpStart Commerce, Inc.
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

package org.upstartcommerce.avataxsdk.client.akka.api.companies

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model.Uri.Query
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client.akka._
import org.upstartcommerce.avataxsdk.client.akka.api._
import org.upstartcommerce.avataxsdk.client.akka.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.companies.{CompanyTransactionsApi, CompanyTransactionsRootApi}
import org.upstartcommerce.avataxsdk.client.akka.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object CompanyTransactionsRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyCode: String
  )(implicit system: ActorSystem, materializer: Materializer): CompanyTransactionsRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyTransactionsRootApi[Future, Stream] {
      def forId(transactionCode: String): CompanyTransactionsApi[Future, Stream] =
        CompanyTransactionsApiImpl(requester, security, clientHeaders)(companyCode, transactionCode)

      def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/companies/$companyCode/transactions").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[TransactionModel](req)
      }
    }
}
object CompanyTransactionsApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      companyCode: String,
      transactionCode: String
  )(implicit system: ActorSystem, materializer: Materializer): CompanyTransactionsApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with CompanyTransactionsApi[Future, Stream] {

      def adjust(documentType: DocumentType, model: AdjustTransactionModel): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/companies/$companyCode/transactions/$transactionCode/adjust").withQuery(Query("companyCode" -> companyCode))
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[AdjustTransactionModel, TransactionModel](req, model)
      }

      def audit: AvataxSimpleCall[AuditTransactionModel] = {
        val uri = Uri(s"/api/v2/companies/$companyCode/transactions/$transactionCode")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[AuditTransactionModel](req)
      }

      def auditWithType(documentType: DocumentType): AvataxSimpleCall[AuditTransactionModel] = {
        val uri = Uri(s"/api/v2/companies/$companyCode/transactions/$transactionCode/types/$documentType/audit")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[AuditTransactionModel](req)
      }

      def changeCode(documentType: DocumentType, model: ChangeTransactionCodeModel): AvataxSimpleCall[TransactionModel] = {
        val uri =
          Uri(s"/api/v2/companies/$companyCode/transactions/$transactionCode/changecode").withQuery(Query("companyCode" -> companyCode))
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[ChangeTransactionCodeModel, TransactionModel](req, model)
      }

      def commit(documentType: DocumentType, model: CommitTransactionModel): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/companies/$companyCode/transactions/$transactionCode/commit").withQuery(Query("companyCode" -> companyCode))
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[CommitTransactionModel, TransactionModel](req, model)
      }

      def get(documentType: DocumentType, include: Include): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/companies/$companyCode/transactions/$transactionCode")
          .withQuery(Query("documentType" -> documentType.toString).merge(include.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[TransactionModel](req)
      }

      def getByType(documentType: DocumentType, include: Include): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/companies/$companyCode/transactions/$transactionCode/types/$documentType").withQuery(include.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[TransactionModel](req)
      }

      def lock(documentType: DocumentType, model: LockTransactionModel): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/companies/$companyCode/transactions/$transactionCode/lock")
          .withQuery(Query("documentType" -> documentType.toString))
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[LockTransactionModel, TransactionModel](req, model)
      }

      def refund(
          documentType: DocumentType,
          include: Include,
          useTaxDateOverride: Boolean,
          model: RefundTransactionModel
      ): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/companies/$companyCode/transactions/$transactionCode/refund").withQuery(
          Query("documentType" -> documentType.toString, "useTaxDateOverride" -> useTaxDateOverride.toString).merge(include.asQuery)
        )
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[RefundTransactionModel, TransactionModel](req, model)
      }

      def settle(documentType: DocumentType, model: SettleTransactionModel): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/companies/$companyCode/transactions/$transactionCode/settle")
          .withQuery(Query("documentType" -> documentType.toString))
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[SettleTransactionModel, TransactionModel](req, model)
      }

      def uncommit(documentType: DocumentType): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/companies/$companyCode/transactions/$transactionCode/uncommit")
          .withQuery(Query("documentType" -> documentType.toString))
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[TransactionModel](req)
      }

      def verify(documentType: DocumentType, model: VerifyTransactionModel): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/companies/$companyCode/transactions/$transactionCode/verify")
          .withQuery(Query("documentType" -> documentType.toString))
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[VerifyTransactionModel, TransactionModel](req, model)
      }

      def void(documentType: DocumentType, model: VoidTransactionModel): AvataxSimpleCall[TransactionModel] = {
        val uri = Uri(s"/api/v2/companies/$companyCode/transactions/$transactionCode/void")
          .withQuery(Query("documentType" -> documentType.toString))
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[VoidTransactionModel, TransactionModel](req, model)
      }
    }
}
