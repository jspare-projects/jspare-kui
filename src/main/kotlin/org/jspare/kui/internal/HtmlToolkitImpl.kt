package org.jspare.kui.internal

import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.templ.TemplateEngine
import org.jspare.kui.Renderable
import org.jspare.kui.Toolkit

import java.util.HashMap
import javax.inject.Inject

class HtmlToolkitImpl : Toolkit {

    @Inject val temEng: TemplateEngine? = null

    private class Template @Throws(NoSuchMethodException::class, SecurityException::class)

    constructor(private val content: String, clazz: Class<*>) {

        fun apply(routingContext: RoutingContext, data: JsonObject): String {
            return ""
        }
    }

    private val templates = HashMap<String, Template>()

    override fun render(component: Renderable): String {
        return ""
    }
}
