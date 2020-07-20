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

final case class ExposureZoneModel(
    id: Option[Int] = None,
    companyId: Option[Int] = None,
    name: Option[String] = None,
    tag: Option[String] = None,
    description: Option[String] = None,
    created: Option[Date] = None,
    modified: Option[Date] = None,
    region: Option[String] = None,
    country: Option[String] = None
) {

  def withId(value: Int): ExposureZoneModel = copy(id = Some(value))
  def withCompanyId(value: Int): ExposureZoneModel = copy(companyId = Some(value))
  def withName(value: String): ExposureZoneModel = copy(name = Some(value))
  def withTag(value: String): ExposureZoneModel = copy(tag = Some(value))
  def withDescription(value: String): ExposureZoneModel = copy(description = Some(value))
  def withCreated(value: Date): ExposureZoneModel = copy(created = Some(value))
  def withModified(value: Date): ExposureZoneModel = copy(modified = Some(value))
  def withRegion(value: String): ExposureZoneModel = copy(region = Some(value))
  def withCountry(value: String): ExposureZoneModel = copy(country = Some(value))
}
