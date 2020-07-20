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

final case class ReportModel(
    id: Option[Long] = None,
    accountId: Option[Int] = None,
    companyId: Option[Int] = None,
    reportType: Option[String] = None,
    parameters: Option[ReportParametersModel] = None,
    status: Option[String] = None,
    size: Option[Int] = None,
    format: Option[String] = None,
    file: Option[String] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    createdUser: Option[String] = None,
    completedDate: Option[Date] = None
) {

  def withId(value: Long): ReportModel = copy(id = Some(value))
  def withAccountId(value: Int): ReportModel = copy(accountId = Some(value))
  def withCompanyId(value: Int): ReportModel = copy(companyId = Some(value))
  def withReportType(value: String): ReportModel = copy(reportType = Some(value))
  def withParameters(value: ReportParametersModel): ReportModel = copy(parameters = Some(value))
  def withStatus(value: String): ReportModel = copy(status = Some(value))
  def withSize(value: Int): ReportModel = copy(size = Some(value))
  def withFormat(value: String): ReportModel = copy(format = Some(value))
  def withFile(value: String): ReportModel = copy(file = Some(value))
  def withCreatedDate(value: Date): ReportModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): ReportModel = copy(createdUserId = Some(value))
  def withCreatedUser(value: String): ReportModel = copy(createdUser = Some(value))
  def withCompletedDate(value: Date): ReportModel = copy(completedDate = Some(value))
}
