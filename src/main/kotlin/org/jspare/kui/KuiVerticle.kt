package org.jspare.kui

import io.vertx.core.Handler
import io.vertx.core.http.HttpServerOptions
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.BodyHandler
import org.jspare.kui.internal.ViewRouterImpl
import org.jspare.vertx.JspareVerticle
import org.jspare.vertx.web.builder.HttpServerBuilder
import org.jspare.vertx.web.builder.RouterBuilder
import org.slf4j.LoggerFactory

abstract class KuiVerticle : JspareVerticle() {

    private val log = LoggerFactory.getLogger(KuiVerticle::class.java)

    override fun start() {

        val rBuilder = RouterBuilder.create(vertx)

        handlers().forEach { rBuilder.addHandler(it) }

        val router = rBuilder.build()

        val viewRouter = ViewRouterImpl(router)
        bootstrap(viewRouter)
        viewRouter.build()

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

    fun handlers(): Array<Handler<RoutingContext>> {
        return arrayOf(
                BodyHandler.create()
        )
    }

    fun httpServerOptions(): HttpServerOptions {
        return HttpServerOptions(config)
    }

    abstract fun bootstrap(viewRouter: ViewRouter)
}
