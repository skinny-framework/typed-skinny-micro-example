package sample
import skinny.micro._

object SimpleApp extends TypedWebApp {

  get("/hello") {
    Ok("Hello, World!")
  }

  get("/hello-with-headers") {
    Ok(
      body = "Hello, World!", 
      headers = Map("X-Foo-Header" -> "bar")
    )
  }
}
