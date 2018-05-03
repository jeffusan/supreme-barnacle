package supreme

import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}
import supreme.models.Movie
import cats.implicits._

class ReaderSpec extends FlatSpec with Matchers with PropertyChecks with ReadsCSV {

  behavior of "parsed quads"

  it should "accumulate in a monad" in {

    val movies = readFile.map(a => Movie(a("movie_id"), a("title")))
    movies.size shouldBe 4803
    ops.evalAll(movies).run((Set.empty, None)).value._1._1.size shouldBe 4803
  }

  it should "provide some casta" in {
    val casts = readFile.map(a => parse.parseCast(a("cast"), a("movie_id")))
    println(casts)
  }

}
