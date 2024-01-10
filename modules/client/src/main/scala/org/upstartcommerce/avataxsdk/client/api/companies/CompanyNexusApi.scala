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

/** /api/v2/companies/$companyId/nexus */
trait CompanyNexusRootApi {
  def forNexusId(nexusId: Int): CompanyNexusApi

  def create(model: List[NexusModel]): AvataxSimpleCall[List[NexusModel]]
  def declareByAddress(model: List[DeclareNexusByAddressModel]): AvataxSimpleCall[List[NexusByAddressModel]]
  def getByFormCode(formCode: String): AvataxSimpleCall[NexusByTaxFormModel]
  def listByCompany(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[NexusModel]
}

/** /api/v2/companies/$companyId/nexus/$nexusId */
trait CompanyNexusApi {
  def delete: AvataxSimpleCall[List[ErrorDetail]]
  def get: AvataxSimpleCall[NexusModel]
  def update(model: NexusModel): AvataxSimpleCall[NexusModel]
}
