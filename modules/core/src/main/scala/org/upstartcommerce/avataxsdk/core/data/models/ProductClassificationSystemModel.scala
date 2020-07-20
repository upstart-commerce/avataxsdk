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

final case class ProductClassificationSystemModel(
    systemId: Option[Int] = None,
    systemCode: Option[String] = None,
    description: Option[String] = None,
    customsValue: Option[String] = None,
    countries: Option[List[ProductSystemCountryModel]] = None
) {
  lazy val countriesRaw: List[ProductSystemCountryModel] = countries.getOrElse(List.empty)
  def withSystemId(value: Int): ProductClassificationSystemModel = copy(systemId = Some(value))
  def withSystemCode(value: String): ProductClassificationSystemModel = copy(systemCode = Some(value))
  def withDescription(value: String): ProductClassificationSystemModel = copy(description = Some(value))
  def withCustomsValue(value: String): ProductClassificationSystemModel = copy(customsValue = Some(value))
  def withCountries(value: List[ProductSystemCountryModel]): ProductClassificationSystemModel = copy(countries = Some(value))
}
