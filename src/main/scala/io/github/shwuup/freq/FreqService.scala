package io.github.shwuup.freq

import cats.effect._
import org.http4s._
import org.http4s.dsl.io._
import cats.implicits._
import io.circe.Json
import org.http4s.HttpRoutes
import org.http4s.implicits._
import io.circe.generic.auto._
import io.circe.syntax._
import org.http4s.circe._

object FreqService {
  val freqGetter = FreqGetter

  def apply() = HttpRoutes.of[IO] {
    case GET -> Root =>
      Ok("Welcome to j-freq-getter")
    case req @ POST -> Root / "upload" =>
      val fileContents = EntityDecoder.decodeString(req)
      Ok(freqGetter(fileContents.unsafeRunSync).asJson)
  }.orNotFound
}
