package io.github.shwuup.freq
import com.atilika.kuromoji.ipadic.Tokenizer
import collection.JavaConverters._
import scala.collection.mutable
import scala.io.Source

object FreqGetter {
  def apply(japText: String, jlptDic: mutable.Map[String, String]) = {
    val tokenizer = new Tokenizer()
    val tokens = tokenizer.tokenize(japText).asScala
    var totalWords = 0
    var wordsInText = scala.collection.mutable.HashMap.empty[String, (String, Int)]

    for (tok <- tokens) {
      val word = tok.getBaseForm
      val level = jlptDic.get(word)
      level match {
        case Some(value) =>
          if (wordsInText.contains(word)) {
            val newFreq = wordsInText.getOrElse(word, ("not found", 0))._2 + 1
            wordsInText += (word -> (value, newFreq))
          }
          else wordsInText += (word -> (value, 1))
          totalWords+=1
        case None => println(s"$word not found")
      }
    }
    (totalWords, wordsInText.toList)

//    tokens.forEach(token => println(token.getSurface + "\t"
//      + token.getBaseForm + "\t"
//      + token.getPartOfSpeechLevel1 + "\t"
//      + token.getAllFeatures))
  }
}
