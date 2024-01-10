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
trait CompanyCustomersRootApi {
  def forCustomerCode(code: String): CompanyCustomersApi

  def create(model: List[CustomerModel]): AvataxSimpleCall[List[CustomerModel]]
  def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[CustomerModel]
}

/** api/v2/companies/$companyId/customers/$customerCode */
trait CompanyCustomersApi {
  def certExpressInvites: CompanyCustomerCertExpressInvitationRootApi
  def certificates: CompanyCustomerCertificatesRootApi

  def deleteCustomer(companyId: Int, customerCode: String): AvataxSimpleCall[CustomerModel]
  def get(include: Include): AvataxSimpleCall[CustomerModel]
  def linkCertificates(model: LinkCertificatesModel): AvataxCollectionCall[CertificateModel]
  def linkShipToToBillCustomer(model: LinkCustomersModel): AvataxSimpleCall[CustomerModel]
  def update(model: CustomerModel): AvataxSimpleCall[CustomerModel]
}
