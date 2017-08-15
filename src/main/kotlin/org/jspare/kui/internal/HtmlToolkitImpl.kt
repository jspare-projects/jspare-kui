package org.jspare.kui.internal

import com.github.jknack.handlebars.Context
import com.github.jknack.handlebars.Handlebars
import com.github.jknack.handlebars.Template
import com.github.jknack.handlebars.ValueResolver
import com.github.jknack.handlebars.io.ClassPathTemplateLoader
import com.github.jknack.handlebars.io.TemplateLoader
import io.vertx.core.file.FileSystem
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import org.apache.commons.lang.StringUtils
import org.jspare.kui.Renderable
import org.jspare.kui.Toolkit
import org.jspare.kui.internal.handlebars.JsonArrayValueResolver
import org.jspare.kui.internal.handlebars.JsonObjectValueResolver
import java.util.*
import javax.inject.Inject


class HtmlToolkitImpl : Toolkit {

    @Inject val fs: FileSystem? = null

    private val resolvers: Array<ValueResolver> = arrayOf(JsonArrayValueResolver.INSTANCE, JsonObjectValueResolver.INSTANCE).plus(ValueResolver.VALUE_RESOLVERS)

    private val loader: TemplateLoader = ClassPathTemplateLoader()
    private val handlebars: Handlebars = Handlebars(loader)

    private class TemplateResource @Throws(NoSuchMethodException::class, SecurityException::class)

    constructor(private val content: String, clazz: Class<*>) {

        fun apply(routingContext: RoutingContext, data: JsonObject): String {
            return ""
        }

    }

    private val templates = HashMap<String, TemplateResource>()

    override fun render(routingContext: RoutingContext, component: Renderable): String {

        //
        val pScripts = RenderableReflector.scripts(component)
        val pTemplate = RenderableReflector.template(component)
        val pData = RenderableReflector.data(component)

        val template: Template? = handlebars.compile(pTemplate)

        val context = Context.newBuilder(pData).resolver(*resolvers).build()

        return template?.apply(context) ?: StringUtils.EMPTY
    }
}
