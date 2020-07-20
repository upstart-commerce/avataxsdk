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

sealed trait ServiceTypeId
object ServiceTypeId {
  case object None extends ServiceTypeId
  case object AvaTaxST extends ServiceTypeId
  case object AvaTaxPro extends ServiceTypeId
  case object AvaTaxGlobal extends ServiceTypeId
  case object AutoAddress extends ServiceTypeId
  case object AutoReturns extends ServiceTypeId
  case object TaxSolver extends ServiceTypeId
  case object AvaTaxCsp extends ServiceTypeId
  case object Twe extends ServiceTypeId
  case object Mrs extends ServiceTypeId
  case object AvaCert extends ServiceTypeId
  case object AuthorizationPartner extends ServiceTypeId
  case object CertCapture extends ServiceTypeId
  case object AvaUpc extends ServiceTypeId
  case object AvaCUT extends ServiceTypeId
  case object AvaLandedCost extends ServiceTypeId
  case object AvaLodging extends ServiceTypeId
  case object AvaBottle extends ServiceTypeId
  case object AvaComms extends ServiceTypeId
  case object AvaEWaste extends ServiceTypeId
  case object AvaExemptTier1 extends ServiceTypeId
  case object AvaExemptTier2 extends ServiceTypeId
  case object AvaExemptTier3 extends ServiceTypeId
  case object AvaExemptTier4 extends ServiceTypeId
  case object MRSComplianceManager extends ServiceTypeId
  case object AvaBikeTax extends ServiceTypeId
  case object AvaCheckoutBag extends ServiceTypeId
  case object TFOCompliance extends ServiceTypeId
  case object SendSalesRateFile extends ServiceTypeId
}
