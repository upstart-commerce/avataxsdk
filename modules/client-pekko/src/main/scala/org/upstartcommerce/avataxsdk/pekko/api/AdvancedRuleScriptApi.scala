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

package org.upstartcommerce.avataxsdk.client.pekko.api

import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.http.scaladsl.model.HttpMethods._
import org.apache.pekko.http.scaladsl.model.Uri.Query
import org.apache.pekko.http.scaladsl.model._
import org.apache.pekko.stream.Materializer
import org.upstartcommerce.avataxsdk.client.pekko._
import org.upstartcommerce.avataxsdk.client.pekko.internal._
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.apache.pekko.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import org.upstartcommerce.avataxsdk.client.pekko.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.AccountAdvancedRuleScriptApi
import org.upstartcommerce.avataxsdk.client.api.AccountAdvancedRuleScriptRootApi
import org.upstartcommerce.avataxsdk.client.pekko.{AvataxCollectionCall, AvataxSimpleCall, Stream}

import scala.concurrent.Future

object AccountAdvancedRuleScriptRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      accountId: Int
  )(implicit system: ActorSystem, materializer: Materializer): AccountAdvancedRuleScriptRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with AccountAdvancedRuleScriptRootApi[Future, Stream] {
      def forScriptType(scriptType: AdvancedRuleScriptType): AccountAdvancedRuleScriptApi[Future, Stream] =
        AccountAdvancedRuleScriptApiImpl(requester, security, clientHeaders)(accountId, scriptType)
    }
}

object AccountAdvancedRuleScriptApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      accountId: Int,
      scriptType: AdvancedRuleScriptType
  )(implicit system: ActorSystem, materializer: Materializer): AccountAdvancedRuleScriptApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with AccountAdvancedRuleScriptApi[Future, Stream] {
      def approve: AvataxSimpleCall[AdvancedRuleScriptModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedrulescripts/$scriptType/approve")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[AdvancedRuleScriptModel](req)
      }

      def create(crashBehavior: AdvancedRuleCrashBehavior, file: String): AvataxSimpleCall[String] = {
        val uri =
          Uri(s"/api/v2/accounts/$accountId/advancedrulescripts/$scriptType").withQuery(Query("crashBehavior" -> crashBehavior.toString))
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[String](req)
      }

      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedrulescripts/$scriptType")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def disable: AvataxSimpleCall[AdvancedRuleScriptModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedrulescripts/$scriptType/disable")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[AdvancedRuleScriptModel](req)
      }

      def enable: AvataxSimpleCall[AdvancedRuleScriptModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedrulescripts/$scriptType/enable")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[AdvancedRuleScriptModel](req)
      }

      def get: AvataxSimpleCall[AdvancedRuleScriptModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedrulescripts/$scriptType")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[AdvancedRuleScriptModel](req)
      }

      def unapprove: AvataxSimpleCall[AdvancedRuleScriptModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedrulescripts/$scriptType/unapprove")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[AdvancedRuleScriptModel](req)
      }
    }
}
