name := "j-vocab-freq-getter"

version := "0.1"

scalaVersion := "2.12.8"
val http4sVersion = "0.20.0-M4"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion,
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "com.atilika.kuromoji" % "kuromoji-ipadic" % "0.9.0"
)