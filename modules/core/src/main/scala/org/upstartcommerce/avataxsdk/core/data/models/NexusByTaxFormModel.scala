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

final case class NexusByTaxFormModel(
    formCode: Option[String] = None,
    companyId: Option[Int] = None,
    nexusDefinitions: Option[List[NexusModel]] = None,
    companyNexus: Option[List[NexusModel]] = None
) {
  lazy val nexusDefinitionsRaw: List[NexusModel] = nexusDefinitions.getOrElse(List.empty)
  lazy val companyNexusRaw: List[NexusModel] = companyNexus.getOrElse(List.empty)
  def withFormCode(value: String): NexusByTaxFormModel = copy(formCode = Some(value))
  def withCompanyId(value: Int): NexusByTaxFormModel = copy(companyId = Some(value))
  def withNexusDefinitions(value: List[NexusModel]): NexusByTaxFormModel = copy(nexusDefinitions = Some(value))
  def withCompanyNexus(value: List[NexusModel]): NexusByTaxFormModel = copy(companyNexus = Some(value))
}
