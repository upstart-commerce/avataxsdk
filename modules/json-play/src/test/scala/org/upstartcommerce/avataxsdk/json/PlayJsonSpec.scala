package org.upstartcommerce.avataxsdk.json

import org.upstartcommerce.avataxsdk.json._
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers._
import org.scalatest.wordspec.AnyWordSpecLike
import org.upstartcommerce.avataxsdk.core.data.FetchResult
import org.upstartcommerce.avataxsdk.core.data.models.SubscriptionModel
import play.api.libs.json.Json

@SuppressWarnings(Array("org.wartremover.warts.Null"))
class PlayJsonSpec extends AnyWordSpecLike with should.Matchers with BeforeAndAfterAll {

  private val subscriptionsJson =
    """{
      |
      |   "@recordsetCount":2,
      |   "value":[
      |      {
      |         "id":247,
      |         "accountId":130,
      |         "subscriptionTypeId":1,
      |         "subscriptionDescription":"AvaTaxST",
      |         "effectiveDate":"2022-02-14",
      |         "createdDate":"2022-02-15T19:12:01.847",
      |         "createdUserId":103,
      |         "modifiedDate":"2022-02-15T19:12:01.847",
      |         "modifiedUserId": 103
      |      },
      |      {
      |         "id":248,
      |         "accountId":130,
      |         "subscriptionTypeId":2,
      |         "subscriptionDescription":"AvaTaxPro",
      |         "effectiveDate":"2022-02-14",
      |         "createdDate":"2022-02-15T19:12:01.847",
      |         "createdUserId":103,
      |         "modifiedDate":"2022-02-15T19:12:01.847",
      |         "modifiedUserId": 103
      |      }
      |   ]
      |}
      |""".stripMargin

  "playjson" must {

    "subscriptions result read" in {
      val d = Json.parse(subscriptionsJson).as[FetchResult[SubscriptionModel]]
      d.recordSetCount shouldBe 2
      d.value.size shouldBe 2
    }

  }

}
