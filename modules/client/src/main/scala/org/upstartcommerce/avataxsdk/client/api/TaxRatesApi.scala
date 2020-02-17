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

package org.upstartcommerce.avataxsdk.client.api

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model.Uri.Query
import akka.http.scaladsl.model._
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

trait TaxRatesRootApi {
  def byAddress(line1:String, line2:String, line3:String, city:String, region:String, postalCode:String, country:String):AvataxSimpleCall[TaxRateModel]
  def byPostalCode(country:String, postalCode:String):AvataxSimpleCall[TaxRateModel]
}

object TaxRatesRootApi {
  def apply(requester: Requester, security: Option[Authorization])(implicit system: ActorSystem, materializer: Materializer): TaxRatesRootApi =
    new ApiRoot(requester, security) with TaxRatesRootApi {
      def byAddress(line1:String, line2:String, line3:String, city:String, region:String, postalCode:String, country:String):AvataxSimpleCall[TaxRateModel] = {
        val uri = Uri(s"/api/v2/taxrates/byaddress")
          .withQuery(Query(
            "line1" -> line1,
            "line2" -> line2,
            "line3" -> line3,
            "city" -> city,
            "region" -> region,
            "postalCode" -> postalCode,
            "country" -> country
          ))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[TaxRateModel](req)
      }

      def byPostalCode(country:String, postalCode:String):AvataxSimpleCall[TaxRateModel] = {
        val uri = Uri(s"/api/v2/taxrates/bypostalcode")
          .withQuery(Query(
            "postalCode" -> postalCode,
            "country" -> country
          ))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[TaxRateModel](req)
      }
    }
}