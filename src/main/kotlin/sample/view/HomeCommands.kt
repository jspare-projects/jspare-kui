package sample.view

import org.jspare.kui.View
import org.jspare.kui.handler.ViewHandler
import org.jspare.kui.widgets.Container
import org.jspare.kui.widgets.DataGrid
import org.jspare.kui.widgets.Form
import org.jspare.kui.widgets.Input
import org.jspare.vertx.web.annotation.handling.Parameter

class HomeCommands : ViewHandler() {

    @View("/home", "/inicio")
    fun home() {

        val container = Container().addChild(Input().withLabel(i18n("label1"))).addChild(Input().withLabel("label2"))
        render(container)
    }

    @View("/usuarios")
    fun listUsers() {

        val container = Container().addChild(
                DataGrid()
        )
        render(container)
    }

    @View("/nome/:nome")
    fun getUser(@Parameter("nome") nome: String) {

        val container = Container();
        container.addChild(Form()
                .addField(Input().withLabel("users.name")))
        render(container)
    }
}
