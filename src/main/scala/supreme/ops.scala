package supreme

import cats.data.State
import cats.data.State.pure
import supreme.models.{Movie, Quad}

object ops {

  type QuadState[A] = State[Set[String], A]

  def evalQuad(m: Quad): QuadState[Quad] = {

    def addQuad(m: Quad): QuadState[Quad] = State[Set[String], Quad] {
      stack => (stack + m.quadId, m)
    }

    addQuad(m)
  }

  def evalAll(input: List[Quad]): QuadState[Quad] = {
    input.foldLeft(pure[Set[String], Quad](Movie("", ""))) {
      (s, e) =>
        for {
          _ <- s
          a <- evalQuad(e)
        } yield a
    }
  }
}
