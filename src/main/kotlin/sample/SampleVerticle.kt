package sample

import org.jspare.kui.KuiModule
import org.jspare.kui.KuiVerticle
import org.jspare.kui.ViewRouter
import org.jspare.vertx.annotation.Module
import org.jspare.vertx.annotation.Modules

@Modules(Module(KuiModule::class))
class SampleVerticle : KuiVerticle() {

    override fun bootstrap(viewRouter: ViewRouter) {

        viewRouter.route(SampleView::class)
    }
}