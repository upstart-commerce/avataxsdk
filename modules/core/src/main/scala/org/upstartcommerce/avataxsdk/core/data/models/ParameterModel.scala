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

final case class ParameterModel(
    id: Option[Long] = None,
    category: Option[String] = None,
    name: Option[String] = None,
    dataType: Option[String] = None,
    helpText: Option[String] = None,
    serviceTypes: Option[List[String]] = None,
    prompt: Option[String] = None,
    regularExpression: Option[String] = None,
    label: Option[String] = None,
    helpUrl: Option[String] = None,
    attributeType: Option[String] = None,
    values: Option[List[String]] = None,
    measurementType: Option[String] = None
) {
  lazy val serviceTypesRaw: List[String] = serviceTypes.getOrElse(List.empty)
  lazy val valuesRaw: List[String] = values.getOrElse(List.empty)
  def withId(value: Long): ParameterModel = copy(id = Some(value))
  def withCategory(value: String): ParameterModel = copy(category = Some(value))
  def withName(value: String): ParameterModel = copy(name = Some(value))
  def withDataType(value: String): ParameterModel = copy(dataType = Some(value))
  def withHelpText(value: String): ParameterModel = copy(helpText = Some(value))
  def withServiceTypes(value: List[String]): ParameterModel = copy(serviceTypes = Some(value))
  def withPrompt(value: String): ParameterModel = copy(prompt = Some(value))
  def withRegularExpression(value: String): ParameterModel = copy(regularExpression = Some(value))
  def withLabel(value: String): ParameterModel = copy(label = Some(value))
  def withHelpUrl(value: String): ParameterModel = copy(helpUrl = Some(value))
  def withAttributeType(value: String): ParameterModel = copy(attributeType = Some(value))
  def withValues(value: List[String]): ParameterModel = copy(values = Some(value))
  def withMeasurementType(value: String): ParameterModel = copy(measurementType = Some(value))
}
