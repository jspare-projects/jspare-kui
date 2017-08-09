package org.jspare.kui.ui

import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.http.HttpServerRequest
import io.vertx.core.http.HttpServerResponse
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import org.jspare.kui.i18n.I18n
import java.util.*
import javax.inject.Inject

abstract class View() {

    @Inject val i18n: I18n? = null
    val viewContext = JsonObject()

    var routingContext: RoutingContext? = null
    var request: HttpServerRequest? = null
    var response: HttpServerResponse? = null

    private val elements = ArrayList<Renderable>()

    fun addElement(renderable: Renderable): View {
        this.elements.add(renderable)
        return this
    }

    fun render(component: Renderable) {

        component.render()
    }

    fun render(component: Renderable, handler: Handler<AsyncResult<String>>) {

        component.render(handler)
    }

    fun i18n(key: String): String {
        return i18n(key, key)
    }

    fun i18n(key: String, defaultValue: String = ""): String {
        return i18n?.get(key) ?: defaultValue
    }

}