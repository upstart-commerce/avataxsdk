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

final case class TaxDetailsByTaxType(
    taxType: Option[String] = None,
    totalTaxable: Option[BigDecimal] = None,
    totalExempt: Option[BigDecimal] = None,
    totalNonTaxable: Option[BigDecimal] = None,
    totalTax: Option[BigDecimal] = None
) {

  def withTaxType(value: String): TaxDetailsByTaxType = copy(taxType = Some(value))
  def withTotalTaxable(value: BigDecimal): TaxDetailsByTaxType = copy(totalTaxable = Some(value))
  def withTotalExempt(value: BigDecimal): TaxDetailsByTaxType = copy(totalExempt = Some(value))
  def withTotalNonTaxable(value: BigDecimal): TaxDetailsByTaxType = copy(totalNonTaxable = Some(value))
  def withTotalTax(value: BigDecimal): TaxDetailsByTaxType = copy(totalTax = Some(value))
}
