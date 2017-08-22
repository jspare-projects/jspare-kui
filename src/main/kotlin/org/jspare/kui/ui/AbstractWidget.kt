package org.jspare.kui.ui

import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import org.jspare.core.Environment
import org.jspare.kui.Toolkit
import org.jspare.kui.utils.fluently
import org.jspare.kui.ui.widget.Attribute

abstract class AbstractWidget : Widget {

    val data: JsonObject = JsonObject()

    override var id: String = ""
    override var attributes: Array<Attribute> = emptyArray()
    override var classes: Array<String> = emptyArray()
    override var style: String = ""

    fun data(): JsonObject = this.data

    fun withId(id: String): Widget = fluently { this.id = id }

    override fun addAttribute(attr: Attribute): Widget = fluently { attributes.plus(attr) }

    override fun addClass(oneClass: String): Widget = fluently { classes.plus(oneClass) }

    override fun render(context: RoutingContext): String =
            Environment.my(Toolkit::class.java).render(context, this);
}
