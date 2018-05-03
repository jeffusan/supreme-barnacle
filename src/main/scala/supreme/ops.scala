package supreme

import cats.data.State
import cats.data.State.pure
import supreme.models.{Movie, Quad}
import cats.implicits._

object ops {

  type Results = (Set[String], Option[String])

  type QuadState[A] = State[Results, A]

  def evalQuad(m: Quad): QuadState[Quad] = {

    def addQuad(m: Quad): QuadState[Quad] = State[Results, Quad] { stack =>
      val c = stack._1.contains(m.quadId)
      ((stack._1 + m.quadId, stack._2 |+| m.toQuad(c)), m)
    }

    addQuad(m)
  }

  def evalAll(input: List[Quad]): QuadState[Quad] = {
    input.foldLeft(pure[Results, Quad](Movie("", ""))) {
      (s, e) =>
        for {
          _ <- s
          a <- evalQuad(e)
        } yield a
    }
  }
}
