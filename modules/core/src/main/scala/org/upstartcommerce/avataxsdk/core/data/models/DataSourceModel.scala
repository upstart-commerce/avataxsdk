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
import java.time.Instant

final case class DataSourceModel(
    id: Option[Int] = None,
    companyId: Int,
    source: String,
    instance: Option[String] = None,
    isEnabled: Option[Boolean] = None,
    isSynced: Option[Boolean] = None,
    isAuthorized: Option[Boolean] = None,
    lastSyncedDate: Option[Instant] = None,
    createdUserId: Option[Int] = None,
    createdDate: Option[Instant] = None,
    modifiedUserId: Option[Int] = None,
    modifiedDate: Option[Instant] = None,
    deletedDate: Option[Instant] = None,
    recalculate: Option[Boolean] = None
) {

  def withId(value: Int): DataSourceModel = copy(id = Some(value))
  def withCompanyId(value: Int): DataSourceModel = copy(companyId = value)
  def withSource(value: String): DataSourceModel = copy(source = value)
  def withInstance(value: String): DataSourceModel = copy(instance = Some(value))
  def withIsEnabled(value: Boolean): DataSourceModel = copy(isEnabled = Some(value))
  def withIsSynced(value: Boolean): DataSourceModel = copy(isSynced = Some(value))
  def withIsAuthorized(value: Boolean): DataSourceModel = copy(isAuthorized = Some(value))
  def withLastSyncedDate(value: Instant): DataSourceModel = copy(lastSyncedDate = Some(value))
  def withCreatedUserId(value: Int): DataSourceModel = copy(createdUserId = Some(value))
  def withCreatedDate(value: Instant): DataSourceModel = copy(createdDate = Some(value))
  def withModifiedUserId(value: Int): DataSourceModel = copy(modifiedUserId = Some(value))
  def withModifiedDate(value: Instant): DataSourceModel = copy(modifiedDate = Some(value))
  def withDeletedDate(value: Instant): DataSourceModel = copy(deletedDate = Some(value))
  def withRecalculate(value: Boolean): DataSourceModel = copy(recalculate = Some(value))
}
