import io.github.shwuup.freq.FreqService
import org.scalatest.{FunSuite, Matchers}
import cats.effect.{IO, _}
import org.http4s.{Method, Request, Status, Uri}


class FreqGetterSpec extends FunSuite with Matchers  {

  val service = FreqService()
  val resp = service.run(Request(method = Method.GET, uri = Uri.uri("/hello/bob")))


}
