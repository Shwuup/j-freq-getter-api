package io.github.shwuup.freq
//default: sort in descending order
case class JWord(word: String, jlptLevel: String, freq: Int) extends Ordered[JWord] {
  override def compare(that: JWord): Int = that.freq == this.freq match {
    case true if that.jlptLevel.toInt > this.jlptLevel.toInt => 1
    case true if that.jlptLevel.toInt < this.jlptLevel.toInt => -1
    case false if that.freq > this.freq => 1
    case false if that.freq < this.freq => -1
    case _ => 0


  }

}
