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

final case class ItemModel(
    id: Long,
    companyId: Option[Int] = None,
    itemCode: String,
    taxCodeId: Option[Int] = None,
    taxCode: Option[String] = None,
    description: String,
    itemGroup: Option[String] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None,
    classifications: Option[List[ClassificationModel]] = None,
    parameters: Option[List[ItemParameterModel]] = None
) {
  lazy val classificationsRaw: List[ClassificationModel] = classifications.getOrElse(List.empty)
  lazy val parametersRaw: List[ItemParameterModel] = parameters.getOrElse(List.empty)
  def withId(value: Long): ItemModel = copy(id = value)
  def withCompanyId(value: Int): ItemModel = copy(companyId = Some(value))
  def withItemCode(value: String): ItemModel = copy(itemCode = value)
  def withTaxCodeId(value: Int): ItemModel = copy(taxCodeId = Some(value))
  def withTaxCode(value: String): ItemModel = copy(taxCode = Some(value))
  def withDescription(value: String): ItemModel = copy(description = value)
  def withItemGroup(value: String): ItemModel = copy(itemGroup = Some(value))
  def withCreatedDate(value: Date): ItemModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): ItemModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): ItemModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): ItemModel = copy(modifiedUserId = Some(value))
  def withClassifications(value: List[ClassificationModel]): ItemModel = copy(classifications = Some(value))
  def withParameters(value: List[ItemParameterModel]): ItemModel = copy(parameters = Some(value))
}
