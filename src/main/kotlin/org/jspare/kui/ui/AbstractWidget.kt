package org.jspare.kui.ui

import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import org.jspare.kui.ui.widget.Attribute

abstract class AbstractWidget : Widget {

    override var attributes: Array<Attribute> = emptyArray()
    override var classes: Array<String> = emptyArray()
    override var style: String = ""
    override var id: String = ""

    fun withId(id: String): Widget = fluently { this.id = id }

    override fun addAttribute(attr: Attribute): Widget = fluently { attributes.plus(attr) }

    override fun addClass(oneClass: String): Widget = fluently { classes.plus(oneClass) }

    override fun render(): String {
        return ""
    }

    override fun render(ar: Handler<AsyncResult<String>>) {}

    fun <T : Any> T.fluently(func: () -> Unit): T {
        return this.apply { func() }
    }
}
