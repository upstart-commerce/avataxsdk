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

final case class BatchModel(
    id: Option[Int] = None,
    name: String,
    accountId: Option[Int] = None,
    companyId: Option[Int] = None,
    `type`: BatchType,
    status: Option[BatchStatus] = None,
    options: Option[String] = None,
    batchAgent: Option[String] = None,
    startedDate: Option[Date] = None,
    recordCount: Option[Int] = None,
    currentRecord: Option[Int] = None,
    completedDate: Option[Date] = None,
    createdDate: Option[Date] = None,
    createdUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None,
    files: Option[List[BatchFileModel]] = None
) {
  lazy val filesRaw: List[BatchFileModel] = files.getOrElse(List.empty)
  def withId(value: Int): BatchModel = copy(id = Some(value))
  def withName(value: String): BatchModel = copy(name = value)
  def withAccountId(value: Int): BatchModel = copy(accountId = Some(value))
  def withCompanyId(value: Int): BatchModel = copy(companyId = Some(value))
  def withType(value: BatchType): BatchModel = copy(`type` = value)
  def withStatus(value: BatchStatus): BatchModel = copy(status = Some(value))
  def withOptions(value: String): BatchModel = copy(options = Some(value))
  def withBatchAgent(value: String): BatchModel = copy(batchAgent = Some(value))
  def withStartedDate(value: Date): BatchModel = copy(startedDate = Some(value))
  def withRecordCount(value: Int): BatchModel = copy(recordCount = Some(value))
  def withCurrentRecord(value: Int): BatchModel = copy(currentRecord = Some(value))
  def withCompletedDate(value: Date): BatchModel = copy(completedDate = Some(value))
  def withCreatedDate(value: Date): BatchModel = copy(createdDate = Some(value))
  def withCreatedUserId(value: Int): BatchModel = copy(createdUserId = Some(value))
  def withModifiedDate(value: Date): BatchModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): BatchModel = copy(modifiedUserId = Some(value))
  def withFiles(value: List[BatchFileModel]): BatchModel = copy(files = Some(value))
}
