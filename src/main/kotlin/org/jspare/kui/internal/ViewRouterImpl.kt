package org.jspare.kui.internal

import io.netty.handler.codec.http.HttpHeaderNames
import io.vertx.core.Vertx
import io.vertx.ext.web.impl.RouterImpl
import org.jspare.kui.ViewRouter
import org.jspare.kui.ui.widget.View
import org.jspare.kui.ui.annotations.path
import org.jspare.kui.utils.fluently
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

class ViewRouterImpl(val vertx: Vertx?) : ViewRouter, RouterImpl(vertx) {

    private val log = LoggerFactory.getLogger(ViewRouterImpl::class.java)

    override fun route(resource: KClass<*>?): ViewRouter = fluently {
        route(pathFromKClass(resource), resource)
    }

    override fun route(path: String?, resource: KClass<*>?): ViewRouter = fluently {
        log.debug("Mapping View [$path] with Resource [${resource?.qualifiedName}]")
        get(path).handler({
            (resource?.primaryConstructor?.call() as View).handle(it)
        })
    }

    override fun notFoundRoute(resource: KClass<*>?): ViewRouter = fluently {
        route().last().handler({
            val content = (resource?.primaryConstructor?.call() as View).render(it)
            it.response()
                    .setStatusCode(404)
                    .putHeader(HttpHeaderNames.CONTENT_TYPE, "text/html; charset=utf-8")
                    .end(content)
        })
    }

    private fun pathFromKClass(resource: KClass<*>?): String {
        val annPath = resource?.annotations?.find { it is path } as path
        return if (annPath != null) annPath.value else "/${resource?.qualifiedName!!}"
    }
}
