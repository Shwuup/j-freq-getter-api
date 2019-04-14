package io.github.shwuup.freq

import cats.effect._
import cats.implicits._
import org.http4s.server.blaze._
import org.http4s.server.middleware.CORS //you need this

object Server extends IOApp {
  def run(args: List[String]): IO[ExitCode] =
    BlazeServerBuilder[IO]
      .bindHttp(8001, "0.0.0.0")
      .withHttpApp(CORS(FreqService()))
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
}


