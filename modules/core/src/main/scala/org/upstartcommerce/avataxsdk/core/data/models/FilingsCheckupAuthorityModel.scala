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

final case class FilingsCheckupAuthorityModel(
    taxAuthorityId: Option[Int] = None,
    locationCode: Option[String] = None,
    taxAuthorityName: Option[String] = None,
    taxAuthorityTypeId: Option[Int] = None,
    jurisdictionId: Option[Int] = None,
    tax: Option[BigDecimal] = None,
    taxTypeId: Option[String] = None,
    suggestedForms: Option[List[FilingsCheckupSuggestedFormModel]] = None
) {
  lazy val suggestedFormsRaw: List[FilingsCheckupSuggestedFormModel] = suggestedForms.getOrElse(List.empty)
  def withTaxAuthorityId(value: Int): FilingsCheckupAuthorityModel = copy(taxAuthorityId = Some(value))
  def withLocationCode(value: String): FilingsCheckupAuthorityModel = copy(locationCode = Some(value))
  def withTaxAuthorityName(value: String): FilingsCheckupAuthorityModel = copy(taxAuthorityName = Some(value))
  def withTaxAuthorityTypeId(value: Int): FilingsCheckupAuthorityModel = copy(taxAuthorityTypeId = Some(value))
  def withJurisdictionId(value: Int): FilingsCheckupAuthorityModel = copy(jurisdictionId = Some(value))
  def withTax(value: BigDecimal): FilingsCheckupAuthorityModel = copy(tax = Some(value))
  def withTaxTypeId(value: String): FilingsCheckupAuthorityModel = copy(taxTypeId = Some(value))
  def withSuggestedForms(value: List[FilingsCheckupSuggestedFormModel]): FilingsCheckupAuthorityModel = copy(suggestedForms = Some(value))
}
