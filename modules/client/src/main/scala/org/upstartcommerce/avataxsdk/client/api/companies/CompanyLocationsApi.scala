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
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders

/** /api/v2/companies/$companyId/locations */
trait CompanyLocationsRootApi {
  def forLocationId(locationId: Int): CompanyLocationsApi

  def create(model: List[LocationModel]): AvataxSimpleCall[List[LocationModel]]
  def list(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[LocationModel]
}

/** /api/v2/companies/$companyId/locations/$locationId */
trait CompanyLocationsApi {
  def delete: AvataxSimpleCall[List[ErrorDetail]]
  def get(include: Include): AvataxSimpleCall[LocationModel]
  def update(model: LocationModel): AvataxSimpleCall[LocationModel]
  def validate: AvataxSimpleCall[LocationValidationModel]
  def buildTaxContentForLocation(
      date: java.util.Date,
      format: PointOfSaleFileType,
      partner: PointOfSalePartnerId,
      includeJurisCodes: Boolean
  ): AvataxSimpleCall[String]
}
