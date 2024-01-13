/* Copyright 2024 UpStart Commerce, Inc.
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

import org.apache.pekko.http.scaladsl.Http.HostConnectionPool
import org.apache.pekko.http.scaladsl.model.{HttpRequest, HttpResponse}
import org.apache.pekko.stream.scaladsl.{Flow, Source}
import org.apache.pekko.NotUsed

import scala.concurrent.{Future, Promise}
import scala.util.Try

package object pekko {
  type HostPool = Flow[(HttpRequest, Promise[HttpResponse]), (Try[HttpResponse], Promise[HttpResponse]), HostConnectionPool]

  type Stream[A] = Source[A, NotUsed]

  type AvataxCollectionCall[A] = org.upstartcommerce.avataxsdk.client.AvataxCollectionCall[Future, Stream, A]
  type AvataxSimpleCall[A] = org.upstartcommerce.avataxsdk.client.AvataxSimpleCall[Future, A]

}
