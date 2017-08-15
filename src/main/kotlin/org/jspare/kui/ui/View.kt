package org.jspare.kui.ui

import io.vertx.core.http.HttpServerRequest
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import org.jspare.kui.I18n
import org.jspare.kui.Renderable
import java.util.*
import javax.inject.Inject

abstract class View() {

    @Inject val i18n: I18n? = null
    val data = JsonObject()
    var routingContext: RoutingContext? = null
    private var request: HttpServerRequest? = null
    val elements = ArrayList<Renderable>()

    fun addElement(renderable: Renderable): View {
        this.elements.add(renderable)
        return this
    }

    fun addElements(vararg renderables: Renderable): View {
        this.elements.addAll(renderables)
        return this
    }

    fun getParam(paramName: String) = request?.getParam(paramName)

    fun i18n(key: String): String = i18n(key, key)

    fun i18n(key: String, defaultValue: String = ""): String = i18n?.get(key) ?: defaultValue
}