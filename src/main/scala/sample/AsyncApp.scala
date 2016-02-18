package sample
import skinny.micro._
import scala.concurrent.Future

object AsyncApp extends TypedAsyncWebApp {

  get("/async/hello") { implicit ctx =>
    Future { Ok("Hello, World!") }
  }

  get("/async/hello-with-headers") { ctx =>
    Future {
      Ok(
        body = "Hello, World!", 
        headers = Map("X-Foo-Header" -> "bar")
      )
    }
  }
}
