package org.jspare.kui

import org.jspare.kui.internal.HtmlToolkitImpl
import org.jspare.vertx.AbstractModule

class KuiModule : AbstractModule() {

    override fun load() {
        bind(Toolkit::class.java).to(HtmlToolkitImpl::class.java).registry()
    }
}
