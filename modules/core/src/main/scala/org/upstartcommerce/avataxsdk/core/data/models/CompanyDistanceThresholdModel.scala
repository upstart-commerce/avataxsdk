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

final case class CompanyDistanceThresholdModel(
    id: Option[Long] = None,
    companyId: Option[Int] = None,
    originCountry: String,
    destinationCountry: String,
    effDate: Option[Date] = None,
    endDate: Option[Date] = None,
    thresholdExceeded: Option[Boolean] = None,
    `type`: String
) {

  def withId(value: Long): CompanyDistanceThresholdModel = copy(id = Some(value))
  def withCompanyId(value: Int): CompanyDistanceThresholdModel = copy(companyId = Some(value))
  def withOriginCountry(value: String): CompanyDistanceThresholdModel = copy(originCountry = value)
  def withDestinationCountry(value: String): CompanyDistanceThresholdModel = copy(destinationCountry = value)
  def withEffDate(value: Date): CompanyDistanceThresholdModel = copy(effDate = Some(value))
  def withEndDate(value: Date): CompanyDistanceThresholdModel = copy(endDate = Some(value))
  def withThresholdExceeded(value: Boolean): CompanyDistanceThresholdModel = copy(thresholdExceeded = Some(value))
  def withType(value: String): CompanyDistanceThresholdModel = copy(`type` = value)
}
