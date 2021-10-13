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

import java.text.SimpleDateFormat
import akka.NotUsed
import akka.actor.ActorSystem
import akka.http.scaladsl.marshalling._
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers.{Authorization, GenericHttpCredentials, RawHeader}
import akka.http.scaladsl.unmarshalling._
import akka.stream.Materializer
import akka.stream.scaladsl.Source
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.internal.Requester
import org.upstartcommerce.avataxsdk.client.{AvataxCollectionCall, AvataxSimpleCall}
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.client.AvataxClient.ClientHeaders
import org.upstartcommerce.avataxsdk.core.data.models._
import org.slf4j.LoggerFactory
import java.util.UUID.randomUUID

import scala.concurrent.Future

abstract class ApiRoot(requester: Requester, security: Option[Authorization], clientHeaders: Option[ClientHeaders])(
    implicit system: ActorSystem,
    materializer: Materializer
) {
  val dateFmt = {
    //new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    new SimpleDateFormat("yyyy-MM-dd")
  }

  import system.dispatcher
  private val log = LoggerFactory.getLogger(this.getClass)

  /**
    * Fetches data based on request
    */
  def fetch[A: Format](req: HttpRequest, randomId: String)(implicit um: Unmarshaller[HttpResponse, A]): Future[A] = {

    val req2 = req.withHeaders(req.headers ++ security)
    val resp = requester.request(req2)

    resp.flatMap {
      case x if x.status.isFailure =>
        val failedResponse = Unmarshal(x).to[ErrorResult]
        failedResponse.flatMap(x => Future.failed(AvataxException(x)))
      case x =>
        val successfulResponse = Unmarshal(x).to[A]
        log.debug(s"UUId: $randomId. Response: $x")
        successfulResponse
    }
  }

  /**
    * Fetches one batch of data based on request
    */
  def batchFetch[A: Format](req: HttpRequest, randomId: String)(
      implicit um: Unmarshaller[HttpResponse, FetchResult[A]]
  ): Future[FetchResult[A]] =
    fetch[FetchResult[A]](req, randomId)

  /**
    * Pulls the data continously from source, following next link in resultset each time.
    */
  def continuousStream[A: Format](req: HttpRequest, randomId: String)(
      implicit um: Unmarshaller[HttpResponse, FetchResult[A]]
  ): Source[A, NotUsed] = {
    Source
      .unfoldAsync[Option[HttpRequest], List[A]](Some(req)) {
        case Some(url) =>
          batchFetch[A](url, randomId).map {
            case FetchResult(_, values, Some(next)) => Some((Some(url.withUri(next)), values))
            case FetchResult(_, values, None) => Some((None, values))
          }
        case None => Future.successful(None)
      }
      .flatMapConcat(xs => Source(xs))
  }

  def avataxSimpleCall[A: Format](req: HttpRequest)(implicit um: Unmarshaller[HttpResponse, A]): AvataxSimpleCall[A] = {
    val randomId = randomUUID.toString
    log.debug(s"UUId: $randomId. Request: $req")
    new AvataxSimpleCall[A] {
      val newReq = updateRequestWithHeader(req, clientHeaders)
      def apply(): Future[A] = {
        val response = fetch[A](newReq, randomId)
        response.foreach(a => log.debug(s"UUId: $randomId. ResponseBody: ${Json.toJson(a)}"))
        response
      }
    }
  }

  def avataxBodyCall[A: Writes, R: Format](req: HttpRequest, body: A)(implicit um: Unmarshaller[HttpResponse, R]): AvataxSimpleCall[R] = {
    val randomId = randomUUID.toString
    log.debug(s"UUId: $randomId. Request: $req")
    log.debug(s"UUId: $randomId. Request Body: ${Json.toJson(body)}")
    new AvataxSimpleCall[R] {
      val newReq = updateRequestWithHeader(req, clientHeaders)
      def apply(): Future[R] = marshal(body).flatMap { ent =>
        val response = fetch[R](newReq.withEntity(ent), randomId)
        response.foreach(a => log.debug(s"UUId: $randomId. ResponseBody: ${Json.toJson(a)}"))
        response
      }
    }
  }

  def avataxCollectionCall[A: Format](
      req: HttpRequest
  )(implicit um: Unmarshaller[HttpResponse, FetchResult[A]]): AvataxCollectionCall[A] = {
    val randomId = randomUUID.toString
    log.debug(s"UUId: $randomId. Request: $req")

    new AvataxCollectionCall[A] {
      val newReq = updateRequestWithHeader(req, clientHeaders)

      def batch(): Future[FetchResult[A]] = {
        val response = batchFetch[A](newReq, randomId)
        response.foreach(a => log.debug(s"UUId: $randomId. ResponseBody: ${Json.toJson(a)}"))
        response
      }

      def stream: Source[A, NotUsed] = {
        val response = continuousStream[A](newReq, randomId)
        response.map(a => log.debug(s"UUId: $randomId. ResponseBody: ${Json.toJson(a)}"))
        response
      }
    }
  }

  def avataxCollectionBodyCall[A: Writes, R: Format](req: HttpRequest, body: A)(
      implicit um: Unmarshaller[HttpResponse, FetchResult[R]]
  ): AvataxCollectionCall[R] = {
    val randomId = randomUUID.toString
    log.debug(s"UUId: $randomId. Request: $req")

    new AvataxCollectionCall[R] {
      val newReq = updateRequestWithHeader(req, clientHeaders)

      def batch(): Future[FetchResult[R]] = marshal(body).flatMap { ent =>
        val response = batchFetch[R](newReq.withEntity(ent), randomId)
        response.foreach(a => log.debug(s"UUId: $randomId. ResponseBody: ${Json.toJson(a)}"))
        response
      }

      def stream: Source[R, NotUsed] = Source.future(marshal(body)).flatMapConcat { ent =>
        val response = continuousStream[R](newReq.withEntity(ent), randomId)
        response.map(a => log.debug(s"UUId: $randomId. ResponseBody: ${Json.toJson(a)}"))
        response
      }
    }
  }

  private def marshal[A: Writes](entity: A): Future[RequestEntity] = {
    Marshal(entity).to[RequestEntity]
  }

  private def updateRequestWithHeader(req: HttpRequest, clientHeaders: Option[ClientHeaders]): HttpRequest = {
    val header = clientHeaders.map(
      h =>
        h.appName + ";" +
          h.appVersion + ";" +
          h.adapterName + ";" +
          h.adapterVersion + ";" +
          h.machineName.fold("")(_ + ";")
    )
    header.fold(req)(v => req.addHeader(RawHeader("X-Avalara-Client", v)))
  }

}
