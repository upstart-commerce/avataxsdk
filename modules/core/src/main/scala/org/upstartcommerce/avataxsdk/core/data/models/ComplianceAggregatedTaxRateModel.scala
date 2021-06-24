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
import java.time.Instant

final case class ComplianceAggregatedTaxRateModel(
    rate: Option[BigDecimal] = None,
    stackRate: Option[BigDecimal] = None,
    effectiveDate: Option[Instant] = None,
    endDate: Option[Instant] = None,
    taxTypeId: Option[String] = None,
    rateTypeId: Option[String] = None
) {

  def withRate(value: BigDecimal): ComplianceAggregatedTaxRateModel = copy(rate = Some(value))
  def withStackRate(value: BigDecimal): ComplianceAggregatedTaxRateModel = copy(stackRate = Some(value))
  def withEffectiveDate(value: Instant): ComplianceAggregatedTaxRateModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Instant): ComplianceAggregatedTaxRateModel = copy(endDate = Some(value))
  def withTaxTypeId(value: String): ComplianceAggregatedTaxRateModel = copy(taxTypeId = Some(value))
  def withRateTypeId(value: String): ComplianceAggregatedTaxRateModel = copy(rateTypeId = Some(value))
}
