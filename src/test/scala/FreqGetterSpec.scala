import io.github.shwuup.freq.{FreqGetter, FreqService, JLPTDic, JWord}
import org.scalatest.{FunSuite, Matchers}
import cats.effect.{IO, _}
import org.http4s.{Method, Request, Status, Uri}


class FreqGetterSpec extends FunSuite with Matchers  {

  test("A list of tuples with correct frequencies, vocab and jlpt level and total is returned") {
    val jlptDic = JLPTDic.apply()
    val text =  "彼女は日本語を上手に話した。上手上手話した"
    val freq = FreqGetter(text, jlptDic)
    freq._2.foreach(println(_))
    freq._1 shouldBe 3
    freq._2 shouldBe List(JWord("上手", "5", 3), JWord("話す", "5",2) , JWord("彼女", "4", 1))
  }
}
