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

import org.upstartcommerce.avataxsdk.core.data.FetchResult

// todo: provide some combinators
trait AvataxCall[F[_], +A] {

  //def attempt:AvataxCall[Either[AvataxException, A]]
}

/**
  * Simple calls are ones that return pure model, and have no possibility of pagination, offset...,
  * and thus streaming makes little sense
  */
trait AvataxSimpleCall[F[_], A] extends AvataxCall[F, A] {

  def apply(): F[A]
}

/**
  * Enables both batch and streamed calls.
  *
  * Avatax imposes limit on how many resources it can return in one call, and thus it's
  * up to client to split/limit/offset/paginate the requests should one need more than limit.
  * For such cases one can use `stream` method, which does the pagination automatically (based
  * on query options, same as with `Future` methods).
  */
trait AvataxCollectionCall[F[_], S[_], A] extends AvataxCall[F, A] {

  def batch(): F[FetchResult[A]]

  final def apply(): F[FetchResult[A]] = batch()

  def stream: S[A]
}
