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

final case class ItemClassificationOutputModel(
    id: Option[Long] = None,
    itemId: Option[Long] = None,
    systemId: Option[Int] = None,
    productCode: Option[String] = None,
    systemCode: Option[String] = None
) {

  def withId(value: Long): ItemClassificationOutputModel = copy(id = Some(value))
  def withItemId(value: Long): ItemClassificationOutputModel = copy(itemId = Some(value))
  def withSystemId(value: Int): ItemClassificationOutputModel = copy(systemId = Some(value))
  def withProductCode(value: String): ItemClassificationOutputModel = copy(productCode = Some(value))
  def withSystemCode(value: String): ItemClassificationOutputModel = copy(systemCode = Some(value))
}
