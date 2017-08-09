package org.jspare.kui.router.impl

import org.jspare.kui.router.ViewRouter

class ViewRouterImpl : ViewRouter {

    private var routes: Map<String, Class<*>>? = null
    private var builded = false

    init {
        routes = HashMap()
    }

    override fun route(path: String, resource: Class<*>): ViewRouter? {
        return null
    }

    override fun build() {

        if (builded) return else builded = true

    }
}
