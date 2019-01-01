package io.github.shwuup.freq
import com.atilika.kuromoji.ipadic.Tokenizer

import scala.collection.mutable
import scala.io.Source

object FreqGetter {
  def apply(japText: String, jlptDic: mutable.Map[String, String]) = {
    val tokenizer = new Tokenizer()
    val tokens = tokenizer.tokenize(japText)
    tokens.forEach(token => println(token.getSurface + "\t"
      + token.getBaseForm + "\t"
      + token.getPartOfSpeechLevel1 + "\t"
      + token.getAllFeatures))
  }
}
