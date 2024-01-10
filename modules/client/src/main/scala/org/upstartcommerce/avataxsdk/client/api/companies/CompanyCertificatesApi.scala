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

/** api/v2/companies/$companyId/certificates */
trait CompanyCertificatesRootApi {
  def forId(certificateId: Int): CompanyCertificatesApi
  def create(preValidatedExemptionReason: Boolean, model: List[CertificateModel]): AvataxSimpleCall[List[CertificateModel]]
  def getSetup: AvataxSimpleCall[ProvisionStatusModel]
  def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[CertificateModel]
  def requestSetup: AvataxSimpleCall[ProvisionStatusModel]
}

/** api/v2/companies/$companyId/certificates/$certificateId */
trait CompanyCertificatesApi {
  def delete: AvataxSimpleCall[CertificateModel]
  def downloadImage(page: Int, `type`: CertificatePreviewType): AvataxSimpleCall[String]
  def get(include: Include): AvataxSimpleCall[CertificateModel]
  def linkAttributes(model: List[CertificateAttributeModel]): AvataxCollectionCall[CertificateAttributeModel]
  def linkCustomers(model: LinkCustomersModel): AvataxCollectionCall[CustomerModel]
  def listAttributes: AvataxCollectionCall[CertificateAttributeModel]
  def listCustomers(include: Include): AvataxCollectionCall[CustomerModel]
  def unlinkAttributes(model: List[CertificateAttributeModel]): AvataxCollectionCall[CertificateAttributeModel]
  def unlinkCustomers(model: LinkCustomersModel): AvataxCollectionCall[CustomerModel]
  def update(model: CertificateModel): AvataxSimpleCall[CertificateModel]
  def uploadImage(file: String): AvataxSimpleCall[String]
}
