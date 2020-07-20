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

final case class PointOfSaleDataRequestModel(
    companyCode: String,
    documentDate: Option[Date] = None,
    responseType: Option[PointOfSaleFileType] = None,
    taxCodes: Option[List[String]] = None,
    itemCodes: Option[List[String]] = None,
    locationCodes: Option[List[String]] = None,
    includeJurisCodes: Option[Boolean] = None,
    partnerId: Option[PointOfSalePartnerId] = None
) {
  lazy val taxCodesRaw: List[String] = taxCodes.getOrElse(List.empty)
  lazy val itemCodesRaw: List[String] = itemCodes.getOrElse(List.empty)
  lazy val locationCodesRaw: List[String] = locationCodes.getOrElse(List.empty)
  def withCompanyCode(value: String): PointOfSaleDataRequestModel = copy(companyCode = value)
  def withDocumentDate(value: Date): PointOfSaleDataRequestModel = copy(documentDate = Some(value))
  def withResponseType(value: PointOfSaleFileType): PointOfSaleDataRequestModel = copy(responseType = Some(value))
  def withTaxCodes(value: List[String]): PointOfSaleDataRequestModel = copy(taxCodes = Some(value))
  def withItemCodes(value: List[String]): PointOfSaleDataRequestModel = copy(itemCodes = Some(value))
  def withLocationCodes(value: List[String]): PointOfSaleDataRequestModel = copy(locationCodes = Some(value))
  def withIncludeJurisCodes(value: Boolean): PointOfSaleDataRequestModel = copy(includeJurisCodes = Some(value))
  def withPartnerId(value: PointOfSalePartnerId): PointOfSaleDataRequestModel = copy(partnerId = Some(value))
}
