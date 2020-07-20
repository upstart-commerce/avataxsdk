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

final case class NotificationModel(
    id: Option[Long] = None,
    accountId: Option[Int] = None,
    companyId: Option[Int] = None,
    referenceObject: Option[String] = None,
    referenceId: Option[Long] = None,
    severityLevelId: NotificationSeverityLevel,
    category: Option[String] = None,
    topic: Option[String] = None,
    message: String,
    needsAction: Option[Boolean] = None,
    actionName: Option[String] = None,
    actionLink: Option[String] = None,
    actionDueDate: Option[Date] = None,
    dismissed: Option[Boolean] = None,
    dismissedByUserId: Option[Int] = None,
    dismissedDate: Option[Date] = None,
    expireDate: Date,
    createdUserId: Option[Int] = None,
    createdDate: Option[Date] = None,
    modifiedUserId: Option[Int] = None,
    modifiedDate: Option[Date] = None
) {

  def withId(value: Long): NotificationModel = copy(id = Some(value))
  def withAccountId(value: Int): NotificationModel = copy(accountId = Some(value))
  def withCompanyId(value: Int): NotificationModel = copy(companyId = Some(value))
  def withReferenceObject(value: String): NotificationModel = copy(referenceObject = Some(value))
  def withReferenceId(value: Long): NotificationModel = copy(referenceId = Some(value))
  def withSeverityLevelId(value: NotificationSeverityLevel): NotificationModel = copy(severityLevelId = value)
  def withCategory(value: String): NotificationModel = copy(category = Some(value))
  def withTopic(value: String): NotificationModel = copy(topic = Some(value))
  def withMessage(value: String): NotificationModel = copy(message = value)
  def withNeedsAction(value: Boolean): NotificationModel = copy(needsAction = Some(value))
  def withActionName(value: String): NotificationModel = copy(actionName = Some(value))
  def withActionLink(value: String): NotificationModel = copy(actionLink = Some(value))
  def withActionDueDate(value: Date): NotificationModel = copy(actionDueDate = Some(value))
  def withDismissed(value: Boolean): NotificationModel = copy(dismissed = Some(value))
  def withDismissedByUserId(value: Int): NotificationModel = copy(dismissedByUserId = Some(value))
  def withDismissedDate(value: Date): NotificationModel = copy(dismissedDate = Some(value))
  def withExpireDate(value: Date): NotificationModel = copy(expireDate = value)
  def withCreatedUserId(value: Int): NotificationModel = copy(createdUserId = Some(value))
  def withCreatedDate(value: Date): NotificationModel = copy(createdDate = Some(value))
  def withModifiedUserId(value: Int): NotificationModel = copy(modifiedUserId = Some(value))
  def withModifiedDate(value: Date): NotificationModel = copy(modifiedDate = Some(value))
}
