package org.upstartcommerce.avataxsdk.client.pekko

import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.stream.Materializer
import org.upstartcommerce.avataxsdk.client.AvataxClient._
import org.upstartcommerce.avataxsdk.core.data._
import org.upstartcommerce.avataxsdk.core.data.models._

import scala.concurrent.ExecutionContext.Implicits.global
import org.upstartcommerce.avataxsdk.json._
import play.api.libs.json._
import org.upstartcommerce.avataxsdk.client.pekko.PlayJsonSupport._
import org.upstartcommerce.avataxsdk.core.data.enums.DocumentType

import scala.concurrent.Await
import scala.concurrent.duration._
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.Instant

object Test extends App {
  implicit val sys: ActorSystem = ActorSystem()
  implicit val mat: Materializer = Materializer(sys)

  val user: String = ""
  val password: String = ""
  val clientHeaders = ClientHeaders("MyApplication", "1.0", "CustomAvalaraSDK-Scala", "0.0.13", Some("IP"))

  val client = PekkoAvataxClient(
    Environment.Sandbox,
    poolQueueSize = 64,
    security = Some(SecuritySettings(user, password)),
    clientHeaders = Some(clientHeaders)
  )

//  println("ping:")
//  val request = client.utilities.ping()
//  val response = Await.result(request, Duration.Inf)
  //  println(response)
//  println(Json.toJson(response))
  //
//  println("address validation:")
//  val request1 = client.addresses.resolve("2000 Main Street", "", "", "Irvine", "CA", "92614", "US", "").apply()
//  val response1 = Await.result(request1, Duration.Inf)
//  println(Json.toJson(response1))
//  client.companies.forCompanyId(852652).customers.forCustomerCode("").get(Include())
  //
//  println("get all companies:")
//  val req2 =
//    client.companies.query(Include(), FiltrableQueryOptions().withTop(2)).stream
//  val req2 = client.companies.query(Include(), FiltrableQueryOptions()).stream.runForeach(m => println(m))

//  println("get all companies again:")

//  val req3 = client.companies.query(Include(), FiltrableQueryOptions()).batch().map(println)
  //  val resp2f = req2.runForeach(println)
//  val resp2 = Await.result(resp2f, Duration.Inf)
  //
  //  println("get company via id:")
  //  val request2 = client.companies.forCompanyId(852652).get(null).apply()
  //  val response2 = Await.result(request2, Duration.Inf)
  //  println(Json.toJson(response2))

  //  val jsonString: String = """[{
  //                             | 	"id": 12345,
  //                             | 	"accountId": 123456789,
  //                             | 	"companyCode": "1123453",
  //                             | 	"name": "Default Company",
  //                             | 	"isDefault": false,
  //                             | 	"isActive": true,
  //                             | 	"taxpayerIdNumber": "123456789",
  //                             | 	"isFein": false,
  //                             | 	"hasProfile": true,
  //                             | 	"isReportingEntity": false,
  //                             | 	"defaultCountry": "US",
  //                             | 	"baseCurrencyCode": "USD",
  //                             | 	"roundingLevelId": "Line",
  //                             | 	"isTest": true,
  //                             | 	"taxDependencyLevelId": "Document",
  //                             | 	"inProgress": false
  //                             |}]""".stripMargin
  //  println("create company:")
  //  val jsonVal: JsValue = Json.parse(jsonString)
  //  //  println(jsonVal)
  //  val companies: List[CompanyModel] = jsonVal.as[List[CompanyModel]]
  //  companies.foreach(println)
  //  val request3 = client.companies.create(companies).apply()
  //  val response3 = Await.result(request3, Duration.Inf)
  //  println(response3)
  //  println(Json.toJson(response3))
  //  val customerJsonString = """[{
  //                             | 	"companyId": 852652,
  //                             | 	"customerCode": "fea37e14-d9ad-4336-b32d-247d412ebf98",
  //                             | 	"alternateId": "987654321",
  //                             | 	"name": "Testing Customer",
  //                             | 	"attnName": "Attn: Receiving",
  //                             | 	"line1": "645 Main Street",
  //                             | 	"city": "Irvine",
  //                             | 	"postalCode": "92614",
  //                             | 	"phoneNumber": "(949) 555-1212",
  //                             | 	"faxNumber": "949.555.1213",
  //                             | 	"emailAddress": "dr.bob.example@example.org",
  //                             | 	"contactName": "Alice Smith",
  //                             | 	"country": "US",
  //                             | 	"region": "CA",
  //                             | 	"exposureZones": [
  //                             | 	 	{
  //                             | 	 	 	"name": "Washington"
  //                             | 	 	}
  //                             | 	]
  //                             |}]""".stripMargin
  //  println("create customer:")
  //  val customerJsonVal: JsValue = Json.parse(customerJsonString)
  //  println(customerJsonVal)
  //  val customers: List[CustomerModel] = customerJsonVal.as[List[CustomerModel]]
  //  customers.foreach(println)
  //  println(Json.toJson(customers))
  //  val request4 = client.companies.forCompanyId(852652).customers.create(customers).apply()
  //  val response4 = Await.result(request4, Duration.Inf)
  //  println(response4)
  //    "date": "2021-02-04T00:00:00+00:00",

//  val transactionJsonString = """{
//                                | 	"lines": [
//                                | 	 	{
//                                | 	 	 	"number": "1",
//                                | 	 	 	"quantity": 1,
//                                | 	 	 	"amount": 100,
//                                | 	 	 	"taxCode": "PS081282",
//                                | 	 	 	"itemCode": "Y0001",
//                                | 	 	 	"description": "Yarn"
//                                | 	 	}
//                                | 	],
//                                | 	"type": "SalesInvoice",
//                                | 	"companyCode": "UPSTARTCOMMERCEINC",
//                                | 	"customerCode": "ABC",
//                                |   "date": "2021-02-04T00:00:00+00:00",
//                                | 	"purchaseOrderNo": "2021-02-04-001",
//                                | 	"addresses": {
//                                | 	 	"singleLocation": {
//                                | 	 	 	"line1": "2000 Main Street",
//                                | 	 	 	"city": "Irvine",
//                                | 	 	 	"region": "CA",
//                                | 	 	 	"country": "US",
//                                | 	 	 	"postalCode": "92614"
//                                | 	 	}
//                                | 	},
//                                | 	"commit": true,
//                                | 	"taxOverride": {
//                                | 	 	"type": "None",
//                                | 	 	"taxAmount": 6.25,
//                                | 	 	"reason": "Precalculated Tax"
//                                | 	},
//                                | 	"currencyCode": "USD",
//                                | 	"serviceMode": "Automatic",
//                                | 	"description": "Yarn",
//                                | 	"debugLevel": "Normal"
//                                |}""".stripMargin
//  println("create transaction:")
//  val transactionJsonVal: JsValue = Json.parse(transactionJsonString)
//  //  println(transactionJsonVal)
//  val transaction: CreateTransactionModel = transactionJsonVal.as[CreateTransactionModel]

//  println(Json.toJson(transaction))
  val address = AddressLocationInfo(
    line1 = Some("2000 Main Street"),
    city = Some("Irvine"),
    region = Some("CA"),
    country = Some("US"),
    postalCode = Some("92614")
  )
  val model = CreateTransactionModel(
    `type` = Some(DocumentType.SalesOrder),
    companyCode = Some("UPSTARTCOMMERCEINC"),
    customerCode = "Test",
    purchaseOrderNo = Some("1234"),
    lines = List(LineItemModel(amount = 500.0)),
    currencyCode = Some("USD"),
    date = Instant.now(),
    addresses = Some(AddressesModel(singleLocation = Some(address), shipFrom = Some(address), shipTo = Some(address)))
//    addresses = Some(AddressesModel(singleLocation = Some(address)))
  )
//  val request5 = client.transactions.createTransaction(Include(), model).apply()
//  val response5 = Await.result(request5, Duration.Inf)

//  println(Json.toJson(response5))
  //  val certificateJsonString = """[{
  //                                | 	"id": 0,
  //                                | 	"signedDate": "2021-02-04T22:14:03.1379624Z",
  //                                | 	"expirationDate": "2021-02-04T22:14:03.1379624Z",
  //                                | 	"filename": "911fb058-0d38-4063-abcb-04fb92291332",
  //                                | 	"documentExists": false,
  //                                | 	"valid": true,
  //                                | 	"verified": false,
  //                                | 	"exemptPercentage": 0,
  //                                | 	"isSingleCertificate": false,
  //                                | 	"exemptionNumber": "Exempt-1234",
  //                                | 	"exemptionReason": {
  //                                | 	 	"name": "RESALE"
  //                                | 	},
  //                                | 	"createdDate": "2021-02-04T22:14:03.1379624Z",
  //                                | 	"modifiedDate": "2021-02-04T22:14:03.1379624Z",
  //                                | 	"taxNumberType": "FEIN",
  //                                | 	"businessNumberType": "Business Services",
  //                                | 	"pageCount": 0,
  //                                | 	"customers": [
  //                                | 	 	{
  //                                | 	 	 	"companyId": 0,
  //                                | 	 	 	"customerCode": "606df2c2-3488-4549-8ec5-16bf64c28b99",
  //                                | 	 	 	"alternateId": "987654321",
  //                                | 	 	 	"name": "Dr. Bob Example",
  //                                | 	 	 	"attnName": "Attn: Receiving",
  //                                | 	 	 	"line1": "645 Main Street",
  //                                | 	 	 	"city": "Irvine",
  //                                | 	 	 	"postalCode": "92614",
  //                                | 	 	 	"phoneNumber": "(949) 555-1212",
  //                                | 	 	 	"faxNumber": "949.555.1213",
  //                                | 	 	 	"emailAddress": "dr.bob.example@example.org",
  //                                | 	 	 	"contactName": "Alice Smith",
  //                                | 	 	 	"lastTransaction": "2021-02-04T22:14:03.1379624Z",
  //                                | 	 	 	"country": "US",
  //                                | 	 	 	"region": "CA",
  //                                | 	 	 	"exposureZones": [
  //                                | 	 	 	 	{
  //                                | 	 	 	 	 	"name": "Washington"
  //                                | 	 	 	 	}
  //                                | 	 	 	]
  //                                | 	 	},
  //                                | 	 	{
  //                                | 	 	 	"companyId": 0,
  //                                | 	 	 	"customerCode": "bc00a4a1-f93b-498b-89fc-ea03fa55feac",
  //                                | 	 	 	"alternateId": "987654321",
  //                                | 	 	 	"name": "Dr. Bob Example",
  //                                | 	 	 	"attnName": "Attn: Receiving",
  //                                | 	 	 	"line1": "645 Main Street",
  //                                | 	 	 	"city": "Irvine",
  //                                | 	 	 	"postalCode": "92614",
  //                                | 	 	 	"phoneNumber": "(949) 555-1212",
  //                                | 	 	 	"faxNumber": "949.555.1213",
  //                                | 	 	 	"emailAddress": "dr.bob.example@example.org",
  //                                | 	 	 	"contactName": "Alice Smith",
  //                                | 	 	 	"country": "US",
  //                                | 	 	 	"region": "CA",
  //                                | 	 	 	"exposureZones": [
  //                                | 	 	 	 	{
  //                                | 	 	 	 	 	"name": "Washington"
  //                                | 	 	 	 	}
  //                                | 	 	 	]
  //                                | 	 	}
  //                                | 	],
  //                                | 	"exposureZone": {
  //                                | 	 	"name": "Washington"
  //                                | 	}
  //                                |}]""".stripMargin
  //  println("create company certificates:")
  //  val certificateJsonVal: JsValue = Json.parse(certificateJsonString)
  //  println(certificateJsonVal)
  //  val certificates: List[CertificateModel] = certificateJsonVal.as[List[CertificateModel]]
  //  println(Json.toJson(certificates))
  //  println("___________")
  //  certificates.foreach(println)
//    println("___________")
//  val request6 = client.companies.forCompanyId(852652).certificates.create(true, certificates).apply()
  val request6 = client.definitions.listTaxCodes(FiltrableQueryOptions(top = Some(1))).apply()
  val response6 = Await.result(request6, Duration.Inf)

  val request7 = client.definitions.listCurrencies(FiltrableQueryOptions(top = Some(-1))).apply()
  val respons7 = Await.result(request7, Duration.Inf)
  //  println(response6)

  //  println("get company certificates:")
  //  val request7 = client.companies.forCompanyId(852652).certificates.query(Include(), FiltrableQueryOptions().withTop(10)).stream
  //  val resp2f7 = request7.runForeach(println)
  //  val response7 = Await.result(resp2f7, Duration.Inf)

}
