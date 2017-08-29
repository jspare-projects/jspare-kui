package org.jspare.kui.internal

import com.github.jknack.handlebars.Context
import com.github.jknack.handlebars.Handlebars
import com.github.jknack.handlebars.Template
import com.github.jknack.handlebars.ValueResolver
import com.github.jknack.handlebars.io.ClassPathTemplateLoader
import com.github.jknack.handlebars.io.TemplateLoader
import io.vertx.core.shareddata.SharedData
import io.vertx.ext.web.RoutingContext
import org.apache.commons.lang.StringUtils
import org.jspare.kui.Renderable
import org.jspare.kui.SHARED_CONTEXT
import org.jspare.kui.Toolkit
import org.jspare.kui.internal.handlebars.JsonArrayValueResolver
import org.jspare.kui.internal.handlebars.JsonObjectValueResolver
import javax.inject.Inject


class HtmlToolkitImpl : Toolkit {

    @Inject
    private lateinit var sharedData: SharedData

    private val resolvers: Array<ValueResolver> = arrayOf(JsonArrayValueResolver.INSTANCE, JsonObjectValueResolver.INSTANCE).plus(ValueResolver.VALUE_RESOLVERS)
    private val loader: TemplateLoader = ClassPathTemplateLoader()
    private val handlebars: Handlebars = Handlebars(loader)

    override fun render(rCtx: RoutingContext, component: Renderable): String {

        addScriptOnRoutingContext(rCtx, component)

        val pTemplate = RenderableReflector.template(component)
        val pData = RenderableReflector.data(component, component.javaClass)

        val lMap = sharedData.getLocalMap<String, String>(SHARED_CONTEXT)
        lMap.keySet().forEach({
            pData.put(it, lMap[it])
        })

        val template: Template? = handlebars.compile(pTemplate)
        val context = Context.newBuilder(pData).resolver(*resolvers).build()
        return template?.apply(context) ?: StringUtils.EMPTY
    }

    private fun addScriptOnRoutingContext(rCtx: RoutingContext, component: Renderable) {

        val scripts = rCtx.get<ArrayList<String>>("_scripts") ?: ArrayList()
        val pScripts = RenderableReflector.scripts(component) ?: ArrayList()

        pScripts.forEach { scripts.add(it) }

        rCtx.put("_scripts", scripts)
    }
}
