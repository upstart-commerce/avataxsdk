/* Copyright 2024 UpStart Commerce, Inc.
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

package org.upstartcommerce.avataxsdk.client.api.companies

import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._

/** /api/v2/companies/$companyId/items */
trait CompanyItemsRootApi[F[_], S[_]] {
  def forItemId(itemId: Long): CompanyItemsApi[F, S]

  def createItems(model: List[ItemModel]): AvataxSimpleCall[F, List[ItemModel]]
  def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, ItemModel]
}

/** /api/v2/companies/$companyId/items/$itemId */
trait CompanyItemsApi[F[_], S[_]] {
  def createClassifications(model: List[ItemClassificationInputModel]): AvataxSimpleCall[F, List[ItemClassificationOutputModel]]
  def createParameters(model: List[ItemParameterModel]): AvataxSimpleCall[F, List[ItemParameterModel]]
  def delete: AvataxSimpleCall[F, List[ErrorDetail]]
  def deleteClassification(classificationId: Long): AvataxSimpleCall[F, List[ErrorDetail]]
  def deleteParameter(parameterId: Long): AvataxSimpleCall[F, List[ErrorDetail]]
  def get(include: Include): AvataxSimpleCall[F, ItemModel]
  def getClassification(classificationId: Long): AvataxSimpleCall[F, ItemClassificationOutputModel]
  def getParameter(parameterId: Long): AvataxSimpleCall[F, ItemParameterModel]
  def listClassifications(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, ItemClassificationOutputModel]
  def listParameters(options: FiltrableQueryOptions): AvataxCollectionCall[F, S, ItemParameterModel]
  def update(model: ItemModel): AvataxSimpleCall[F, ItemModel]
  def updateClassification(classificationsId: Long, model: ItemClassificationInputModel): AvataxSimpleCall[F, ItemClassificationOutputModel]
  def updateParameter(parameterId: Long, model: ItemParameterModel): AvataxSimpleCall[F, ItemParameterModel]
}
