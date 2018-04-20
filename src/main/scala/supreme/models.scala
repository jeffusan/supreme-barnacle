package supreme

object models {

  trait Quad {
    def toQuad(previouslyWritten: Boolean = false): String

    def cleanId(input: String, prefix: String): String = s"$prefix-${input.trim}"

    val quadId: String
  }

  case class Movie(id: String, title: String) extends Quad {
    val quadId: String = cleanId(id, "m")

    override def toQuad(previouslyWritten: Boolean): String = if (previouslyWritten) {
      ""
    } else {
      s"""
         |$quadId type movie .
         |$quadId name "$title" .
       """.stripMargin
    }
  }

}
