package sample.view

import org.jspare.kui.router.handler.ViewHandler
import org.jspare.kui.ui.Container
import org.jspare.kui.ui.DataGrid
import org.jspare.kui.ui.Form
import org.jspare.kui.ui.Input
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
