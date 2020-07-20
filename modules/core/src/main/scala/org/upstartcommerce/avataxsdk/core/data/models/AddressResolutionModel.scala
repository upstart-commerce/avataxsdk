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

final case class AddressResolutionModel(
    address: Option[AddressInfo] = None,
    validatedAddresses: Option[List[ValidatedAddressInfo]] = None,
    coordinates: Option[CoordinateInfo] = None,
    resolutionQuality: Option[ResolutionQuality] = None,
    taxAuthorities: Option[List[TaxAuthorityInfo]] = None,
    messages: Option[List[AvaTaxMessage]] = None
) {
  lazy val validatedAddressesRaw: List[ValidatedAddressInfo] = validatedAddresses.getOrElse(List.empty)
  lazy val taxAuthoritiesRaw: List[TaxAuthorityInfo] = taxAuthorities.getOrElse(List.empty)
  lazy val messagesRaw: List[AvaTaxMessage] = messages.getOrElse(List.empty)
  def withAddress(value: AddressInfo): AddressResolutionModel = copy(address = Some(value))
  def withValidatedAddresses(value: List[ValidatedAddressInfo]): AddressResolutionModel = copy(validatedAddresses = Some(value))
  def withCoordinates(value: CoordinateInfo): AddressResolutionModel = copy(coordinates = Some(value))
  def withResolutionQuality(value: ResolutionQuality): AddressResolutionModel = copy(resolutionQuality = Some(value))
  def withTaxAuthorities(value: List[TaxAuthorityInfo]): AddressResolutionModel = copy(taxAuthorities = Some(value))
  def withMessages(value: List[AvaTaxMessage]): AddressResolutionModel = copy(messages = Some(value))
}
