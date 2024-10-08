name := "avataxsdk"

ThisBuild / organization := "org.upstartcommerce"

lazy val publishSettings: Seq[Setting[_]] = Seq(
  publishTo := Some(
    Resolver.url("upstartcommerce-public", url("https://upstartcommerce.jfrog.io/artifactory/generic"))(Resolver.ivyStylePatterns)
  ),
  credentials += Credentials(Path.userHome / ".sbt" / ".credentials"),
  publishMavenStyle := false
)

lazy val notPublishSettings = Seq(publishArtifact := false, publish / skip := true, publishLocal := {}, publish := {})

val scala_2_12V = "2.12.12"
val scala_2_13V = "2.13.6"

lazy val scalatest = "org.scalatest" %% "scalatest" % "3.2.0"

lazy val akkaHttp = "com.typesafe.akka" %% "akka-http-core" % "10.1.11"
lazy val akkaStream = "com.typesafe.akka" %% "akka-stream" % "2.6.3"
lazy val akkaHttpJson = "de.heikoseeberger" %% "akka-http-play-json" % "1.31.0"

lazy val pekkoHttp = "org.apache.pekko" %% "pekko-http" % "1.0.0"
lazy val pekkoStream = "org.apache.pekko" %% "pekko-stream" % "1.0.2"

lazy val playJson = "com.typesafe.play" %% "play-json" % "2.8.1"
// for case classes > 22 fields
lazy val playJsonExt = "ai.x" %% "play-json-extensions" % "0.40.2"
lazy val shapeless = "com.chuusai" %% "shapeless" % "2.3.3"
lazy val compatLibForScala = "org.scala-lang.modules" %% "scala-collection-compat" % "2.1.6"
lazy val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"

lazy val scalacSettings = Seq(
  scalacOptions ++= Seq(
    "-deprecation", // Emit warning and location for usages of deprecated APIs.
    "-encoding",
    "utf-8", // Specify character encoding used by source files.
    "-explaintypes", // Explain type errors in more detail.
    "-feature", // Emit warning and location for usages of features that should be imported explicitly.
    "-language:existentials", // Existential types (besides wildcard types) can be written and inferred
    "-language:higherKinds", // Allow higher-kinded types
    "-language:implicitConversions", // Allow definition of implicit functions called views
    "-unchecked", // Enable additional warnings where generated code depends on assumptions.
    "-Xcheckinit", // Wrap field accessors to throw an exception on uninitialized access.
    "-Xlint:constant", // Evaluation of a constant arithmetic expression results in an error.
    "-Xlint:delayedinit-select", // Selecting member of DelayedInit.
    "-Xlint:doc-detached", // A Scaladoc comment appears to be detached from its element.
    "-Xlint:inaccessible", // Warn about inaccessible types in method signatures.
    "-Xlint:infer-any", // Warn when a type argument is inferred to be `Any`.
    "-Xlint:missing-interpolator", // A string literal appears to be missing an interpolator id.
    "-Xlint:nullary-unit", // Warn when nullary methods return Unit.
    "-Xlint:option-implicit", // Option.apply used implicit view.
    "-Xlint:package-object-classes", // Class or object defined in package object.
    "-Xlint:poly-implicit-overload", // Parameterized overloaded implicit methods are not visible as view bounds.
    "-Xlint:private-shadow", // A private field (or class parameter) shadows a superclass field.
    "-Xlint:stars-align", // Pattern sequence wildcard must align with sequence component.
    "-Xlint:type-parameter-shadow", // A local type parameter shadows a type already in scope.
    "-Ywarn-extra-implicit", // Warn when more than one implicit parameter section is defined.
    "-Ywarn-numeric-widen", // Warn when numerics are widened.
    "-Ywarn-macros:before",
    "-Ywarn-unused:locals", // Warn if a local definition is unused.
    "-Ywarn-unused:params", // Warn if a value parameter is unused.
    "-Yrangepos"
  ) ++ {
    if (scalaVersion.value == scala_2_12V)
      Seq(
        "-Xlint:nullary-override", // Warn when non-nullary `def f()' overrides nullary `def f'.
        "-Ywarn-nullary-unit", // Warn when nullary methods return Unit.
        "-Ywarn-infer-any", // Warn when a type argument is inferred to be `Any`.
        "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
        "-Ypartial-unification", // Enable partial unification in type constructor inference
        "-Xlint:by-name-right-associative", // By-name parameter of right associative operator.
        "-Xlint:unsound-match", // Pattern match may not be typesafe.
        "-Yno-adapted-args" // Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver.
      )
    else if (scalaVersion.value == scala_2_13V)
      Seq(
//        "-Xfatal-warnings", // Fail the compilation if there are any warnings.
        "-Xlint:nullary-unit", // Warn when nullary methods return Unit.
        "-Xlint:infer-any", // Warn when a type argument is inferred to be `Any`.
        "-Xlint:inaccessible" // Warn about inaccessible types in method signatures.
      )
    else Seq.empty
  },
  Compile / console / scalacOptions --= Seq("-Xfatal-warnings", "-Ywarn-unused:imports", "-Yno-imports"),
  Compile / doc / scalacOptions --= Seq("-Xfatal-warnings", "-Ywarn-unused:imports", "-Yno-imports")
)

val avataxsdk = (project in file(".")).settings(notPublishSettings).aggregate(core, jsonPlay, client, clientAkka, clientPekko, example)

lazy val commonSettings = scalacSettings ++ Seq(
  scalaVersion := scala_2_13V,
  crossScalaVersions := Seq( /* scala_2_12V, */ scala_2_13V),
  Test / parallelExecution := false
)

lazy val core = project
  .in(file("modules/core"))
  .settings(commonSettings)
  .settings(name := "avataxsdk-core", publishSettings, libraryDependencies ++= Seq(compatLibForScala, scalatest % Test))

lazy val jsonPlay = project
  .in(file("modules/json-play"))
  .settings(commonSettings)
  .settings(
    publishSettings,
    name := "avataxsdk-json-play",
    libraryDependencies ++= Seq(compatLibForScala, playJson, playJsonExt, shapeless, scalatest % Test)
  )
  .dependsOn(core)

lazy val client = project
  .in(file("modules/client"))
  .settings(commonSettings)
  .settings(publishSettings, name := "avataxsdk-client", libraryDependencies ++= Seq(compatLibForScala, scalatest % Test))
  .dependsOn(core)

lazy val clientAkka = project
  .in(file("modules/client-akka"))
  .settings(commonSettings)
  .settings(
    publishSettings,
    name := "avataxsdk-client-akka",
    libraryDependencies ++= Seq(compatLibForScala, akkaHttp, akkaStream, akkaHttpJson, logback, scalatest % Test)
  )
  .dependsOn(core, client, jsonPlay)

lazy val clientPekko = project
  .in(file("modules/client-pekko"))
  .settings(commonSettings)
  .settings(
    publishSettings,
    name := "avataxsdk-client-pekko",
    libraryDependencies ++= Seq(compatLibForScala, pekkoHttp, pekkoStream, logback, scalatest % Test)
  )
  .dependsOn(core, client, jsonPlay)

lazy val example =
  project
    .in(file("modules/example"))
    .settings(commonSettings, notPublishSettings, libraryDependencies += compatLibForScala)
    .dependsOn(clientAkka)
