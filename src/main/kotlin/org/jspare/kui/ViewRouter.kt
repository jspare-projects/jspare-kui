package org.jspare.kui

import kotlin.reflect.KClass

interface ViewRouter {

    fun route(path: String?, resource: KClass<*>?): ViewRouter

    fun build()
}
