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

final case class NoticeResponsibilityDetailModel(
    id: Option[Int] = None,
    noticeId: Int,
    taxNoticeResponsibilityId: Int,
    description: Option[String] = None
) {

  def withId(value: Int): NoticeResponsibilityDetailModel = copy(id = Some(value))
  def withNoticeId(value: Int): NoticeResponsibilityDetailModel = copy(noticeId = value)
  def withTaxNoticeResponsibilityId(value: Int): NoticeResponsibilityDetailModel = copy(taxNoticeResponsibilityId = value)
  def withDescription(value: String): NoticeResponsibilityDetailModel = copy(description = Some(value))
}
