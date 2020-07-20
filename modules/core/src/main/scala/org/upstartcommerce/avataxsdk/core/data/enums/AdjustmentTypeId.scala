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

sealed trait AdjustmentTypeId
object AdjustmentTypeId {
  case object Other extends AdjustmentTypeId
  case object CurrentPeriodRounding extends AdjustmentTypeId
  case object PriorPeriodRounding extends AdjustmentTypeId
  case object CurrentPeriodDiscount extends AdjustmentTypeId
  case object PriorPeriodDiscount extends AdjustmentTypeId
  case object Penalty extends AdjustmentTypeId
  case object Interest extends AdjustmentTypeId
  case object Discount extends AdjustmentTypeId
  case object Rounding extends AdjustmentTypeId
  case object CspFree extends AdjustmentTypeId
  case object Marketplace extends AdjustmentTypeId
}
