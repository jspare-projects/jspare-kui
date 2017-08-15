package org.jspare.kui.internal

import org.jspare.kui.ViewRouter
import kotlin.reflect.KClass

class ViewRouterImpl : ViewRouter {
    private var routes: Map<String, Class<*>>? = null

    private var builded = false
    init {
        routes = HashMap()
    }

    override fun route(path: String?, resource: KClass<*>?): ViewRouter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun build() {

        if (builded) return else builded = true

    }
}
