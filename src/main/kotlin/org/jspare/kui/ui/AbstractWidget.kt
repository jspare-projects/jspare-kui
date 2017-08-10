package org.jspare.kui.ui

import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import org.jspare.kui.ui.widget.Attribute
import java.util.*

abstract class AbstractWidget : Widget {

    override var attributes: Array<Attribute> = emptyArray()
    override var classes: Array<String> = emptyArray()
    override var style: String = ""

    init {
        this.id = UUID.randomUUID().toString()
    }

    fun withId(id: String): Widget {
        this.id = id
        return this
    }

    override fun addAttribute(attr: Attribute): Widget {
        attributes.plus(attr)
        return this
    }

    override fun addClass(oneClass: String): Widget {
        classes.plus(oneClass)
        return this
    }

    override fun render(): String {
        return ""
    }

    override fun render(ar: Handler<AsyncResult<String>>) {}
}
