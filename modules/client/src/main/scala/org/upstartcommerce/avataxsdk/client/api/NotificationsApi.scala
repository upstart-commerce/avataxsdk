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

package org.upstartcommerce.avataxsdk.client.api

import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._

/** /api/v2/notifications */
trait NotificationsRootApi[F[_], S[_]] {
  def forId(notificationId: Long): NotificationsApi[F, S]

  def list(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NotificationModel]
  def create(model: List[NotificationModel]): AvataxSimpleCall[F, List[NotificationModel]]
}

/** /api/v2/notifications/$id/ */
trait NotificationsApi[F[_], S[_]] {
  def dismiss: AvataxSimpleCall[F, NotificationModel]
  def get: AvataxSimpleCall[F, NotificationModel]
  def delete: AvataxSimpleCall[F, List[ErrorDetail]]
  def update(model: NotificationModel): AvataxSimpleCall[F, NotificationModel]
}
