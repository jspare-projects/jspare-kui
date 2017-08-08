package sample

import org.jspare.kui.KuiModule
import org.jspare.kui.toolkit.html.HtmlToolkitModule
import org.jspare.vertx.JspareVerticle
import org.jspare.vertx.annotation.Module
import org.jspare.vertx.annotation.Modules

@Modules(Module(HtmlToolkitModule::class), Module(KuiModule::class))
class AplicationVerticle : JspareVerticle() {

}