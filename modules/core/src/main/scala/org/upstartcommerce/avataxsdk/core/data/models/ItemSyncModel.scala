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

final case class ItemSyncModel(itemCode: String, description: String, itemGroup: Option[String] = None, taxCode: Option[String] = None) {

  def withItemCode(value: String): ItemSyncModel = copy(itemCode = value)
  def withDescription(value: String): ItemSyncModel = copy(description = value)
  def withItemGroup(value: String): ItemSyncModel = copy(itemGroup = Some(value))
  def withTaxCode(value: String): ItemSyncModel = copy(taxCode = Some(value))
}
