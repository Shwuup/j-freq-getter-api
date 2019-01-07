import io.github.shwuup.freq.JWord
import org.scalatest.{FunSuite, Matchers}

class JWordSpec extends FunSuite with Matchers{
  test("Given that levels are the same, the JWord with the higher frequency should be considered higher") {
    val l = List(JWord("毎朝", "5", 2), JWord("上手", "5", 3))
    l.sorted shouldBe List(JWord("上手", "5", 3), JWord("毎朝", "5", 2))
  }

  test("Given that frequencies are the same, the JWord with the lower level should be considered higher") {
    val l = List(JWord("4,雲", "4", 3), JWord("上手", "5", 3))
    l.sorted shouldBe List(JWord("上手", "5", 3), JWord("4,雲", "4", 3))
  }
}
