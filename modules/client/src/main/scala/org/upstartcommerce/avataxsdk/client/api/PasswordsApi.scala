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
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders

/** /api/v2/passwords */
trait PasswordsRootApi {
  def forId(userId: Int): PasswordsApi

  def change(model: PasswordChangeModel): AvataxSimpleCall[String]
}

object PasswordsRootApi {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      implicit system: ActorSystem,
      materializer: Materializer
  ): PasswordsRootApi =
    new ApiRoot(requester, security, clientHeaders) with PasswordsRootApi {
      def forId(userId: Int): PasswordsApi = PasswordsApi(requester, security, clientHeaders)(userId)

      def change(model: PasswordChangeModel): AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/passwords")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[PasswordChangeModel, String](req, model)
      }
    }
}

trait PasswordsApi {
  def reset(unmigrateFromAi: Boolean, model: SetPasswordModel): AvataxSimpleCall[String]
}
object PasswordsApi {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      userId: Int
  )(implicit system: ActorSystem, materializer: Materializer): PasswordsApi =
    new ApiRoot(requester, security, clientHeaders) with PasswordsApi {
      def reset(unmigrateFromAi: Boolean, model: SetPasswordModel): AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/passwords/$userId/reset")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[SetPasswordModel, String](req, model)
      }
    }
}
