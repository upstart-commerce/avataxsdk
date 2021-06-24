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

final case class CoverLetterModel(
    id: Option[Int] = None,
    companyId: Option[Int] = None,
    title: Option[String] = None,
    subject: Option[String] = None,
    description: Option[String] = None,
    createdDate: Option[Instant] = None,
    modifiedDate: Option[Instant] = None,
    active: Option[Boolean] = None,
    pageCount: Option[Int] = None,
    templateFilename: Option[String] = None,
    version: Option[Int] = None
) {

  def withId(value: Int): CoverLetterModel = copy(id = Some(value))
  def withCompanyId(value: Int): CoverLetterModel = copy(companyId = Some(value))
  def withTitle(value: String): CoverLetterModel = copy(title = Some(value))
  def withSubject(value: String): CoverLetterModel = copy(subject = Some(value))
  def withDescription(value: String): CoverLetterModel = copy(description = Some(value))
  def withCreatedDate(value: Instant): CoverLetterModel = copy(createdDate = Some(value))
  def withModifiedDate(value: Instant): CoverLetterModel = copy(modifiedDate = Some(value))
  def withActive(value: Boolean): CoverLetterModel = copy(active = Some(value))
  def withPageCount(value: Int): CoverLetterModel = copy(pageCount = Some(value))
  def withTemplateFilename(value: String): CoverLetterModel = copy(templateFilename = Some(value))
  def withVersion(value: Int): CoverLetterModel = copy(version = Some(value))
}
