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
import org.apache.pekko.http.scaladsl.model._
import org.apache.pekko.stream.Materializer
import org.upstartcommerce.avataxsdk.client.pekko._
import org.upstartcommerce.avataxsdk.client.pekko.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.apache.pekko.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import org.upstartcommerce.avataxsdk.client.pekko.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.{NotificationsApi, NotificationsRootApi}
import org.upstartcommerce.avataxsdk.client.pekko.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object NotificationsRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      implicit system: ActorSystem,
      materializer: Materializer
  ): NotificationsRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with NotificationsRootApi[Future, Stream] {
      def forId(notificationId: Long): NotificationsApi[Future, Stream] =
        NotificationsApiImpl(requester, security, clientHeaders)(notificationId)

      def list(options: FiltrableQueryOptions): AvataxCollectionCall[NotificationModel] = {
        val uri = Uri(s"/api/v2/notifications").withQuery(options.asQuery)
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NotificationModel](req)
      }

      def create(model: List[NotificationModel]): AvataxSimpleCall[List[NotificationModel]] = {
        val uri = Uri(s"/api/v2/notifications")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[NotificationModel], List[NotificationModel]](req, model)
      }
    }
}

object NotificationsApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      notificationId: Long
  )(implicit system: ActorSystem, materializer: Materializer): NotificationsApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with NotificationsApi[Future, Stream] {
      def dismiss: AvataxSimpleCall[NotificationModel] = {
        val uri = Uri(s"/api/v2/notifications/$notificationId/dismiss")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxSimpleCall[NotificationModel](req)
      }

      def get: AvataxSimpleCall[NotificationModel] = {
        val uri = Uri(s"/api/v2/notifications/$notificationId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[NotificationModel](req)
      }

      def delete: AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/notifications/$notificationId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def update(model: NotificationModel): AvataxSimpleCall[NotificationModel] = {
        val uri = Uri(s"/api/v2/notifications/$notificationId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxSimpleCall[NotificationModel](req)
      }
    }
}
