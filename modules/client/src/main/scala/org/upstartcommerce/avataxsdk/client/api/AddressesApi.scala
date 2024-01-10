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

package org.upstartcommerce.avataxsdk.client.api

import org.upstartcommerce.avataxsdk.client.AvataxSimpleCall
import org.upstartcommerce.avataxsdk.core.data.models._

trait AddressesRootApi {
  def resolve(
      line1: String,
      line2: String,
      line3: String,
      city: String,
      region: String,
      postalCode: String,
      country: String,
      textCase: String
  ): AvataxSimpleCall[AddressResolutionModel]
  def resolvePost(model: AddressValidationInfo): AvataxSimpleCall[AddressResolutionModel]
}
