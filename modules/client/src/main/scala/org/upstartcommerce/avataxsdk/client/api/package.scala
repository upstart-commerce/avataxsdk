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

package org.upstartcommerce.avataxsdk.client
import akka.http.scaladsl.model.Uri.Query
import org.upstartcommerce.avataxsdk.core.data._

package object api {
  implicit class QueryOptionsExt(private val q: QueryOptions) extends AnyVal {
    def asQuery: Query = {
      val required = q.top.map(x => "$top" -> x.toString).toList ++
        q.skip.map(x => "$skip" -> x.toString).toList

      val further = q match {
        case BasicQueryOptions(_, _) => List.empty
        case FiltrableQueryOptions(filter, _, _, orderBy) =>
          filter.map(x => "$filter" -> FilterAst.serialize(x)).toList ++
            orderBy.map(x => "$orderBy" -> OrderBy.serialize(x)).toList
      }

      val params = required ++ further
      Query(params: _*)
    }
  }

  implicit class QueryExt(private val q: Query) extends AnyVal {
    def and(key: String, value: String): Query = q.+:((key, value))
    def merge(other: Query): Query = Query(q ++ other: _*)
  }

  implicit class IncludeExt(private val q: Include) extends AnyVal {
    def asQuery: Query = {
      val includeStr = q.toInclude.mkString(",")
      if (q.toInclude.isEmpty) Query()
      else Query("$include" -> includeStr)
    }
  }
}
