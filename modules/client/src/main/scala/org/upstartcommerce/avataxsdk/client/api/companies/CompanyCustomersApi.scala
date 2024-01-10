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
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders

/** api/v2/companies/$companyId/customers */
trait CompanyCustomersRootApi[F[_], S[_]] {
  def forCustomerCode(code: String): CompanyCustomersApi[F, S]

  def create(model: List[CustomerModel]): AvataxSimpleCall[F, List[CustomerModel]]
  def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, CustomerModel]
}

/** api/v2/companies/$companyId/customers/$customerCode */
trait CompanyCustomersApi[F[_], S[_]] {
  def certExpressInvites: CompanyCustomerCertExpressInvitationRootApi[F, S]
  def certificates: CompanyCustomerCertificatesRootApi[F, S]

  def deleteCustomer(companyId: Int, customerCode: String): AvataxSimpleCall[F, CustomerModel]
  def get(include: Include): AvataxSimpleCall[F, CustomerModel]
  def linkCertificates(model: LinkCertificatesModel): AvataxCollectionCall[F, S, CertificateModel]
  def linkShipToToBillCustomer(model: LinkCustomersModel): AvataxSimpleCall[F, CustomerModel]
  def update(model: CustomerModel): AvataxSimpleCall[F, CustomerModel]
}
