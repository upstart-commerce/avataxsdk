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

/** /api/v2/companies/$companyId/nexus */
trait CompanyNexusRootApi[F[_], S[_]] {
  def forNexusId(nexusId: Int): CompanyNexusApi[F, S]

  def create(model: List[NexusModel]): AvataxSimpleCall[F, List[NexusModel]]
  def declareByAddress(model: List[DeclareNexusByAddressModel]): AvataxSimpleCall[F, List[NexusByAddressModel]]
  def getByFormCode(formCode: String): AvataxSimpleCall[F, NexusByTaxFormModel]
  def listByCompany(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, NexusModel]
}

/** /api/v2/companies/$companyId/nexus/$nexusId */
trait CompanyNexusApi[F[_], S[_]] {
  def delete: AvataxSimpleCall[F, List[ErrorDetail]]
  def get: AvataxSimpleCall[F, NexusModel]
  def update(model: NexusModel): AvataxSimpleCall[F, NexusModel]
}
