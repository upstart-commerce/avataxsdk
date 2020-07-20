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

final case class TaxRegionJurisdictionModel(
    jurisdictionId: Option[Int] = None,
    taxRegionId: Option[Int] = None,
    jurisdictionLevelId: Option[Int] = None,
    rockName: Option[String] = None,
    reportLevel: Option[Int] = None,
    stateAssignedCode: Option[String] = None,
    taxAuthorityId: Option[Int] = None,
    signatureCode: Option[String] = None,
    effectiveDate: Option[Date] = None,
    endDate: Option[Date] = None
) {

  def withJurisdictionId(value: Int): TaxRegionJurisdictionModel = copy(jurisdictionId = Some(value))
  def withTaxRegionId(value: Int): TaxRegionJurisdictionModel = copy(taxRegionId = Some(value))
  def withJurisdictionLevelId(value: Int): TaxRegionJurisdictionModel = copy(jurisdictionLevelId = Some(value))
  def withRockName(value: String): TaxRegionJurisdictionModel = copy(rockName = Some(value))
  def withReportLevel(value: Int): TaxRegionJurisdictionModel = copy(reportLevel = Some(value))
  def withStateAssignedCode(value: String): TaxRegionJurisdictionModel = copy(stateAssignedCode = Some(value))
  def withTaxAuthorityId(value: Int): TaxRegionJurisdictionModel = copy(taxAuthorityId = Some(value))
  def withSignatureCode(value: String): TaxRegionJurisdictionModel = copy(signatureCode = Some(value))
  def withEffectiveDate(value: Date): TaxRegionJurisdictionModel = copy(effectiveDate = Some(value))
  def withEndDate(value: Date): TaxRegionJurisdictionModel = copy(endDate = Some(value))
}
