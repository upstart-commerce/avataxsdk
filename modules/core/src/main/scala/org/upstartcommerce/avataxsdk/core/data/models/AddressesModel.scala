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

final case class AddressesModel(
    singleLocation: Option[AddressLocationInfo] = None,
    shipFrom: Option[AddressLocationInfo] = None,
    shipTo: Option[AddressLocationInfo] = None,
    pointOfOrderOrigin: Option[AddressLocationInfo] = None,
    pointOfOrderAcceptance: Option[AddressLocationInfo] = None
) {

  def withSingleLocation(value: AddressLocationInfo): AddressesModel = copy(singleLocation = Some(value))
  def withShipFrom(value: AddressLocationInfo): AddressesModel = copy(shipFrom = Some(value))
  def withShipTo(value: AddressLocationInfo): AddressesModel = copy(shipTo = Some(value))
  def withPointOfOrderOrigin(value: AddressLocationInfo): AddressesModel = copy(pointOfOrderOrigin = Some(value))
  def withPointOfOrderAcceptance(value: AddressLocationInfo): AddressesModel = copy(pointOfOrderAcceptance = Some(value))
}
