import javax.servlet._
import skinny.micro._
import sample._

class Bootstrap extends LifeCycle {
  override def init(ctx: ServletContext) {
    SimpleApp.mount(ctx)
    AsyncApp.mount(ctx)
  }
}
