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

final case class AddTransactionLineModel(
    companyCode: String,
    transactionCode: String,
    documentType: Option[DocumentType] = None,
    lines: Option[List[LineItemModel]] = None,
    renumber: Option[Boolean] = None
) {
  lazy val linesRaw: List[LineItemModel] = lines.getOrElse(List.empty)
  def withCompanyCode(value: String): AddTransactionLineModel = copy(companyCode = value)
  def withTransactionCode(value: String): AddTransactionLineModel = copy(transactionCode = value)
  def withDocumentType(value: DocumentType): AddTransactionLineModel = copy(documentType = Some(value))
  def withLines(value: List[LineItemModel]): AddTransactionLineModel = copy(lines = Some(value))
  def withRenumber(value: Boolean): AddTransactionLineModel = copy(renumber = Some(value))
}
