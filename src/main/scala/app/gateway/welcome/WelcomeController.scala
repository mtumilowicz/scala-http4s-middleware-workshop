package app.gateway.welcome

import cats.Monad
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import org.http4s.server.Router

final case class WelcomeController[F[_] : Monad]() extends Http4sDsl[F] {

  private val httpRoutes: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root =>
      Ok("hi")
  }

  val routes: HttpRoutes[F] = Router(
    "/" -> httpRoutes
  )

}
