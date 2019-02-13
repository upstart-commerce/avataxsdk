package org.upstartcommerce.avataxsdk.client.api

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

/** /api/v2/contacts/ */
trait ContactsRootApi {
  def query(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[ContactModel]
}

object ContactsRootApi {
  def apply(requester: Requester, security: Option[Authorization])(implicit system: ActorSystem, materializer: ActorMaterializer): ContactsRootApi =
    new ApiRoot(requester, security) with ContactsRootApi {
      def query(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[ContactModel] = {
        val uri = Uri(s"/api/v2/contacts").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ContactModel](req)
      }
    }
}