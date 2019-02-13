package org.upstartcommerce.avataxsdk.client.api.accounts

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers.Authorization
import akka.stream.ActorMaterializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.api._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

/** /api/v2/accounts/$accountId/subscriptions */
trait AccountSubscriptionsRootApi {
  def forId(subscriptionId:Int): AccountSubscriptionsApi

  def create(model:List[SubscriptionModel]):AvataxSimpleCall[List[SubscriptionModel]]
  def list(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[SubscriptionModel]
}

object AccountSubscriptionsRootApi {
  def apply(requester: Requester, security: Option[Authorization])(accountId:Int)(implicit system: ActorSystem, materializer: ActorMaterializer): AccountSubscriptionsRootApi =
    new ApiRoot(requester, security) with AccountSubscriptionsRootApi {
      def forId(subscriptionId: Int): AccountSubscriptionsApi = AccountSubscriptionsApi(requester, security)(accountId, subscriptionId)

      def create(model:List[SubscriptionModel]):AvataxSimpleCall[List[SubscriptionModel]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/subscriptions")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[SubscriptionModel], List[SubscriptionModel]](req, model)
      }

      def list(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[SubscriptionModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/subscriptions")
          .withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[SubscriptionModel](req)
      }
    }
}

/** /api/v2/accounts/$accountId/subscriptions/$id */
trait AccountSubscriptionsApi {
  def delete:AvataxSimpleCall[List[ErrorDetail]]
  def update(model:SubscriptionModel):AvataxSimpleCall[SubscriptionModel]
  def get:AvataxSimpleCall[SubscriptionModel]
}
object AccountSubscriptionsApi {
  def apply(requester: Requester, security: Option[Authorization])(accountId:Int, subscriptionId:Int)(implicit system: ActorSystem, materializer: ActorMaterializer): AccountSubscriptionsApi =
    new ApiRoot(requester, security) with AccountSubscriptionsApi {
      def delete:AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/subscriptions/$subscriptionId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def update(model:SubscriptionModel):AvataxSimpleCall[SubscriptionModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/subscriptions/$subscriptionId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[SubscriptionModel, SubscriptionModel](req, model)
      }

      def get:AvataxSimpleCall[SubscriptionModel] = {
        val uri = Uri(s"/api/v2/accounts/$accountId/subscriptions/$subscriptionId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[SubscriptionModel](req)
      }
    }
}
