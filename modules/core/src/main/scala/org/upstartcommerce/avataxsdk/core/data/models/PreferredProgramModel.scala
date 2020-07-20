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

final case class PreferredProgramModel(
    id: Option[Int] = None,
    code: Option[String] = None,
    originCountry: Option[String] = None,
    destinationCountry: Option[String] = None,
    effectiveDate: Option[Date] = None,
    endDate: Option[Date] = None
) {

  def withId(value: Int): PreferredProgramModel = copy(id = Some(value))
  def withCode(value: String): PreferredProgramModel = copy(code = Some(value))
  def withOriginCountry(value: String): PreferredProgramModel = copy(originCountry = Some(value))
  def withDestinationCountry(value: String): PreferredProgramModel = copy(destinationCountry = Some(value))
  def withEffectiveDate(value: Date): PreferredProgramModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Date): PreferredProgramModel = copy(endDate = Some(value))
}
