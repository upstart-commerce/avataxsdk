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

package example

import akka.actor.ActorSystem
import akka.stream.Materializer
import org.upstartcommerce.avataxsdk.client.AvataxClient
import org.upstartcommerce.avataxsdk.client.AvataxClient.SecuritySettings
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models.{ErrorInfo, ErrorResult, ResetLicenseKeyModel, TaxRateModel}

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Example extends App {

  implicit val sys: ActorSystem       = ActorSystem()
  implicit val mat: Materializer      = Materializer(sys)

  val (un, pw) = (System.getenv("AVATAX_USERNAME"),System.getenv("AVATAX_PASSWORD"))
  val client = AvataxClient(Environment.Sandbox, poolQueueSize = 128, security = Some(SecuritySettings(un, pw)))

  val req1 = client.definitions.listCurrencies(FiltrableQueryOptions().withTop(1)).batch()
  val resp1 = Await.result(req1, 30.seconds)
  println(resp1)

  val req2 = client.definitions.listCurrencies(FiltrableQueryOptions().withTop(50).withOrderBy(OrderBy("description", OrderBy.Ascending))).stream
  val resp2f = req2.runForeach(x => println(x))
  val resp2 = Await.result(resp2f, 30.seconds)
  println(resp2)

  val req3 = client.accounts.forAccount(200034713).resetLicenseKey(ResetLicenseKeyModel(200034713, confirmResetLicenseKey = true)).apply()
  val resp3 = Await.result(req3, 30.seconds)
  println(resp3)

  val req4 = client.accounts.forAccount(2000347130).getConfiguration.apply()
  val resp4 = Await.result(req4, 30.seconds)
  println(resp4)

  val req5 = client.accounts.query(Include(), FiltrableQueryOptions()).apply()
  val resp5 = Await.result(req5, 30.seconds)
  println(resp5)

  val req6valid = client.taxRates.byPostalCode("US", "35802")
  val req6invalid = client.taxRates.byPostalCode("USUS", "123123123123")
  val req6:Future[Either[ErrorInfo, TaxRateModel]]  = req6invalid().map(Right.apply).recover {
    case AvataxException(ErrorResult(Some(e))) => Left(e)
  }
  val resp6 = Await.result(req6, 30.seconds)
  println(resp6)
}
