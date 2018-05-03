package supreme


import io.circe.parser.decode
import io.circe.generic.auto._
import io.circe.syntax._
import supreme.models.{Cast, Crew}

object parse {

  def parseCast(i: String, movieId: String): List[Cast] = decode[List[Cast]](i) match {
    case a if a.isRight =>
      a.right.get.map(c => c.copy(movieId=Some(movieId)))

    case b if b.isLeft =>
        println(b.left.get.getMessage)
        List.empty
  }

  def parseCrew(i: String, movieId: String): List[Crew] = decode[List[Crew]](i) match {
    case a if a.isRight =>
      a.right.get.map(c => c.copy(movieId=Some(movieId)))
    case b if b.isLeft =>
      println(b.left.get.getMessage)
      List.empty
  }
}
