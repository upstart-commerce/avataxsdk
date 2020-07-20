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

final case class SkyscraperStatusModel(
    name: Option[String] = None,
    taxFormCodes: Option[List[String]] = None,
    country: Option[String] = None,
    scraperType: Option[ScraperType] = None,
    isAvailable: Option[Boolean] = None,
    expectedResponseTime: Option[String] = None,
    message: Option[String] = None,
    requiredFilingCalendarDataFields: Option[List[RequiredFilingCalendarDataFieldModel]] = None
) {
  lazy val taxFormCodesRaw: List[String] = taxFormCodes.getOrElse(List.empty)
  lazy val requiredFilingCalendarDataFieldsRaw: List[RequiredFilingCalendarDataFieldModel] =
    requiredFilingCalendarDataFields.getOrElse(List.empty)
  def withName(value: String): SkyscraperStatusModel = copy(name = Some(value))
  def withTaxFormCodes(value: List[String]): SkyscraperStatusModel = copy(taxFormCodes = Some(value))
  def withCountry(value: String): SkyscraperStatusModel = copy(country = Some(value))
  def withScraperType(value: ScraperType): SkyscraperStatusModel = copy(scraperType = Some(value))
  def withIsAvailable(value: Boolean): SkyscraperStatusModel = copy(isAvailable = Some(value))
  def withExpectedResponseTime(value: String): SkyscraperStatusModel = copy(expectedResponseTime = Some(value))
  def withMessage(value: String): SkyscraperStatusModel = copy(message = Some(value))
  def withRequiredFilingCalendarDataFields(value: List[RequiredFilingCalendarDataFieldModel]): SkyscraperStatusModel =
    copy(requiredFilingCalendarDataFields = Some(value))
}
