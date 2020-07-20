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

final case class AuditEvent(
    auditEventId: Option[Long] = None,
    transactionId: Option[Long] = None,
    auditEventLevelId: Option[Int] = None,
    eventTimestamp: Option[Date] = None,
    source: Option[String] = None,
    summary: Option[String] = None,
    details: Option[String] = None
) {

  def withAuditEventId(value: Long): AuditEvent = copy(auditEventId = Some(value))
  def withTransactionId(value: Long): AuditEvent = copy(transactionId = Some(value))
  def withAuditEventLevelId(value: Int): AuditEvent = copy(auditEventLevelId = Some(value))
  def withEventTimestamp(value: Date): AuditEvent = copy(eventTimestamp = Some(value))
  def withSource(value: String): AuditEvent = copy(source = Some(value))
  def withSummary(value: String): AuditEvent = copy(summary = Some(value))
  def withDetails(value: String): AuditEvent = copy(details = Some(value))
}
