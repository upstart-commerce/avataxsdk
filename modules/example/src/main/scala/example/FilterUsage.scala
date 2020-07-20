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

package example

import org.upstartcommerce.avataxsdk.core.data.FilterAst.syntax._
import org.upstartcommerce.avataxsdk.core.data.FilterAst._

object FilterUsage extends App {

  val s1 = (field("field1") === literal("bar")).bracket && (field("field2") !== field("field3"))
  println(serialize(s1))

  val s2 = field("taxDate").between(literal("2016-01-01"), literal("2016-02-01")) && field("status") === literal("committed")
  println(serialize(s2))

  val s3 = ((field("country") === literal("US")) and (field("region") === literal("CA"))).bracket or (field("contry") === literal("CA")).bracket
  println(serialize(s3))

  val s4 = field("code").startsWith(literal("franchise")).bracket and (field("name") contains literal("Bob's")).bracket
  println(serialize(s4))
}
