name := "j-vocab-freq-getter"

version := "0.1"

scalaVersion := "2.12.8"

val http4sVersion = "0.20.0-M4"

updateOptions := updateOptions.value.withCachedResolution(true)

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion,
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "com.atilika.kuromoji" % "kuromoji-ipadic" % "0.9.0",
  "io.circe" % "circe-parser_2.12" % "0.11.0",
  "io.circe" % "circe-generic_2.12" % "0.11.0",
  "io.circe" % "circe-core_2.12" % "0.11.0",
  "org.http4s" % "http4s-circe_2.12" % "0.20.0-M4",
  "com.typesafe.scala-logging" % "scala-logging_2.12" % "3.9.2"
)