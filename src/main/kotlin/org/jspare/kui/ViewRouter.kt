package org.jspare.kui

import io.vertx.ext.web.Router
import org.jspare.kui.ui.View
import kotlin.reflect.KClass

interface ViewRouter : Router {

    fun notFoundRoute(resource: KClass<*>?): ViewRouter

    fun route(resource: KClass<*>?): ViewRouter

    fun route(resource: View): ViewRouter

    fun route(path: String?, resource: KClass<*>?): ViewRouter

    fun route(path: String?, resource: View): ViewRouter
}
