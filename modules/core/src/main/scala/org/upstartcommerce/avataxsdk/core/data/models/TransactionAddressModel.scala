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

final case class TransactionAddressModel(
    id: Option[Long] = None,
    transactionId: Option[Long] = None,
    boundaryLevel: Option[BoundaryLevel] = None,
    line1: Option[String] = None,
    line2: Option[String] = None,
    line3: Option[String] = None,
    city: Option[String] = None,
    region: Option[String] = None,
    postalCode: Option[String] = None,
    country: Option[String] = None,
    taxRegionId: Option[Int] = None,
    latitude: Option[String] = None,
    longitude: Option[String] = None
) {

  def withId(value: Long): TransactionAddressModel = copy(id = Some(value))
  def withTransactionId(value: Long): TransactionAddressModel = copy(transactionId = Some(value))
  def withBoundaryLevel(value: BoundaryLevel): TransactionAddressModel = copy(boundaryLevel = Some(value))
  def withLine1(value: String): TransactionAddressModel = copy(line1 = Some(value))
  def withLine2(value: String): TransactionAddressModel = copy(line2 = Some(value))
  def withLine3(value: String): TransactionAddressModel = copy(line3 = Some(value))
  def withCity(value: String): TransactionAddressModel = copy(city = Some(value))
  def withRegion(value: String): TransactionAddressModel = copy(region = Some(value))
  def withPostalCode(value: String): TransactionAddressModel = copy(postalCode = Some(value))
  def withCountry(value: String): TransactionAddressModel = copy(country = Some(value))
  def withTaxRegionId(value: Int): TransactionAddressModel = copy(taxRegionId = Some(value))
  def withLatitude(value: String): TransactionAddressModel = copy(latitude = Some(value))
  def withLongitude(value: String): TransactionAddressModel = copy(longitude = Some(value))
}
