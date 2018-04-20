package supreme

import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}
import supreme.models.Movie

class ReaderSpec extends FlatSpec with Matchers with PropertyChecks with ReadsCSV {

  "the ids" should "accumulate in a monad" in {

    val movies = readFile.map(a => Movie(a("movie_id"), a("title")))
    movies.size shouldBe 4803
    ops.evalAll(movies).run(Set.empty).value._1.size shouldBe 4803
  }

}
