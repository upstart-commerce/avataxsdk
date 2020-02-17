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
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

trait AccountAdvancedRuleTableRootApi {
  def forTableName(csvTableName: String): AccountAdvancedRuleTableApi

  def get:AvataxSimpleCall[AdvancedRuleTableModel]
}

object AccountAdvancedRuleTableRootApi {
  def apply(requester: Requester, security: Option[Authorization])(accountId: Int)(implicit system: ActorSystem,
                                                                                 materializer: Materializer): AccountAdvancedRuleTableRootApi =
    new ApiRoot(requester, security) with AccountAdvancedRuleTableRootApi {
      def forTableName(csvTableName: String): AccountAdvancedRuleTableApi = AccountAdvancedRuleTableApi(requester, security)(accountId, csvTableName)

      def get:AvataxSimpleCall[AdvancedRuleTableModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedruletables")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[AdvancedRuleTableModel](req)
      }
    }
}

trait AccountAdvancedRuleTableApi {
  /* todo: `file` arg is unused in official sdk, see  https://github.com/avadev/AvaTax-REST-V2-JRE-SDK/issues/44 */
  def create(file: String): AvataxSimpleCall[String]

  def delete:AvataxSimpleCall[List[ErrorDetail]]

  def get:AvataxSimpleCall[AdvancedRuleTableModel]
}

object AccountAdvancedRuleTableApi {
  def apply(requester: Requester, security: Option[Authorization])(accountId: Int, csvTableName: String)(
      implicit system: ActorSystem, materializer: Materializer): AccountAdvancedRuleTableApi =
    new ApiRoot(requester, security) with AccountAdvancedRuleTableApi {

      def create(file: String): AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedruletables/$csvTableName")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxSimpleCall[String](req)
      }

      def delete:AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedruletables/$csvTableName")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get:AvataxSimpleCall[AdvancedRuleTableModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/advancedruletables/$csvTableName")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[AdvancedRuleTableModel](req)
      }
    }
}
