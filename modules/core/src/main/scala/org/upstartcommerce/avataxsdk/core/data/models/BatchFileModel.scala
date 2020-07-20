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

final case class BatchFileModel(
    id: Option[Int] = None,
    batchId: Option[Int] = None,
    name: Option[String] = None,
    content: String,
    contentLength: Option[Int] = None,
    contentType: Option[String] = None,
    fileExtension: Option[String] = None,
    filePath: Option[String] = None,
    errorCount: Option[Int] = None
) {

  def withId(value: Int): BatchFileModel = copy(id = Some(value))
  def withBatchId(value: Int): BatchFileModel = copy(batchId = Some(value))
  def withName(value: String): BatchFileModel = copy(name = Some(value))
  def withContent(value: String): BatchFileModel = copy(content = value)
  def withContentLength(value: Int): BatchFileModel = copy(contentLength = Some(value))
  def withContentType(value: String): BatchFileModel = copy(contentType = Some(value))
  def withFileExtension(value: String): BatchFileModel = copy(fileExtension = Some(value))
  def withFilePath(value: String): BatchFileModel = copy(filePath = Some(value))
  def withErrorCount(value: Int): BatchFileModel = copy(errorCount = Some(value))
}
