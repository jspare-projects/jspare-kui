package org.jspare.kui.toolkit.html

import io.vertx.ext.web.templ.HandlebarsTemplateEngine
import io.vertx.ext.web.templ.TemplateEngine
import org.jspare.kui.Toolkit
import org.jspare.vertx.AbstractModule

class HtmlToolkitModule : AbstractModule() {

    override fun load() {

        bind(TemplateEngine::class.java).registry(HandlebarsTemplateEngine.create())
        bind(Toolkit::class.java).to(HtmlToolkitImpl::class.java).registry()
    }
}
