package org.jspare.kui.internal

import io.vertx.ext.web.Router
import org.jspare.kui.ViewRouter
import org.jspare.kui.ui.View
import org.jspare.kui.ui.path
import org.jspare.kui.utils.fluently
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

class ViewRouterImpl(override val router: Router) : ViewRouter {

    private val log = LoggerFactory.getLogger(ViewRouterImpl::class.java)

    private val routes: HashMap<String, View> = HashMap()

    private var builded = false

    override fun route(resource: KClass<*>?): ViewRouter {
        route(pathFromKClass(resource), resource)
        return this
    }

    override fun route(resource: View): ViewRouter {
        route(pathFromKClass(resource::class), resource)
        return this
    }

    override fun route(path: String?, resource: KClass<*>?): ViewRouter = fluently { route(path, resource?.primaryConstructor?.call() as View) }

    override fun route(path: String?, resource: View): ViewRouter = fluently {
        log.debug("Mapping View [$path] with Resource [${resource::class.qualifiedName}]")
        routes.put(path!!, resource)
    }

    override fun build() {
        if (builded) return else builded = true

        routes.forEach {
            router.get(it.key).handler(it.value)
        }
    }

    private fun pathFromKClass(resource: KClass<*>?): String {
        val annPath = resource?.annotations?.find { it is path } as path
        return if (annPath != null) annPath.value else "/${resource?.qualifiedName!!}"
    }
}
