package supreme

object models {

  trait Quad {
    def toQuad(previouslyWritten: Boolean = false): Option[String] = previouslyWritten match {
      case true => edges
      case false => initial
    }

    def cleanId(input: String, prefix: String): String = s"$prefix-${input.trim}"

    def initial: Option[String]

    def edges: Option[String]

    val quadId: String
  }

  case class Movie(id: String, title: String) extends Quad {
    val quadId: String = cleanId(id, "m")

    override def initial: Option[String] = Some(
      s"""
         |$quadId type movie .
         |$quadId name "$title" .
       """.stripMargin)

    override def edges: Option[String] = None
  }

  case class Cast(
                   cast_id: Int,
                   character: String,
                   gender: Int,
                   id: Int,
                   name: String,
                   movieId: Option[String]=None) extends Quad {

    override def initial: Option[String] = Option(
      movieId.fold(
        s"""
           |$quadId type cast .
           |$quadId name "$name" .
       """.stripMargin) { mid =>
        s"""
           |$quadId type cast .
           |$quadId name "$name" .
       """.stripMargin
      }
    )

    override def edges: Option[String] = movieId.fold(Option.empty[String]){ mid =>
      Some(s"""
              |$quadId actedIn $mid
         """.stripMargin)
    }

    override val quadId: String = cleanId(cast_id.toString, "ca")
  }

  case class Crew(
                   credit_id: String,
                   department: String,
                   gender: Int,
                   id: Int,
                   job: String,
                   name: String,
                   movieId: Option[String] = None) extends Quad {
    override def initial: Option[String] = Option(
      movieId.fold(
        s"""
           |a
         """.stripMargin) {mid =>
        s"""
           |asd
         """.stripMargin
      }
    )

    override def edges: Option[String] = movieId.fold(Option.empty[String]) { f =>
      Some(
        s"""
           |asdf
         """.stripMargin)
    }

    override val quadId: String = cleanId(credit_id, "cr")
  }

}
: