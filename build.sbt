name := "simple-pact-consumer"

version := "1.0"

scalaVersion := "2.11.8"
import au.com.dius.pact.provider.sbt._

PactJvmPlugin.pactSettings

SbtProviderPlugin.config ++ Seq(
  providers := Seq(
    ProviderConfig(name = "group-manager-provider", port = 8019)
       .hasPactsInDirectory(file("./pacts")))
  )


libraryDependencies += "org.specs2" %% "specs2-junit" % "3.8.5"
libraryDependencies += "au.com.dius" % "pact-jvm-consumer-specs2_2.11" % "3.5.0-beta.2"

libraryDependencies +="com.typesafe.akka" %% "akka-actor" % "2.4.9"
libraryDependencies +="com.typesafe.akka" %% "akka-actor" % "2.4.9"
libraryDependencies += "com.typesafe.akka" %% "akka-http-core" % "2.4.9"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.4.9"
