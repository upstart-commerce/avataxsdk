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

final case class TaxTypeGroupModel(
    id: Option[Int] = None,
    taxTypeGroup: Option[String] = None,
    description: Option[String] = None,
    subscriptionTypeId: Option[Int] = None,
    subscriptionDescription: Option[String] = None,
    tabName: Option[String] = None,
    showColumn: Option[Boolean] = None,
    displaySequence: Option[Int] = None
) {

  def withId(value: Int): TaxTypeGroupModel = copy(id = Some(value))
  def withTaxTypeGroup(value: String): TaxTypeGroupModel = copy(taxTypeGroup = Some(value))
  def withDescription(value: String): TaxTypeGroupModel = copy(description = Some(value))
  def withSubscriptionTypeId(value: Int): TaxTypeGroupModel = copy(subscriptionTypeId = Some(value))
  def withSubscriptionDescription(value: String): TaxTypeGroupModel = copy(subscriptionDescription = Some(value))
  def withTabName(value: String): TaxTypeGroupModel = copy(tabName = Some(value))
  def withShowColumn(value: Boolean): TaxTypeGroupModel = copy(showColumn = Some(value))
  def withDisplaySequence(value: Int): TaxTypeGroupModel = copy(displaySequence = Some(value))
}
