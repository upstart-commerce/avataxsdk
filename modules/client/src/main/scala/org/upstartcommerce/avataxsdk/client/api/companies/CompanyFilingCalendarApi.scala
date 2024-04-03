/* Copyright 2024 UpStart Commerce, Inc.
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

package org.upstartcommerce.avataxsdk.client.api.companies

import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._

/** /api/v2/companies/$companyId/filingcalendars/ */
trait CompanyFilingCalendarRootApi[F[_], S[_]] {
  def forFilingCalendarId(filingCalendarId: Int): CompanyFilingCalendarApi[F, S]

  def create(model: List[FilingCalendarModel]): AvataxSimpleCall[F, FilingCalendarModel]
  def createRequest(model: List[FilingRequestModel]): AvataxSimpleCall[F, FilingRequestModel]
  def cycleSafeAdd(formCode: String): AvataxSimpleCall[F, List[CycleAddOptionModel]]
  def list(
      returnCountry: String,
      returnRegion: String,
      include: Include,
      options: FiltrableQueryOptions
  ): AvataxCollectionCall[F, S, FilingCalendarModel]
}

/** /api/v2/companies/$companyId/filingcalendars/$filingCalendarId */
trait CompanyFilingCalendarApi[F[_], S[_]] {
  def cancelRequests(model: List[FilingRequestModel]): AvataxSimpleCall[F, FilingRequestModel]
  def cycleSafeEdit(model: List[FilingCalendarEditModel]): AvataxSimpleCall[F, CycleEditOptionModel]
  def cycleSafeExpiration: AvataxSimpleCall[F, CycleExpireModel]
  def delete: AvataxSimpleCall[F, List[ErrorDetail]]
  def get: AvataxSimpleCall[F, FilingCalendarModel]
  def requestUpdate(model: List[FilingRequestModel]): AvataxSimpleCall[F, FilingRequestModel]
  def update(model: FilingCalendarModel): AvataxSimpleCall[F, FilingCalendarModel]
}
