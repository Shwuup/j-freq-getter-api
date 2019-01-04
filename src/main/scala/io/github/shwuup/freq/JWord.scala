package io.github.shwuup.freq

case class JWord(word: String, jlptLevel: String, freq: Int) extends Ordered[JWord] {
  override def compare(that: JWord): Int = that.freq match {
    case x if x > this.freq => 1
    case x if x < this.freq => -1
    case _ => 0
  }

}
