package org.jspare.kui.handler

import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.http.HttpServerRequest
import io.vertx.core.http.HttpServerResponse
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import org.jspare.core.Environment.my
import org.jspare.kui.I18n
import org.jspare.kui.Renderable

abstract class ViewHandler {

    var routingContext: RoutingContext? = null
    var request: HttpServerRequest? = null
    var response: HttpServerResponse? = null
    var viewContext: JsonObject? = null

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
        return my(I18n::class.java)[key] ?: defaultValue
    }
}
