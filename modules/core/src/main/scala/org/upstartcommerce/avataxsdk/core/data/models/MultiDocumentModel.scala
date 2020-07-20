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

final case class MultiDocumentModel(
    id: Option[Long] = None,
    accountId: Option[Int] = None,
    code: Option[String] = None,
    `type`: Option[DocumentType] = None,
    createdUserId: Option[Int] = None,
    createdDate: Option[Date] = None,
    modifiedDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None,
    documents: Option[List[TransactionModel]] = None
) {
  lazy val documentsRaw: List[TransactionModel] = documents.getOrElse(List.empty)
  def withId(value: Long): MultiDocumentModel = copy(id = Some(value))
  def withAccountId(value: Int): MultiDocumentModel = copy(accountId = Some(value))
  def withCode(value: String): MultiDocumentModel = copy(code = Some(value))
  def withType(value: DocumentType): MultiDocumentModel = copy(`type` = Some(value))
  def withCreatedUserId(value: Int): MultiDocumentModel = copy(createdUserId = Some(value))
  def withCreatedDate(value: Date): MultiDocumentModel = copy(createdDate = Some(value))
  def withModifiedDate(value: Date): MultiDocumentModel = copy(modifiedDate = Some(value))
  def withModifiedUserId(value: Int): MultiDocumentModel = copy(modifiedUserId = Some(value))
  def withDocuments(value: List[TransactionModel]): MultiDocumentModel = copy(documents = Some(value))
}
