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

final case class TaxCodeModel(
    id: Option[Int] = None,
    companyId: Option[Int] = None,
    taxCode: String,
    taxCodeTypeId: String,
    description: Option[String] = None,
    parentTaxCode: Option[String] = None,
    isPhysical: Option[Boolean] = None,
    goodsServiceCode: Option[Long] = None,
    entityUseCode: Option[String] = None,
    isActive: Option[Boolean] = None,
    isSSTCertified: Option[Boolean] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None
) {

  def withId(value: Int): TaxCodeModel = copy(id = Some(value))
  def withCompanyId(value: Int): TaxCodeModel = copy(companyId = Some(value))
  def withTaxCode(value: String): TaxCodeModel = copy(taxCode = value)
  def withTaxCodeTypeId(value: String): TaxCodeModel = copy(taxCodeTypeId = value)
  def withDescription(value: String): TaxCodeModel = copy(description = Some(value))
  def withParentTaxCode(value: String): TaxCodeModel = copy(parentTaxCode = Some(value))
  def withIsPhysical(value: Boolean): TaxCodeModel = copy(isPhysical = Some(value))
  def withGoodsServiceCode(value: Long): TaxCodeModel = copy(goodsServiceCode = Some(value))
  def withEntityUseCode(value: String): TaxCodeModel = copy(entityUseCode = Some(value))
  def withIsActive(value: Boolean): TaxCodeModel = copy(isActive = Some(value))
  def withIsSSTCertified(value: Boolean): TaxCodeModel = copy(isSSTCertified = Some(value))
  def withCreatedDate(value: Date): TaxCodeModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): TaxCodeModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): TaxCodeModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): TaxCodeModel = copy(modifiedUserId = Some(value))
}
