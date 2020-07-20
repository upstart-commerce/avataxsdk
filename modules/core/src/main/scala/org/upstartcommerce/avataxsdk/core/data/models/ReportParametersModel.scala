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

final case class ReportParametersModel(
    startDate: Option[Date] = None,
    endDate: Option[Date] = None,
    country: Option[String] = None,
    state: Option[String] = None,
    dateFilter: Option[String] = None,
    docType: Option[String] = None,
    dateFormat: Option[String] = None,
    culture: Option[String] = None,
    currencyCode: Option[String] = None
) {

  def withStartDate(value: Date): ReportParametersModel = copy(startDate = Some(value))
  def withEndDate(value: Date): ReportParametersModel = copy(endDate = Some(value))
  def withCountry(value: String): ReportParametersModel = copy(country = Some(value))
  def withState(value: String): ReportParametersModel = copy(state = Some(value))
  def withDateFilter(value: String): ReportParametersModel = copy(dateFilter = Some(value))
  def withDocType(value: String): ReportParametersModel = copy(docType = Some(value))
  def withDateFormat(value: String): ReportParametersModel = copy(dateFormat = Some(value))
  def withCulture(value: String): ReportParametersModel = copy(culture = Some(value))
  def withCurrencyCode(value: String): ReportParametersModel = copy(currencyCode = Some(value))
}
