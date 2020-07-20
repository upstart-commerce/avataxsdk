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

final case class UomModel(
    id: Option[Int] = None,
    code: Option[String] = None,
    shortDesc: Option[String] = None,
    description: Option[String] = None,
    measurementTypeId: Option[Int] = None,
    measurementTypeCode: Option[String] = None,
    siUOM: Option[String] = None,
    measurementTypeDescription: Option[String] = None,
    isSiUom: Option[Boolean] = None
) {

  def withId(value: Int): UomModel = copy(id = Some(value))
  def withCode(value: String): UomModel = copy(code = Some(value))
  def withShortDesc(value: String): UomModel = copy(shortDesc = Some(value))
  def withDescription(value: String): UomModel = copy(description = Some(value))
  def withMeasurementTypeId(value: Int): UomModel = copy(measurementTypeId = Some(value))
  def withMeasurementTypeCode(value: String): UomModel = copy(measurementTypeCode = Some(value))
  def withSiUOM(value: String): UomModel = copy(siUOM = Some(value))
  def withMeasurementTypeDescription(value: String): UomModel = copy(measurementTypeDescription = Some(value))
  def withIsSiUom(value: Boolean): UomModel = copy(isSiUom = Some(value))
}
