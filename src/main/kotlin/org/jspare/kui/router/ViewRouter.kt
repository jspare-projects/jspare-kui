package org.jspare.kui.router

import kotlin.reflect.KClass

interface ViewRouter {

    fun route(path: String?, resource: KClass<*>?): ViewRouter

    fun build()
}
