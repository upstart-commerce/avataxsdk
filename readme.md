# Avatax Client

Pure Scala library for interaction with Avatax APIs.

Project is split into following modules:

- core - Zero-dependency project - Scala ADT of data transfer objects. Based on
  docs & [official sdk](https://github.com/avadev/AvaTax-REST-V2-JRE-SDK).
- client - client interface
- client-akka - akka-http + play-json client for AvaTax
- client-pekko - pekko-http + play-json client for AvaTax
- play-json - formats and derivation for AvaTax data types

### Installation

Add following to your build.sbt

* akka

```scala
Global / resolvers += Resolver.url("upstartcommerce", url("https://upstartcommerce.jfrog.io/artifactory/nochannel"))(Resolver.ivyStylePatterns)

libraryDependencies += "org.upstartcommerce" %% "avataxsdk-client-akka" % "0.1.0" // or whatever latest version is

```

* pekko

```scala
Global / resolvers += Resolver.url("upstartcommerce", url("https://upstartcommerce.jfrog.io/artifactory/nochannel"))(Resolver.ivyStylePatterns)

libraryDependencies += "org.upstartcommerce" %% "avataxsdk-client-pekko" % "0.1.0" // or whatever latest version is
```
* core/data model only

```scala
Global / resolvers += Resolver.url("upstartcommerce", url("https://upstartcommerce.jfrog.io/artifactory/nochannel"))(Resolver.ivyStylePatterns)

libraryDependencies += "org.upstartcommerce" %% "avataxsdk-core" % "0.1.0"
```

### Usage

Basic usage is:
```scala
  implicit val sys: ActorSystem       = ActorSystem()
  implicit val mat: Materializer      = Materializer(sys)
  val client = AkkaAvataxClient(...) // or PekkoAvataxClient

  /** request a result  */
  val valid = client.taxRates.byPostalCode("US", "35802")
  val invalid = client.taxRates.byPostalCode("USUS", "123123123123")
  val req:Future[Either[ErrorInfo, TaxRateModel]]  = invalid().map(Right.apply).recover {
    case AvataxException(ErrorResult(Some(e))) => Left(e)
  }


  /** stream by batch sizes of 50 */
  val streamReq = client.definitions.listCurrencies(FiltrableQueryOptions().withTop(50)).stream
  streamReq.runForeach(x => println(x))
```
See `example` subproject for more examples.

There is a good reference for data model
[here](https://developer.avalara.com/api-reference/avatax/rest/v2/models/)

Please avoid blocking (awaiting) on futures from this api.


### Compilation

First full compilation will take a long time (+-10minutes) due to huge amount of
api surface area - data types available, for which json has to be derived.
Followup incremental compilations should be fast.
