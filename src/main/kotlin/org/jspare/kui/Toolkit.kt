package org.jspare.kui

import io.vertx.ext.web.RoutingContext

open interface Toolkit {

    fun render(context: RoutingContext, component: Renderable): String
}
