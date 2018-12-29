package io.github.shwuup.freq

import cats.effect._
import org.http4s._
import org.http4s.dsl.io._
import cats.implicits._
import org.http4s.HttpRoutes
import org.http4s.implicits._

object FreqService {
  def apply() = HttpRoutes.of[IO] {
      case GET -> Root / "hello" / name =>
        Ok(s"Hello, $name.")
      case POST -> Root / "upload" =>
        Ok("text upload")
    }.orNotFound
}
