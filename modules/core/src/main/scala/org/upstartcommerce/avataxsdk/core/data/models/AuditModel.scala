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

final case class AuditModel(
    transactionId: Option[Long] = None,
    accountId: Option[Int] = None,
    userId: Option[Int] = None,
    ipAddress: Option[String] = None,
    machineName: Option[String] = None,
    clientName: Option[String] = None,
    clientVersion: Option[String] = None,
    adapterName: Option[String] = None,
    adapterVersion: Option[String] = None,
    serverName: Option[String] = None,
    serverVersion: Option[String] = None,
    referenceId: Option[Long] = None,
    severityLevelId: Option[Int] = None,
    serverTimestamp: Option[Date] = None,
    serverDuration: Option[Int] = None,
    serviceName: Option[String] = None,
    operation: Option[String] = None,
    referenceCode: Option[String] = None,
    errorMessage: Option[String] = None,
    auditMessage: Option[String] = None,
    loadBalancerDuration: Option[Int] = None,
    recordCount: Option[Int] = None,
    referenceAuthorization: Option[String] = None,
    isQueued: Option[Boolean] = None,
    databaseCallCount: Option[Int] = None,
    databaseCallDuration: Option[String] = None,
    remoteCallDuration: Option[String] = None,
    events: Option[List[AuditEvent]] = None,
    requestUrl: Option[String] = None,
    requestBody: Option[String] = None,
    responseStatus: Option[Int] = None,
    responseBody: Option[String] = None,
    remoteCalls: Option[List[AuditModel]] = None
) {
  lazy val eventsRaw: List[AuditEvent] = events.getOrElse(List.empty)
  lazy val remoteCallsRaw: List[AuditModel] = remoteCalls.getOrElse(List.empty)
  def withTransactionId(value: Long): AuditModel = copy(transactionId = Some(value))
  def withAccountId(value: Int): AuditModel = copy(accountId = Some(value))
  def withUserId(value: Int): AuditModel = copy(userId = Some(value))
  def withIpAddress(value: String): AuditModel = copy(ipAddress = Some(value))
  def withMachineName(value: String): AuditModel = copy(machineName = Some(value))
  def withClientName(value: String): AuditModel = copy(clientName = Some(value))
  def withClientVersion(value: String): AuditModel = copy(clientVersion = Some(value))
  def withAdapterName(value: String): AuditModel = copy(adapterName = Some(value))
  def withAdapterVersion(value: String): AuditModel = copy(adapterVersion = Some(value))
  def withServerName(value: String): AuditModel = copy(serverName = Some(value))
  def withServerVersion(value: String): AuditModel = copy(serverVersion = Some(value))
  def withReferenceId(value: Long): AuditModel = copy(referenceId = Some(value))
  def withSeverityLevelId(value: Int): AuditModel = copy(severityLevelId = Some(value))
  def withServerTimestamp(value: Date): AuditModel = copy(serverTimestamp = Some(value))
  def withServerDuration(value: Int): AuditModel = copy(serverDuration = Some(value))
  def withServiceName(value: String): AuditModel = copy(serviceName = Some(value))
  def withOperation(value: String): AuditModel = copy(operation = Some(value))
  def withReferenceCode(value: String): AuditModel = copy(referenceCode = Some(value))
  def withErrorMessage(value: String): AuditModel = copy(errorMessage = Some(value))
  def withAuditMessage(value: String): AuditModel = copy(auditMessage = Some(value))
  def withLoadBalancerDuration(value: Int): AuditModel = copy(loadBalancerDuration = Some(value))
  def withRecordCount(value: Int): AuditModel = copy(recordCount = Some(value))
  def withReferenceAuthorization(value: String): AuditModel = copy(referenceAuthorization = Some(value))
  def withIsQueued(value: Boolean): AuditModel = copy(isQueued = Some(value))
  def withDatabaseCallCount(value: Int): AuditModel = copy(databaseCallCount = Some(value))
  def withDatabaseCallDuration(value: String): AuditModel = copy(databaseCallDuration = Some(value))
  def withRemoteCallDuration(value: String): AuditModel = copy(remoteCallDuration = Some(value))
  def withEvents(value: List[AuditEvent]): AuditModel = copy(events = Some(value))
  def withRequestUrl(value: String): AuditModel = copy(requestUrl = Some(value))
  def withRequestBody(value: String): AuditModel = copy(requestBody = Some(value))
  def withResponseStatus(value: Int): AuditModel = copy(responseStatus = Some(value))
  def withResponseBody(value: String): AuditModel = copy(responseBody = Some(value))
  def withRemoteCalls(value: List[AuditModel]): AuditModel = copy(remoteCalls = Some(value))
}
