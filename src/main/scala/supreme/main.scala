package supreme

import java.io.{File, PrintWriter}

import com.github.tototoshi.csv.CSVReader
import supreme.models.{Movie, Quad}

import scala.io.Source

trait ReadsCSV {
  private val files = "tmdb_5000_credits.csv" // TODO: Need to handle both input files

  def readFile: Input = CSVReader.open(Source.fromResource(files)).allWithHeaders()
//
//  def parseCastInput(i: Map[String, String]): List[Quad] = {
//    val m = Movie(i("movie_id"), i("title"))
//    val ca = parse.parseCast(i("cast"), m.quadId)
//  }

}

object Main extends ReadsCSV {

  private val writer = new PrintWriter(new File("output.quad"))

  // currently just a stub
  def main(args: Array[String]) = try {

    val results: (Set[String], List[String]) = (Set.empty, List.empty)

    results._2.foreach { quad => writer.write("") }

  } catch {
    // catchall
    case e: Exception => println(e.getMessage)
  } finally {
    writer.close()
  }

}
