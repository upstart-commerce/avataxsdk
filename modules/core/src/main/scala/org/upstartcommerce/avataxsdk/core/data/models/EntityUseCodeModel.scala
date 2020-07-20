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

final case class EntityUseCodeModel(
    code: Option[String] = None,
    name: Option[String] = None,
    description: Option[String] = None,
    validCountries: Option[List[String]] = None
) {
  lazy val validCountriesRaw: List[String] = validCountries.getOrElse(List.empty)
  def withCode(value: String): EntityUseCodeModel = copy(code = Some(value))
  def withName(value: String): EntityUseCodeModel = copy(name = Some(value))
  def withDescription(value: String): EntityUseCodeModel = copy(description = Some(value))
  def withValidCountries(value: List[String]): EntityUseCodeModel = copy(validCountries = Some(value))
}
