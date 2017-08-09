package sample

import org.jspare.kui.BootstrapModule
import org.jspare.kui.KuiVerticle
import org.jspare.kui.router.ViewRouter
import org.jspare.vertx.annotation.Module
import org.jspare.vertx.annotation.Modules
import sample.view.HomeView

@Modules(Module(BootstrapModule::class))
class AplicationVerticle : KuiVerticle() {

    override fun bootstrap(viewRouter: ViewRouter) {
        viewRouter.route("/home", HomeView::class)
        viewRouter.route("/inicio", HomeView::class)
        viewRouter.route("/hola", HomeView::class)
    }
}

