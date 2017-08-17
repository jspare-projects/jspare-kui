package org.jspare.kui.ui

import io.vertx.ext.web.RoutingContext
import org.jspare.kui.I18n
import org.jspare.kui.Renderable
import org.jspare.kui.fluently
import java.util.*
import javax.inject.Inject

abstract class View : AbstractWidget() {

    @Inject val i18n: I18n? = null
    var routingContext: RoutingContext? = null
    val elements = ArrayList<Renderable>()

    fun addElement(renderable: Renderable): View = fluently { this.elements.plus(renderable) }

    fun addElements(vararg renderables: Renderable): View = fluently { this.elements.plus(renderables) }

    fun getParam(paramName: String) = routingContext?.request()?.getParam(paramName)

    fun i18n(key: String): String = i18n(key, key)

    fun i18n(key: String, defaultValue: String = ""): String = i18n?.get(key) ?: defaultValue
}