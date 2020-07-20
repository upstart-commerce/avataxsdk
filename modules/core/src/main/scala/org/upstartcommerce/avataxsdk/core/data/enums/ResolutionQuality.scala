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

sealed trait ResolutionQuality
object ResolutionQuality {
  case object NotCoded extends ResolutionQuality
  case object External extends ResolutionQuality
  case object CountryCentroid extends ResolutionQuality
  case object RegionCentroid extends ResolutionQuality
  case object PartialCentroid extends ResolutionQuality
  case object PostalCentroidGood extends ResolutionQuality
  case object PostalCentroidBetter extends ResolutionQuality
  case object PostalCentroidBest extends ResolutionQuality
  case object Intersection extends ResolutionQuality
  case object Interpolated extends ResolutionQuality
  case object Rooftop extends ResolutionQuality
  case object Constant extends ResolutionQuality
}
