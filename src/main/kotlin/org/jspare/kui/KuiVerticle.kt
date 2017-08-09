package org.jspare.kui

import org.jspare.kui.router.ViewRouter
import org.jspare.kui.router.impl.ViewRouterImpl
import org.jspare.vertx.JspareVerticle

abstract class KuiVerticle : JspareVerticle() {

    override fun start() {

        val viewRouter = ViewRouterImpl()
        bootstrap(viewRouter)
        viewRouter.build()
    }

    abstract fun bootstrap(viewRouter: ViewRouter)
}
