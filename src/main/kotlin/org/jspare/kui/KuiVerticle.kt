package org.jspare.kui

import io.vertx.core.Handler
import io.vertx.core.http.HttpServerOptions
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.ext.web.handler.StaticHandler
import org.jspare.kui.internal.ViewRouterImpl
import org.jspare.vertx.JspareVerticle
import org.jspare.vertx.web.builder.HttpServerBuilder
import org.jspare.vertx.web.builder.RouterBuilder
import org.slf4j.LoggerFactory

abstract class KuiVerticle : JspareVerticle() {

    private val log = LoggerFactory.getLogger(KuiVerticle::class.java)

    override fun start() {

        val rBuilder = RouterBuilder
                .create(vertx)
                .router(ViewRouterImpl(vertx!!))
                // Allow access to all static
                .route({ it.path("/static/*").handler(StaticHandler.create("static")) })

        handlers().forEach { rBuilder.addHandler(it) }

        val router = rBuilder.build()

        bootstrap(router as ViewRouter)

        val httpServer = HttpServerBuilder
                .create(vertx)
                .httpServerOptions(httpServerOptions())
                .build()

        httpServer.requestHandler(router::accept)
        httpServer.listen({
            if (it.failed()) {
                log.error("Failed no start KUI Applicaiton", it.cause())
                return@listen
            }
            log.info("KUI Application started on port ${it.result().actualPort()}")
        })
    }

    protected fun handlers(): Array<Handler<RoutingContext>> {
        return arrayOf(
                BodyHandler.create()
        )
    }

    protected open fun httpServerOptions(): HttpServerOptions {
        return HttpServerOptions(config)
    }

    abstract fun bootstrap(viewRouter: ViewRouter)
}
