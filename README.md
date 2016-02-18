## Typed Skinny Micro Routing Demo

http://skinny-framework.org/documentation/micro.html

This is a sample application which shows you how to make Sinatra-ish web applications more type-safe than Scalatra.

### Typed Routing DSL

https://github.com/skinny-framework/skinny-micro/blob/master/micro/src/main/scala/skinny/micro/routing/TypedRoutingDsl.scala

Scala compiler fails to comple the following code

```scala
package sample
import skinny.micro._
class SimpleApp extends TypedWebApp {
  get("/hello") {
    "Hello, World!"
  }
}
```

as below:

```
[info] Compiling 1 Scala source to ~/workplace/typed-skinny-micro/target/scala-2.10/classes...
[error] ~/workplace/typed-skinny-micro/src/main/scala/app.scala:8: type mismatch;
[error]  found   : String("Hello, World!")
[error]  required: skinny.micro.ActionResult
[error]     (which expands to)  skinny.micro.response.ActionResult
[error]     "Hello, World!"
[error]     ^
[error] one error found
[error] (compile:compileIncremental) Compilation failed
```

Only `skinny.micro.ActionResult` value can be accepted inside routing DSL blocks.

```scala
class SimpleApp extends TypedWebApp {
  get("/hello") {
    Ok("Hello, World!")
  }
}
```

or

```scala
get("/hello") {
  Ok(
    body = "Hello, World!",
    headers = Map("X-Foo-Header" -> "foo-bar-baz")
  )
}
```

Compilation result:

```
[info] Compiling 1 Scala source to ~/workplace/typed-skinny-micro/target/scala-2.10/classes...
[success] Total time: 3 s, completed Feb 18, 2016 9:52:09 AM
```

### Typed Async Routing DSL

https://github.com/skinny-framework/skinny-micro/blob/master/micro/src/main/scala/skinny/micro/routing/TypedAsyncRoutingDsl.scala

Future-wired web controller is also available. The async routing DSL expects `Future[ActionResult]` instead.

```scala
object AsyncApp extends TypedAsyncWebApp {

  get("/async/hello") { implicit ctx =>
    Ok("Hello, World!")
  }
}
```

Compilation error:

```
[info] Compiling 3 Scala sources to ~/workplace/typed-skinny-micro/target/scala-2.11/classes...
[error] ~/workplace/typed-skinny-micro/src/main/scala/sample/AsyncApp.scala:7: type mismatch;
[error]  found   : skinny.micro.response.ActionResult
[error]  required: scala.concurrent.Future[skinny.micro.ActionResult]
[error]     (which expands to)  scala.concurrent.Future[skinny.micro.response.ActionResult]
[error]     Ok("Hello, World!")
[error]       ^
```

Returning `scala.concurrent.Future[skinny.micro.ActionResult]` works.

```scala
package sample
import skinny.micro._
import scala.concurrent.Future

object AsyncApp extends TypedAsyncWebApp {

  get("/async/hello") { implicit ctx =>
    Future { Ok("Hello, World!") }
  }
}
```

### How to run samples

```bash
brew install sbt
sbt ~;container:restart
```

### License

The MIT License

