import zio.*

object App extends ZIOAppDefault:
  final case class MyState(counter: Int)

  val app = for {
    _ <- ZIO.updateState[MyState](state =>
      state.copy(counter = state.counter + 1)
    )
    count <- ZIO.getStateWith[MyState](_.counter)
    _ <- Console.printLine(count)
  } yield count

  def run = app.provideCustom(ZState.makeLayer(MyState(0)))
