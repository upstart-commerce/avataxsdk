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

final case class FundingConfigurationModel(
    companyId: Option[Int] = None,
    systemType: Option[String] = None,
    currency: Option[String] = None,
    isFundingSetup: Option[Boolean] = None,
    fundingMethod: Option[String] = None,
    lastUpdated: Option[Date] = None
) {

  def withCompanyId(value: Int): FundingConfigurationModel = copy(companyId = Some(value))
  def withSystemType(value: String): FundingConfigurationModel = copy(systemType = Some(value))
  def withCurrency(value: String): FundingConfigurationModel = copy(currency = Some(value))
  def withIsFundingSetup(value: Boolean): FundingConfigurationModel = copy(isFundingSetup = Some(value))
  def withFundingMethod(value: String): FundingConfigurationModel = copy(fundingMethod = Some(value))
  def withLastUpdated(value: Date): FundingConfigurationModel = copy(lastUpdated = Some(value))
}
