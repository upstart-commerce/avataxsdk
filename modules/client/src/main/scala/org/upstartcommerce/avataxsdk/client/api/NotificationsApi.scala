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
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

/** /api/v2/notifications */
trait NotificationsRootApi {
  def forId(notificationId:Long): NotificationsApi

  def list(options:FiltrableQueryOptions):AvataxCollectionCall[NotificationModel]
  def create(model:List[NotificationModel]):AvataxSimpleCall[List[NotificationModel]]
}

object NotificationsRootApi {
  def apply(requester: Requester, security: Option[Authorization])(implicit system: ActorSystem, materializer: Materializer): NotificationsRootApi =
    new ApiRoot(requester, security) with NotificationsRootApi {
      def forId(notificationId: Long): NotificationsApi = NotificationsApi(requester, security)(notificationId)

      def list(options:FiltrableQueryOptions):AvataxCollectionCall[NotificationModel] = {
        val uri = Uri(s"/api/v2/notifications").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NotificationModel](req)
      }

      def create(model:List[NotificationModel]):AvataxSimpleCall[List[NotificationModel]] = {
        val uri = Uri(s"/api/v2/notifications")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[NotificationModel], List[NotificationModel]](req, model)
      }
    }
}

/** /api/v2/notifications/$id/ */
trait NotificationsApi {
  def dismiss:AvataxSimpleCall[NotificationModel]
  def get:AvataxSimpleCall[NotificationModel]
  def delete:AvataxSimpleCall[List[ErrorDetail]]
  def update(model:NotificationModel):AvataxSimpleCall[NotificationModel]
}
object NotificationsApi {
  def apply(requester: Requester, security: Option[Authorization])(notificationId:Long)(implicit system: ActorSystem, materializer: Materializer): NotificationsApi =
    new ApiRoot(requester, security) with NotificationsApi {
      def dismiss:AvataxSimpleCall[NotificationModel] = {
        val uri = Uri(s"/api/v2/notifications/$notificationId/dismiss")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxSimpleCall[NotificationModel](req)
      }

      def get:AvataxSimpleCall[NotificationModel] = {
        val uri = Uri(s"/api/v2/notifications/$notificationId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[NotificationModel](req)
      }

      def delete:AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/notifications/$notificationId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def update(model:NotificationModel):AvataxSimpleCall[NotificationModel] = {
        val uri = Uri(s"/api/v2/notifications/$notificationId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxSimpleCall[NotificationModel](req)
      }
    }
}