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

import org.upstartcommerce.avataxsdk.core.data.enums._

final case class RefundTransactionModel(
    refundTransactionCode: Option[String] = None,
    refundDate: Instant,
    refundType: Option[RefundType] = None,
    refundPercentage: Option[BigDecimal] = None,
    refundLines: Option[List[String]] = None,
    referenceCode: Option[String] = None
) {
  lazy val refundLinesRaw: List[String] = refundLines.getOrElse(List.empty)

  def withRefundTransactionCode(value: String): RefundTransactionModel = copy(refundTransactionCode = Some(value))

  def withRefundDate(value: Instant): RefundTransactionModel = copy(refundDate = value)

  def withRefundType(value: RefundType): RefundTransactionModel = copy(refundType = Some(value))

  def withRefundPercentage(value: BigDecimal): RefundTransactionModel = copy(refundPercentage = Some(value))

  def withRefundLines(value: List[String]): RefundTransactionModel = copy(refundLines = Some(value))

  def withReferenceCode(value: String): RefundTransactionModel = copy(referenceCode = Some(value))
}
