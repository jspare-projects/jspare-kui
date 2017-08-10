package org.jspare.kui

import org.jspare.kui.internal.ViewRouterImpl
import org.jspare.vertx.JspareVerticle

abstract class KuiVerticle : JspareVerticle() {

    override fun start() {

        val viewRouter = ViewRouterImpl()
        bootstrap(viewRouter)
        viewRouter.build()
    }

    abstract fun bootstrap(viewRouter: ViewRouter)
}
