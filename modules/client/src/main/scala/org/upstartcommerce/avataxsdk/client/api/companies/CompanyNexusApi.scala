package org.upstartcommerce.avataxsdk.client.api.companies

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer
import org.upstartcommerce.avataxsdk.client._
import org.upstartcommerce.avataxsdk.client.api._
import org.upstartcommerce.avataxsdk.client.internal._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._
import akka.http.scaladsl.model.headers.Authorization

import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

/** /api/v2/companies/$companyId/nexus */
trait CompanyNexusRootApi {
  def forNexusId(nexusId:Int): CompanyNexusApi

  def create(model:List[NexusModel]):AvataxSimpleCall[List[NexusModel]]
  def declareByAddress(model:List[DeclareNexusByAddressModel]):AvataxSimpleCall[List[NexusByAddressModel]]
  def getByFormCode(formCode:String):AvataxSimpleCall[NexusByTaxFormModel]
  def listByCompany(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[NexusModel]
}

object CompanyNexusRootApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId:Int)(implicit system: ActorSystem, materializer: ActorMaterializer): CompanyNexusRootApi =
    new ApiRoot(requester, security) with CompanyNexusRootApi {
      def forNexusId(nexusId: Int): CompanyNexusApi = CompanyNexusApi(requester, security)(companyId, nexusId)

      def create(model:List[NexusModel]):AvataxSimpleCall[List[NexusModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/nexus")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[NexusModel], List[NexusModel]](req, model)
      }

      def declareByAddress(model:List[DeclareNexusByAddressModel]):AvataxSimpleCall[List[NexusByAddressModel]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/nexus/byaddress")
        val req = HttpRequest(uri = uri).withMethod(POST)
        avataxBodyCall[List[DeclareNexusByAddressModel], List[NexusByAddressModel]](req, model)
      }

      def getByFormCode(formCode:String):AvataxSimpleCall[NexusByTaxFormModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/nexus/byform/$formCode")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[NexusByTaxFormModel](req)
      }

      def listByCompany(include:Include, options:FiltrableQueryOptions):AvataxCollectionCall[NexusModel] = {
        val uri =
          Uri(s"/api/v2/companies/$companyId/nexus").withQuery(include.asQuery.merge(options.asQuery))
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxCollectionCall[NexusModel](req)
      }
    }
}

/** /api/v2/companies/$companyId/nexus/$nexusId */
trait CompanyNexusApi {
  def delete:AvataxSimpleCall[List[ErrorDetail]]
  def get:AvataxSimpleCall[NexusModel]
  def update(model:NexusModel):AvataxSimpleCall[NexusModel]
}
object CompanyNexusApi {
  def apply(requester: Requester, security: Option[Authorization])(companyId:Int, nexusId:Int)(implicit system: ActorSystem, materializer: ActorMaterializer): CompanyNexusApi =
    new ApiRoot(requester, security) with CompanyNexusApi {
      def delete:AvataxSimpleCall[List[ErrorDetail]] = {
        val uri = Uri(s"/api/v2/companies/$companyId/nexus/$nexusId")
        val req = HttpRequest(uri = uri).withMethod(DELETE)
        avataxSimpleCall[List[ErrorDetail]](req)
      }

      def get:AvataxSimpleCall[NexusModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/nexus/$nexusId")
        val req = HttpRequest(uri = uri).withMethod(GET)
        avataxSimpleCall[NexusModel](req)
      }

      def update(model:NexusModel):AvataxSimpleCall[NexusModel] = {
        val uri = Uri(s"/api/v2/companies/$companyId/nexus/$nexusId")
        val req = HttpRequest(uri = uri).withMethod(PUT)
        avataxBodyCall[NexusModel, NexusModel](req, model)
      }
    }
}