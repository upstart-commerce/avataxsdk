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

package org.upstartcommerce.avataxsdk.client.api.companies

import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._

/** /api/v2/companies/$companyId/items */
trait CompanyItemsRootApi {
  def forItemId(itemId: Long): CompanyItemsApi

  def createItems(model: List[ItemModel]): AvataxSimpleCall[List[ItemModel]]
  def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[ItemModel]
}

/** /api/v2/companies/$companyId/items/$itemId */
trait CompanyItemsApi {
  def createClassifications(model: List[ItemClassificationInputModel]): AvataxSimpleCall[List[ItemClassificationOutputModel]]
  def createParameters(model: List[ItemParameterModel]): AvataxSimpleCall[List[ItemParameterModel]]
  def delete: AvataxSimpleCall[List[ErrorDetail]]
  def deleteClassification(classificationId: Long): AvataxSimpleCall[List[ErrorDetail]]
  def deleteParameter(parameterId: Long): AvataxSimpleCall[List[ErrorDetail]]
  def get(include: Include): AvataxSimpleCall[ItemModel]
  def getClassification(classificationId: Long): AvataxSimpleCall[ItemClassificationOutputModel]
  def getParameter(parameterId: Long): AvataxSimpleCall[ItemParameterModel]
  def listClassifications(options: FiltrableQueryOptions): AvataxCollectionCall[ItemClassificationOutputModel]
  def listParameters(options: FiltrableQueryOptions): AvataxCollectionCall[ItemParameterModel]
  def update(model: ItemModel): AvataxSimpleCall[ItemModel]
  def updateClassification(classificationsId: Long, model: ItemClassificationInputModel): AvataxSimpleCall[ItemClassificationOutputModel]
  def updateParameter(parameterId: Long, model: ItemParameterModel): AvataxSimpleCall[ItemParameterModel]
}
