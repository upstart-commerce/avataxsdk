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

final case class ComplianceTaxRateModel(
    id: Option[Int] = None,
    rate: Option[BigDecimal] = None,
    jurisdictionId: Option[Int] = None,
    taxRegionId: Option[Int] = None,
    effectiveDate: Option[Date] = None,
    endDate: Option[Date] = None,
    rateTypeId: Option[String] = None,
    taxTypeId: Option[String] = None,
    taxName: Option[String] = None,
    unitOfBasisId: Option[Long] = None,
    rateTypeTaxTypeMappingId: Option[Int] = None
) {

  def withId(value: Int): ComplianceTaxRateModel = copy(id = Some(value))
  def withRate(value: BigDecimal): ComplianceTaxRateModel = copy(rate = Some(value))
  def withJurisdictionId(value: Int): ComplianceTaxRateModel = copy(jurisdictionId = Some(value))
  def withTaxRegionId(value: Int): ComplianceTaxRateModel = copy(taxRegionId = Some(value))
  def withEffectiveDate(value: Date): ComplianceTaxRateModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Date): ComplianceTaxRateModel = copy(endDate = Some(value))
  def withRateTypeId(value: String): ComplianceTaxRateModel = copy(rateTypeId = Some(value))
  def withTaxTypeId(value: String): ComplianceTaxRateModel = copy(taxTypeId = Some(value))
  def withTaxName(value: String): ComplianceTaxRateModel = copy(taxName = Some(value))
  def withUnitOfBasisId(value: Long): ComplianceTaxRateModel = copy(unitOfBasisId = Some(value))
  def withRateTypeTaxTypeMappingId(value: Int): ComplianceTaxRateModel = copy(rateTypeTaxTypeMappingId = Some(value))
}
