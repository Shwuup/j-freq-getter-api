package io.github.shwuup.freq
import com.atilika.kuromoji.ipadic.Tokenizer
import com.typesafe.scalalogging.LazyLogging

import collection.JavaConverters._
import scala.collection.mutable
import scala.io.Source

object FreqGetter extends LazyLogging {
  val jlptDic: Map[String, String] = {
    println("Currently loading CSV")
    val csv = getClass.getResource("/jlptvocab.csv")
    val bufferedSource = Source.fromURL(csv)
    val jlptDic = bufferedSource.getLines()
      .foldLeft(Map.empty[String, String])((acc, tupleString) => acc + (tupleString.split(",")(1) -> tupleString.split(",")(0)))
    println("finished loading csv")
    jlptDic
  }

  def apply(japText: String): JLPTFrequencies = {
    val tokenizer = new Tokenizer()
    val tokens = tokenizer.tokenize(japText).asScala
    var wordsInText = Map.empty[String, JWord]
    for (tok <- tokens) {
      val word = tok.getBaseForm
      val level = jlptDic.get(word)
      level match {
        case Some(value) =>
          if (wordsInText.contains(word)) {
            val oldJWord = wordsInText.getOrElse(word, throw new Exception("hey this shouldn't happen"))
            val newJWord = oldJWord.copy(freq = oldJWord.freq + 1)
            wordsInText += (word -> newJWord)
          }
          else if (!wordsInText.contains(word)) {
            wordsInText += (word -> JWord(word,value, 1))

          }
        case None =>
      }
    }
    val getJLPTFrequencies: JLPTFrequencies = {
      val jlptTotalFreqList = wordsInText.toList.map(x => x._2).sorted
      val totalWords = jlptTotalFreqList.foldLeft(0)((x, y) => x + y.freq)
      val listOfFreq = for (i <- 1 to 5) yield jlptTotalFreqList.foldRight(List[JWord]())((x, y) => if (x.jlptLevel == s"$i") x :: y else y).take(10)
      JLPTFrequencies(totalWords, jlptTotalFreqList.take(10), listOfFreq(0), listOfFreq(1), listOfFreq(2), listOfFreq(3), listOfFreq(4))
    }
    getJLPTFrequencies
  }
}
