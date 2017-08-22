package org.jspare.kui

import kotlin.reflect.KClass

interface ViewRouter {

    fun route(path: String?, resource: KClass<*>?): ViewRouter

    fun route(path: String?, resource: Renderable): ViewRouter

    fun build()
}
