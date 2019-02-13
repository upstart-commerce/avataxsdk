package org.upstartcommerce.avataxsdk.client.api

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

/** /api/v2/reports */
trait ReportsRootApi {
  def forId(reportId:Long): ReportsApi
  def list:AvataxCollectionCall[ReportModel]

}

object ReportsRootApi {
  def apply(requester: Requester, security: Option[Authorization])(implicit system: ActorSystem, materializer: ActorMaterializer): ReportsRootApi =
    new ApiRoot(requester, security) with ReportsRootApi {
      def forId(reportId: Long): ReportsApi = ReportsApi(requester, security)(reportId)

      def list:AvataxCollectionCall[ReportModel] = {
        val uri =
          Uri(s"/api/v2/reports")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[ReportModel](req)
      }
    }
}

trait ReportsApi {
  def download:AvataxSimpleCall[String]
  def get:AvataxSimpleCall[ReportModel]
}
object ReportsApi {
  def apply(requester: Requester, security: Option[Authorization])(reportId:Long)(implicit system: ActorSystem, materializer: ActorMaterializer): ReportsApi =
    new ApiRoot(requester, security) with ReportsApi {
      def download:AvataxSimpleCall[String] = {
        val uri = Uri(s"/api/v2/reports/$reportId/attachment")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[String](req)
      }

      def get:AvataxSimpleCall[ReportModel] = {
        val uri = Uri(s"/api/v2/reports/$reportId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[ReportModel](req)
      }
    }
}