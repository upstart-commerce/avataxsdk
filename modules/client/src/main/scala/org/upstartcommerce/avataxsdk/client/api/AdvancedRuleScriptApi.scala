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
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._

trait AccountAdvancedRuleScriptRootApi[F[_], S[_]] {
  def forScriptType(scriptType: AdvancedRuleScriptType): AccountAdvancedRuleScriptApi[F, S]
}

trait AccountAdvancedRuleScriptApi[F[_], S[_]] {
  def approve: AvataxSimpleCall[F, AdvancedRuleScriptModel]

  /* todo: `file` arg is unused in official sdk, see  https://github.com/avadev/AvaTax-REST-V2-JRE-SDK/issues/44 */
  def create(crashBehavior: AdvancedRuleCrashBehavior, file: String): AvataxSimpleCall[F, String]
  def delete: AvataxSimpleCall[F, List[ErrorDetail]]
  def disable: AvataxSimpleCall[F, AdvancedRuleScriptModel]
  def enable: AvataxSimpleCall[F, AdvancedRuleScriptModel]
  def get: AvataxSimpleCall[F, AdvancedRuleScriptModel]
  def unapprove: AvataxSimpleCall[F, AdvancedRuleScriptModel]
}
