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

final case class DeclareNexusByAddressModel(
    effectiveDate: Option[Date] = None,
    endDate: Option[Date] = None,
    textCase: Option[TextCase] = None,
    line1: Option[String] = None,
    line2: Option[String] = None,
    line3: Option[String] = None,
    city: Option[String] = None,
    region: Option[String] = None,
    country: Option[String] = None,
    postalCode: Option[String] = None,
    latitude: Option[BigDecimal] = None,
    longitude: Option[BigDecimal] = None
) {

  def withEffectiveDate(value: Date): DeclareNexusByAddressModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Date): DeclareNexusByAddressModel = copy(endDate = Some(value))
  def withTextCase(value: TextCase): DeclareNexusByAddressModel = copy(textCase = Some(value))
  def withLine1(value: String): DeclareNexusByAddressModel = copy(line1 = Some(value))
  def withLine2(value: String): DeclareNexusByAddressModel = copy(line2 = Some(value))
  def withLine3(value: String): DeclareNexusByAddressModel = copy(line3 = Some(value))
  def withCity(value: String): DeclareNexusByAddressModel = copy(city = Some(value))
  def withRegion(value: String): DeclareNexusByAddressModel = copy(region = Some(value))
  def withCountry(value: String): DeclareNexusByAddressModel = copy(country = Some(value))
  def withPostalCode(value: String): DeclareNexusByAddressModel = copy(postalCode = Some(value))
  def withLatitude(value: BigDecimal): DeclareNexusByAddressModel = copy(latitude = Some(value))
  def withLongitude(value: BigDecimal): DeclareNexusByAddressModel = copy(longitude = Some(value))
}
