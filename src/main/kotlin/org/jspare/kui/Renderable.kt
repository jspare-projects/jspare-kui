package org.jspare.kui

import io.vertx.ext.web.RoutingContext

interface Renderable {

    fun render(context: RoutingContext): String
}