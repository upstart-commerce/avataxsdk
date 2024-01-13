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
import org.upstartcommerce.avataxsdk.core.data.enums._
import org.upstartcommerce.avataxsdk.core.data.models._

/** api/v2/companies/$companyId/certificates */
trait CompanyCertificatesRootApi[F[_], S[_]] {
  def forId(certificateId: Int): CompanyCertificatesApi[F, S]
  def create(preValidatedExemptionReason: Boolean, model: List[CertificateModel]): AvataxSimpleCall[F, List[CertificateModel]]
  def getSetup: AvataxSimpleCall[F, ProvisionStatusModel]
  def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[F, S, CertificateModel]
  def requestSetup: AvataxSimpleCall[F, ProvisionStatusModel]
}

/** api/v2/companies/$companyId/certificates/$certificateId */
trait CompanyCertificatesApi[F[_], S[_]] {
  def delete: AvataxSimpleCall[F, CertificateModel]
  def downloadImage(page: Int, `type`: CertificatePreviewType): AvataxSimpleCall[F, String]
  def get(include: Include): AvataxSimpleCall[F, CertificateModel]
  def linkAttributes(model: List[CertificateAttributeModel]): AvataxCollectionCall[F, S, CertificateAttributeModel]
  def linkCustomers(model: LinkCustomersModel): AvataxCollectionCall[F, S, CustomerModel]
  def listAttributes: AvataxCollectionCall[F, S, CertificateAttributeModel]
  def listCustomers(include: Include): AvataxCollectionCall[F, S, CustomerModel]
  def unlinkAttributes(model: List[CertificateAttributeModel]): AvataxCollectionCall[F, S, CertificateAttributeModel]
  def unlinkCustomers(model: LinkCustomersModel): AvataxCollectionCall[F, S, CustomerModel]
  def update(model: CertificateModel): AvataxSimpleCall[F, CertificateModel]
  def uploadImage(file: String): AvataxSimpleCall[F, String]
}
