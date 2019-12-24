package io.github.shwuup.freq
import com.atilika.kuromoji.ipadic.{Token, Tokenizer}
import com.typesafe.scalalogging.LazyLogging
import collection.JavaConverters._
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

  def apply(text: String): JLPTFrequencies = {
    val tokenizer = new Tokenizer()
    val tokens:List[Token] = tokenizer.tokenize(text).asScala.toList
    val tokensInJlptDic = tokens.filter(t => jlptDic.contains(t.getBaseForm))
    val wordsWithFrequencies:List[(String, String)] = tokensInJlptDic.map(t => (t.getBaseForm, jlptDic.getOrElse(t.getBaseForm, throw new Exception("not found"))))
    getJLPTFrequencies(populateFrequencyMap(wordsWithFrequencies))
    }

  def populateFrequencyMap(frequencies: List[(String, String)]):Map[String,JWord] = {
    val wordsInText = Map.empty[String, JWord]
    frequencies.foldLeft(wordsInText)((acc, w) => {
      if (acc.contains(w._1)) {
        val oldWord = acc.getOrElse(w._1, throw new Exception("word not found"))
        val newWord = oldWord.copy(freq = oldWord.freq + 1)
        acc + (w._1 -> newWord)
      } else {
        acc + (w._1 -> JWord(w._1,w._2, 1))
      }
    })
  }

  def getJLPTFrequencies(frequencies:Map[String,JWord]): JLPTFrequencies = {
    val jlptTotalFreqList = frequencies.toList.map(x => x._2).sorted
    val wordTotal = jlptTotalFreqList.foldLeft(0)((x, y) => x + y.freq)
    val listOfFreq = for (i <- 1 to 5) yield jlptTotalFreqList.foldRight(List[JWord]())((x, y) => if (x.jlptLevel == s"$i") x :: y else y).take(10)
    JLPTFrequencies(wordTotal, jlptTotalFreqList.take(10), listOfFreq(0), listOfFreq(1), listOfFreq(2), listOfFreq(3), listOfFreq(4))
  }
}
