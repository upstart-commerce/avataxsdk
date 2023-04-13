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

package org.upstartcommerce.avataxsdk.core.data.enums

sealed trait TaxType
object TaxType {
  case object Mattress extends TaxType
  case object Sales extends TaxType
  case object Use extends TaxType
  case object ConsumerUse extends TaxType
  case object Output extends TaxType
  case object Input extends TaxType
  case object Nonrecoverable extends TaxType
  case object Fee extends TaxType
  case object Rental extends TaxType
  case object Excise extends TaxType
  case object Lodging extends TaxType
  case object Bottle extends TaxType
  case object EWaste extends TaxType
  case object LandedCost extends TaxType
}
