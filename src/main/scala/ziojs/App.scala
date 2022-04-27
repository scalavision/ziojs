import zio.*

object App extends ZIOAppDefault:

  def run = for {
    _ <- Console.printLine("Hello World")
  } yield ()

