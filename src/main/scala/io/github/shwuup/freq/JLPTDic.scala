package io.github.shwuup.freq
import scala.io.Source

object JLPTDic {
  def apply = {
    val jlptDic = scala.collection.mutable.Map[String, String]()
    val csv = getClass.getResource("/jlptvocab.csv")
    val bufferedSource = Source.fromURL(csv)
    for (line <- bufferedSource.getLines) {
      val k = line.split(",")
      jlptDic += (k(1) -> k(0))
    }
    jlptDic
  }
}
