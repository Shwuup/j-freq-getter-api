import io.github.shwuup.freq.{FreqGetter, FreqService, JWord}
import org.scalatest.{FunSuite, Matchers}
import cats.effect.{IO, _}
import org.http4s.{Method, Request, Status, Uri}


class FreqGetterSpec extends FunSuite with Matchers  {
  test("A list of JWords with correct frequencies, vocab and jlpt level and total is returned for the jlptTotal") {
    val text =  "彼女は日本語を上手に話した。上手上手話した"
    val freq = FreqGetter(text)
    freq.totalFreq shouldBe 6
    freq.jlptTotal shouldBe List(JWord("上手", "5", 3), JWord("話す", "5",2), JWord("彼女", "4", 1))
  }

  test("jlptList1 should have the correct list") {
    val text = "僕はジャズが好きだ。"
    val freq = FreqGetter(text)
    freq.jlpt1List shouldBe List(JWord("ジャズ", "1", 1))
  }

  test("jlptList2 should have the correct list") {
    val text = "最近、目上の人に敬語を使わない若者が多い。目上"
    val freq = FreqGetter(text)
    freq.jlpt2List shouldBe List(JWord("目上", "2", 2), JWord("敬語", "2", 1))
  }

  test("jlptList3 should have the correct list") {
    val text = "彼女に座るように合図した。合図"
    val freq = FreqGetter(text)
    freq.jlpt3List shouldBe List(JWord("合図", "3", 2))
  }

  test("jlptList4 should have the correct list") {
    val text = "夕方になって少し雲が出てきました。 "
    val freq = FreqGetter(text)
    freq.jlpt4List shouldBe List(JWord("雲", "4", 1))
  }

  test("jlptList5 should have the correct list") {
    val text = "郵便屋さんは毎朝手紙を配達する。"
    val freq = FreqGetter(text)
    freq.jlpt5List shouldBe List(JWord("する", "5" ,1), JWord("毎朝", "5" ,1), JWord("手紙", "5" ,1))
  }
}
