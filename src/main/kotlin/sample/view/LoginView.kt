package sample.view

import org.jspare.kui.ui.widget.Form
import org.jspare.kui.ui.widget.Input
import org.jspare.kui.ui.View

class LoginView : View() {

    init {

        addElement(
                Form()
                        .addField(Input().withLabel("Usuário"))
                        .addField(Input().withType(Input.InputType.PASSWORD).withLabel("Senha"))
        )
    }
}
