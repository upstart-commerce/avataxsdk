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

final case class IsoRegionModel(
    countryCode: Option[String] = None,
    code: Option[String] = None,
    name: Option[String] = None,
    classification: Option[String] = None,
    streamlinedSalesTax: Option[Boolean] = None,
    localizedNames: Option[List[IsoLocalizedName]] = None
) {
  lazy val localizedNamesRaw: List[IsoLocalizedName] = localizedNames.getOrElse(List.empty)
  def withCountryCode(value: String): IsoRegionModel = copy(countryCode = Some(value))
  def withCode(value: String): IsoRegionModel = copy(code = Some(value))
  def withName(value: String): IsoRegionModel = copy(name = Some(value))
  def withClassification(value: String): IsoRegionModel = copy(classification = Some(value))
  def withStreamlinedSalesTax(value: Boolean): IsoRegionModel = copy(streamlinedSalesTax = Some(value))
  def withLocalizedNames(value: List[IsoLocalizedName]): IsoRegionModel = copy(localizedNames = Some(value))
}
