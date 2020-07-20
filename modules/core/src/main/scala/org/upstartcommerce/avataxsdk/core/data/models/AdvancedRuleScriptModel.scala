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

package org.upstartcommerce.avataxsdk.core.data.models
import java.sql.Date
import org.upstartcommerce.avataxsdk.core.data.enums._

final case class AdvancedRuleScriptModel(
    id: Long,
    accountId: Option[Int] = None,
    crashBehavior: Option[AdvancedRuleCrashBehavior] = None,
    scriptType: Option[AdvancedRuleScriptType] = None,
    script: Option[String] = None,
    isApproved: Option[Boolean] = None,
    isDisabled: Option[Boolean] = None
) {

  def withId(value: Long): AdvancedRuleScriptModel = copy(id = value)
  def withAccountId(value: Int): AdvancedRuleScriptModel = copy(accountId = Some(value))
  def withCrashBehavior(value: AdvancedRuleCrashBehavior): AdvancedRuleScriptModel = copy(crashBehavior = Some(value))
  def withScriptType(value: AdvancedRuleScriptType): AdvancedRuleScriptModel = copy(scriptType = Some(value))
  def withScript(value: String): AdvancedRuleScriptModel = copy(script = Some(value))
  def withIsApproved(value: Boolean): AdvancedRuleScriptModel = copy(isApproved = Some(value))
  def withIsDisabled(value: Boolean): AdvancedRuleScriptModel = copy(isDisabled = Some(value))
}
