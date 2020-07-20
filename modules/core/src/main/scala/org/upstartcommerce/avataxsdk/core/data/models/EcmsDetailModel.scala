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

final case class EcmsDetailModel(
    exemptCertDetailId: Int,
    exemptCertId: Int,
    stateFips: String,
    region: String,
    idNo: Option[String] = None,
    country: String,
    endDate: Option[Date] = None,
    idType: Option[String] = None,
    isTaxCodeListExclusionList: Option[Int] = None,
    taxCodes: Option[List[EcmsDetailTaxCodeModel]] = None
) {
  lazy val taxCodesRaw: List[EcmsDetailTaxCodeModel] = taxCodes.getOrElse(List.empty)
  def withExemptCertDetailId(value: Int): EcmsDetailModel = copy(exemptCertDetailId = value)
  def withExemptCertId(value: Int): EcmsDetailModel = copy(exemptCertId = value)
  def withStateFips(value: String): EcmsDetailModel = copy(stateFips = value)
  def withRegion(value: String): EcmsDetailModel = copy(region = value)
  def withIdNo(value: String): EcmsDetailModel = copy(idNo = Some(value))
  def withCountry(value: String): EcmsDetailModel = copy(country = value)
  def withEndDate(value: Date): EcmsDetailModel = copy(endDate = Some(value))
  def withIdType(value: String): EcmsDetailModel = copy(idType = Some(value))
  def withIsTaxCodeListExclusionList(value: Int): EcmsDetailModel = copy(isTaxCodeListExclusionList = Some(value))
  def withTaxCodes(value: List[EcmsDetailTaxCodeModel]): EcmsDetailModel = copy(taxCodes = Some(value))
}
