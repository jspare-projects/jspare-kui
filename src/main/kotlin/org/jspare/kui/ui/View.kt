package org.jspare.kui.ui

import io.vertx.ext.web.RoutingContext
import org.jspare.core.Environment
import org.jspare.kui.I18n
import org.jspare.kui.Renderable
import org.jspare.kui.utils.fluently

@Template("org.jspare.kui.ui.widget.View")
abstract class View(val rCtx: RoutingContext) : AbstractWidget() {

    private val elements = mutableListOf<Renderable>()

    fun addElement(renderable: Renderable): View = fluently { elements.add(renderable) }

    fun addElements(vararg renderables: Renderable): View = fluently { elements.addAll(renderables) }

    fun getParam(paramName: String) = rCtx.request()?.getParam(paramName)

    fun i18n(key: String): String = i18n(key, key)

    fun i18n(key: String, defaultValue: String = ""): String = Environment.my(I18n::class.java)?.get(key) ?: defaultValue

    @hook
    private fun elements(): String {

        val builder = StringBuilder()
        elements.forEach { builder.append(it.render(rCtx)) }
        return builder.toString()
    }
}