package sample.view

import org.jspare.kui.ui.Form
import org.jspare.kui.ui.Input
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
