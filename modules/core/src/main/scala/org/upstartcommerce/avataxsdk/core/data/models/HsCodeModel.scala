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

final case class HsCodeModel(
    hsCode: Option[String] = None,
    id: Long,
    parentHsCodeId: Option[Long] = None,
    description: String,
    system: Option[String] = None,
    destinationCountry: Option[String] = None,
    effDate: Option[Date] = None,
    endDate: Option[Date] = None
) {

  def withHsCode(value: String): HsCodeModel = copy(hsCode = Some(value))
  def withId(value: Long): HsCodeModel = copy(id = value)
  def withParentHsCodeId(value: Long): HsCodeModel = copy(parentHsCodeId = Some(value))
  def withDescription(value: String): HsCodeModel = copy(description = value)
  def withSystem(value: String): HsCodeModel = copy(system = Some(value))
  def withDestinationCountry(value: String): HsCodeModel = copy(destinationCountry = Some(value))
  def withEffDate(value: Date): HsCodeModel = copy(effDate = Some(value))
  def withEndDate(value: Date): HsCodeModel = copy(endDate = Some(value))
}
