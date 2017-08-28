package sample

import io.vertx.core.http.HttpServerOptions
import org.jspare.kui.DataSources
import org.jspare.kui.KuiModule
import org.jspare.kui.KuiVerticle
import org.jspare.kui.ViewRouter
import org.jspare.vertx.annotation.Module
import org.jspare.vertx.annotation.Modules

@Modules(Module(KuiModule::class))
class SampleVerticle : KuiVerticle() {

    override fun bootstrap(viewRouter: ViewRouter) {

        DataSources.put("api", "http://localhost:8000")

        viewRouter
            .notFoundRoute(PageNotFoundView::class)
            .route(SampleView::class)
    }

    override fun httpServerOptions(): HttpServerOptions
            = HttpServerOptions().setPort(8080)
}