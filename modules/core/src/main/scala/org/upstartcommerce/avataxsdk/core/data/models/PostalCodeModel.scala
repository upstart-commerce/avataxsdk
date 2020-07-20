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

final case class PostalCodeModel(
    country: Option[String] = None,
    region: Option[String] = None,
    taxRegionId: Option[Int] = None,
    effDate: Option[Date] = None,
    endDate: Option[Date] = None,
    postalCode: Option[String] = None
) {

  def withCountry(value: String): PostalCodeModel = copy(country = Some(value))
  def withRegion(value: String): PostalCodeModel = copy(region = Some(value))
  def withTaxRegionId(value: Int): PostalCodeModel = copy(taxRegionId = Some(value))
  def withEffDate(value: Date): PostalCodeModel = copy(effDate = Some(value))
  def withEndDate(value: Date): PostalCodeModel = copy(endDate = Some(value))
  def withPostalCode(value: String): PostalCodeModel = copy(postalCode = Some(value))
}
