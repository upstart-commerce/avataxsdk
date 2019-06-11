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

final case class ResourceFileUploadRequestModel(content: Byte,
                                                username: Option[String] = None,
                                                accountId: Option[Int] = None,
                                                companyId: Option[Int] = None,
                                                name: Option[String] = None,
                                                resourceFileTypeId: Option[Int] = None,
                                                length: Option[Long] = None) {

  def withContent(value: Byte): ResourceFileUploadRequestModel = copy(content = value)

  def withUsername(value: String): ResourceFileUploadRequestModel = copy(username = Some(value))

  def withAccountId(value: Int): ResourceFileUploadRequestModel = copy(accountId = Some(value))

  def withCompanyId(value: Int): ResourceFileUploadRequestModel = copy(companyId = Some(value))

  def withName(value: String): ResourceFileUploadRequestModel = copy(name = Some(value))

  def withResourceFileTypeId(value: Int): ResourceFileUploadRequestModel = copy(resourceFileTypeId = Some(value))

  def withLength(value: Long): ResourceFileUploadRequestModel = copy(length = Some(value))
}
