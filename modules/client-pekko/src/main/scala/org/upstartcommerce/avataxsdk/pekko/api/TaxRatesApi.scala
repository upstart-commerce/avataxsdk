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

package org.upstartcommerce.avataxsdk.client.pekko.api

import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.http.scaladsl.model.HttpMethods._
import org.apache.pekko.http.scaladsl.model.Uri.Query
import org.apache.pekko.http.scaladsl.model._
import org.apache.pekko.stream.Materializer
import org.upstartcommerce.avataxsdk.client.pekko._
import org.upstartcommerce.avataxsdk.client.pekko.internal._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.apache.pekko.http.scaladsl.model.headers.Authorization
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import org.upstartcommerce.avataxsdk.client.pekko.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.client.api.TaxRatesRootApi
import org.upstartcommerce.avataxsdk.client.pekko.{AvataxCollectionCall, AvataxSimpleCall, Stream}
import scala.concurrent.Future

object TaxRatesRootApiImpl {
  def apply(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
      implicit system: ActorSystem,
      materializer: Materializer
  ): TaxRatesRootApi[Future, Stream] =
    new ApiRoot(requester, security, clientHeaders) with TaxRatesRootApi[Future, Stream] {
      def byAddress(
          line1: String,
          line2: String,
          line3: String,
          city: String,
          region: String,
          postalCode: String,
          country: String
      ): AvataxSimpleCall[TaxRateModel] = {
        val uri = Uri(s"/api/v2/taxrates/byaddress").withQuery(
          Query(
            "line1" -> line1,
            "line2" -> line2,
            "line3" -> line3,
            "city" -> city,
            "region" -> region,
            "postalCode" -> postalCode,
            "country" -> country
          )
        )
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[TaxRateModel](req)
      }

      def byPostalCode(country: String, postalCode: String): AvataxSimpleCall[TaxRateModel] = {
        val uri = Uri(s"/api/v2/taxrates/bypostalcode").withQuery(Query("postalCode" -> postalCode, "country" -> country))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[TaxRateModel](req)
      }
    }
}