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

final case class FilingCalendarEditModel(fieldName: String, questionId: Int, oldValue: Map[String, String], newValue: Map[String, String]) {
  def withFieldName(value: String): FilingCalendarEditModel = copy(fieldName = value)
  def withQuestionId(value: Int): FilingCalendarEditModel = copy(questionId = value)
  def withOldValue(value: Map[String, String]): FilingCalendarEditModel = copy(oldValue = value)
  def withNewValue(value: Map[String, String]): FilingCalendarEditModel = copy(newValue = value)
}
