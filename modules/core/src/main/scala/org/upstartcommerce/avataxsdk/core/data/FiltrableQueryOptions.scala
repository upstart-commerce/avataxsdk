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

package org.upstartcommerce.avataxsdk.core.data
import org.upstartcommerce.avataxsdk.core.data.OrderBy.OrderByClause

sealed trait QueryOptions {
  def top: Option[Int]
  def skip: Option[Int]
}

final case class BasicQueryOptions(top: Option[Int], skip: Option[Int]) extends QueryOptions {
  def withTop(top: Int): BasicQueryOptions = copy(top = Some(top))
  def withSkip(skip: Int): BasicQueryOptions = copy(skip = Some(skip))
}

object QueryOptions {
  def basic(top: Option[Int] = None, skip: Option[Int] = None): BasicQueryOptions =
    BasicQueryOptions(top, skip)

  def filtrable(filter: Option[FilterAst], top: Option[Int], skip: Option[Int], orderBy: Option[OrderByClause]): FiltrableQueryOptions =
    FiltrableQueryOptions(filter, top, skip, orderBy)
}

final case class FiltrableQueryOptions(
    filter: Option[FilterAst] = None,
    top: Option[Int] = None,
    skip: Option[Int] = None,
    orderBy: Option[OrderByClause] = None
) extends QueryOptions {
  def withFilter(filter: FilterAst): FiltrableQueryOptions = copy(filter = Some(filter))
  def withTop(top: Int): FiltrableQueryOptions = copy(top = Some(top))
  def withSkip(skip: Int): FiltrableQueryOptions = copy(skip = Some(skip))
  def withOrderBy(orderBy: OrderByClause): FiltrableQueryOptions = copy(orderBy = Some(orderBy))
}

final case class Include(toInclude: List[String] = List.empty) {
  override def toString: String = toInclude.mkString(",")
  def and(other: String): Include = Include(toInclude :+ other)
  def merge(other: Include): Include = Include(toInclude ++ other.toInclude)
}
