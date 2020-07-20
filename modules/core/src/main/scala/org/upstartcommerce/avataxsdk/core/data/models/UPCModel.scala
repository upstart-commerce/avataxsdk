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

final case class UPCModel(
    id: Int,
    companyId: Option[Int] = None,
    upc: String,
    legacyTaxCode: Option[String] = None,
    description: String,
    effectiveDate: Option[Date] = None,
    endDate: Option[Date] = None,
    usage: Option[Int] = None,
    isSystem: Option[Int] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None
) {

  def withId(value: Int): UPCModel = copy(id = value)
  def withCompanyId(value: Int): UPCModel = copy(companyId = Some(value))
  def withUpc(value: String): UPCModel = copy(upc = value)
  def withLegacyTaxCode(value: String): UPCModel = copy(legacyTaxCode = Some(value))
  def withDescription(value: String): UPCModel = copy(description = value)
  def withEffectiveDate(value: Date): UPCModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Date): UPCModel = copy(endDate = Some(value))
  def withUsage(value: Int): UPCModel = copy(usage = Some(value))
  def withIsSystem(value: Int): UPCModel = copy(isSystem = Some(value))
  def withCreatedDate(value: Date): UPCModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): UPCModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): UPCModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): UPCModel = copy(modifiedUserId = Some(value))
}
