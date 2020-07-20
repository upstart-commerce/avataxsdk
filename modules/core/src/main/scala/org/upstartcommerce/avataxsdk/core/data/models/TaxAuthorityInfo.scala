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

final case class TaxAuthorityInfo(
    avalaraId: Option[String] = None,
    jurisdictionName: String,
    jurisdictionType: Option[JurisdictionType] = None,
    signatureCode: Option[String] = None
) {

  def withAvalaraId(value: String): TaxAuthorityInfo = copy(avalaraId = Some(value))
  def withJurisdictionName(value: String): TaxAuthorityInfo = copy(jurisdictionName = value)
  def withJurisdictionType(value: JurisdictionType): TaxAuthorityInfo = copy(jurisdictionType = Some(value))
  def withSignatureCode(value: String): TaxAuthorityInfo = copy(signatureCode = Some(value))
}
