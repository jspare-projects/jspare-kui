package org.jspare.kui.ui

import io.vertx.core.AsyncResult
import io.vertx.core.Handler

interface Renderable {

    val id: String
    fun render(): String
    fun render(ar: Handler<AsyncResult<String>>)
}