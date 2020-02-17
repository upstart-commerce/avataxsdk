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
import akka.http.scaladsl.model.Uri.Query
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

trait AccountAdvancedRuleScriptRootApi {
  def forScriptType(scriptType:AdvancedRuleScriptType): AccountAdvancedRuleScriptApi
}

object AccountAdvancedRuleScriptRootApi {
  def apply(requester:Requester, security:Option[Authorization])(accountId:Int)(implicit system: ActorSystem,
                                  materializer: Materializer): AccountAdvancedRuleScriptRootApi =
    new ApiRoot(requester, security) with AccountAdvancedRuleScriptRootApi {
      def forScriptType(scriptType:AdvancedRuleScriptType): AccountAdvancedRuleScriptApi = AccountAdvancedRuleScriptApi(requester, security)(accountId, scriptType)
    }
}

trait AccountAdvancedRuleScriptApi {
  def approve:AvataxSimpleCall[AdvancedRuleScriptModel]

  /* todo: `file` arg is unused in official sdk, see  https://github.com/avadev/AvaTax-REST-V2-JRE-SDK/issues/44 */
  def create(crashBehavior: AdvancedRuleCrashBehavior, file:String):AvataxSimpleCall[String]
  def delete:AvataxSimpleCall[List[ErrorDetail]]
  def disable:AvataxSimpleCall[AdvancedRuleScriptModel]
  def enable:AvataxSimpleCall[AdvancedRuleScriptModel]
  def get:AvataxSimpleCall[AdvancedRuleScriptModel]
  def unapprove:AvataxSimpleCall[AdvancedRuleScriptModel]
}

object AccountAdvancedRuleScriptApi {
  def apply(requester:Requester, security:Option[Authorization])(accountId:Int, scriptType:AdvancedRuleScriptType)(implicit system: ActorSystem,
                                                                              materializer: Materializer): AccountAdvancedRuleScriptApi =
    new ApiRoot(requester, security) with AccountAdvancedRuleScriptApi {
      def approve:AvataxSimpleCall[AdvancedRuleScriptModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedrulescripts/$scriptType/approve")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[AdvancedRuleScriptModel](req)
      }

      def create(crashBehavior: AdvancedRuleCrashBehavior, file:String):AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedrulescripts/$scriptType")
          .withQuery(Query("crashBehavior" -> crashBehavior.toString))
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[String](req)
      }

      def delete:AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedrulescripts/$scriptType")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def disable:AvataxSimpleCall[AdvancedRuleScriptModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedrulescripts/$scriptType/disable")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[AdvancedRuleScriptModel](req)
      }

      def enable:AvataxSimpleCall[AdvancedRuleScriptModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedrulescripts/$scriptType/enable")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[AdvancedRuleScriptModel](req)
      }

      def get:AvataxSimpleCall[AdvancedRuleScriptModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedrulescripts/$scriptType")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[AdvancedRuleScriptModel](req)
      }

      def unapprove:AvataxSimpleCall[AdvancedRuleScriptModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedrulescripts/$scriptType/unapprove")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[AdvancedRuleScriptModel](req)
      }
    }
}
