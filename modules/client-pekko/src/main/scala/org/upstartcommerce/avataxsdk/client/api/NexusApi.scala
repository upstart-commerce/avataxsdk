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

package org.upstartcommerce.avataxsdk.client.api

import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.http.scaladsl.model.HttpMethods._
import org.apache.pekko.http.scaladsl.model._
import org.apache.pekko.stream.Materializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.upstartcommerce.avataxsdk.json._
import org.apache.pekko.http.scaladsl.model.headers.Authorization
import play.api.libs.json._
import org.upstartcommerce.avataxsdk.client.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders

/** /api/v2/nexus */
trait NexusRootApi {
  def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[NexusModel]
}

object NexusRootApi {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      implicit system: ActorSystem,
      materializer: Materializer
  ): NexusRootApi =
    new ApiRoot(requester, security, clientHeaders) with NexusRootApi {
      def query(include: Include, options: FiltrableQueryOptions): AvataxCollectionCall[NexusModel] = {
        val uri = Uri(s"/api/v2/nexus").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NexusModel](req)
      }
    }
}
