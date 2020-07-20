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

final case class IsoLocalizedName(
    languageAlpha2Code: Option[String] = None,
    languageAlpha3Code: Option[String] = None,
    name: Option[String] = None
) {

  def withLanguageAlpha2Code(value: String): IsoLocalizedName = copy(languageAlpha2Code = Some(value))
  def withLanguageAlpha3Code(value: String): IsoLocalizedName = copy(languageAlpha3Code = Some(value))
  def withName(value: String): IsoLocalizedName = copy(name = Some(value))
}
