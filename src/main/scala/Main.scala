import com.atilika.kuromoji.ipadic.Token

import scala.io.Source

object Main extends App{
  def readTextFile() = {
    val readTextFile: Iterator[String] = Source.fromResource("test.txt").getLines
    for(lines <- readmeText) {
      println(lines)
    }
  }
}
