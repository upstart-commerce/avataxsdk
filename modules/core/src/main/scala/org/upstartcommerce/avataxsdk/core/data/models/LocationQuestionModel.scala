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

final case class LocationQuestionModel(
    id: Int,
    question: String,
    description: String,
    regularExpression: Option[String] = None,
    exampleValue: Option[String] = None,
    jurisdictionName: Option[String] = None,
    jurisdictionType: Option[JurisdictionType] = None,
    jurisdictionCountry: Option[String] = None,
    jurisdictionRegion: Option[String] = None
) {

  def withId(value: Int): LocationQuestionModel = copy(id = value)
  def withQuestion(value: String): LocationQuestionModel = copy(question = value)
  def withDescription(value: String): LocationQuestionModel = copy(description = value)
  def withRegularExpression(value: String): LocationQuestionModel = copy(regularExpression = Some(value))
  def withExampleValue(value: String): LocationQuestionModel = copy(exampleValue = Some(value))
  def withJurisdictionName(value: String): LocationQuestionModel = copy(jurisdictionName = Some(value))
  def withJurisdictionType(value: JurisdictionType): LocationQuestionModel = copy(jurisdictionType = Some(value))
  def withJurisdictionCountry(value: String): LocationQuestionModel = copy(jurisdictionCountry = Some(value))
  def withJurisdictionRegion(value: String): LocationQuestionModel = copy(jurisdictionRegion = Some(value))
}
