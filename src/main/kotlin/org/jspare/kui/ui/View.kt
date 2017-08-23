package org.jspare.kui.ui

import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext
import org.apache.commons.lang.StringUtils
import org.jspare.core.Environment
import org.jspare.kui.I18n
import org.jspare.kui.Renderable
import org.jspare.kui.utils.fluently
import java.nio.charset.StandardCharsets

@Template("org.jspare.kui.ui.widget.View")
abstract class View() : AbstractWidget(), Handler<RoutingContext> {

    private var rCtx: RoutingContext? = null

    private val elements = mutableListOf<Renderable>()

    protected fun addElement(renderable: Renderable): View = fluently { elements.add(renderable) }

    protected fun addElements(vararg renderables: Renderable): View = fluently { elements.addAll(renderables) }

    protected fun getParam(paramName: String) = rCtx?.request()?.getParam(paramName)

    protected fun i18n(key: String): String = i18n(key, key)

    protected fun i18n(key: String, defaultValue: String = ""): String = Environment.my(I18n::class.java)?.get(key) ?: defaultValue

    var title: String = StringUtils.EMPTY

    fun withTitle(title: String) = fluently { this.title = title }

    override fun handle(rCtx: RoutingContext) {

        this.rCtx = rCtx

        prepare()

        if (!rCtx.response().ended()) {

            val content = render(rCtx)
            rCtx.response().end(content, StandardCharsets.UTF_8.toString())
        }
    }

    @hook
    private fun elements(): String {
        val builder = StringBuilder()
        elements.forEach { builder.append(it.render(rCtx!!)) }
        return builder.toString()
    }

    abstract fun prepare()
}