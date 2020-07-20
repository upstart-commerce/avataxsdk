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

final case class IsoCountryModel(
    code: Option[String] = None,
    alpha3Code: Option[String] = None,
    name: Option[String] = None,
    isEuropeanUnion: Option[Boolean] = None,
    localizedNames: Option[List[IsoLocalizedName]] = None,
    addressesRequireRegion: Option[Boolean] = None
) {
  lazy val localizedNamesRaw: List[IsoLocalizedName] = localizedNames.getOrElse(List.empty)
  def withCode(value: String): IsoCountryModel = copy(code = Some(value))
  def withAlpha3Code(value: String): IsoCountryModel = copy(alpha3Code = Some(value))
  def withName(value: String): IsoCountryModel = copy(name = Some(value))
  def withIsEuropeanUnion(value: Boolean): IsoCountryModel = copy(isEuropeanUnion = Some(value))
  def withLocalizedNames(value: List[IsoLocalizedName]): IsoCountryModel = copy(localizedNames = Some(value))
  def withAddressesRequireRegion(value: Boolean): IsoCountryModel = copy(addressesRequireRegion = Some(value))
}
