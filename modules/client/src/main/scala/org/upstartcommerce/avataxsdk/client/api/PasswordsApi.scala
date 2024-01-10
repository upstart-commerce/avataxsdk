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
import org.upstartcommerce.avataxsdk.core.data.models._

/** /api/v2/passwords */
trait PasswordsRootApi[F[_], S[_]] {
  def forId(userId: Int): PasswordsApi[F, S]

  def change(model: PasswordChangeModel): AvataxSimpleCall[F, String]
}

trait PasswordsApi[F[_], S[_]] {
  def reset(unmigrateFromAi: Boolean, model: SetPasswordModel): AvataxSimpleCall[F, String]
}
