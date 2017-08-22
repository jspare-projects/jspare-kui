package org.jspare.kui.internal

import com.github.jknack.handlebars.Context
import com.github.jknack.handlebars.Handlebars
import com.github.jknack.handlebars.Template
import com.github.jknack.handlebars.ValueResolver
import com.github.jknack.handlebars.io.ClassPathTemplateLoader
import com.github.jknack.handlebars.io.TemplateLoader
import io.vertx.ext.web.RoutingContext
import org.apache.commons.lang.StringUtils
import org.jspare.kui.Renderable
import org.jspare.kui.Toolkit
import org.jspare.kui.internal.handlebars.JsonArrayValueResolver
import org.jspare.kui.internal.handlebars.JsonObjectValueResolver


class HtmlToolkitImpl : Toolkit {

    private val resolvers: Array<ValueResolver> = arrayOf(JsonArrayValueResolver.INSTANCE, JsonObjectValueResolver.INSTANCE).plus(ValueResolver.VALUE_RESOLVERS)
    private val loader: TemplateLoader = ClassPathTemplateLoader()
    private val handlebars: Handlebars = Handlebars(loader)

    override fun render(rCtx: RoutingContext, component: Renderable): String {

        addScriptOnRoutingContext(rCtx, component)

        val pTemplate = RenderableReflector.template(component)
        val pData = RenderableReflector.data(component, component.javaClass)

        val template: Template? = handlebars.compile(pTemplate)

        val context = Context.newBuilder(pData).resolver(*resolvers).build()

        return template?.apply(context) ?: StringUtils.EMPTY
    }

    private fun addScriptOnRoutingContext (rCtx: RoutingContext, component: Renderable) {

        val scripts = rCtx.get<Array<String>>("_scripts") ?: emptyArray()
        val pScripts = RenderableReflector.scripts(component) ?: emptyArray()

        scripts.plus(pScripts)

        rCtx.put("_scripts", scripts)
    }
}
