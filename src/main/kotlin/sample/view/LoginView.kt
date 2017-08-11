package sample.view

import org.jspare.kui.ui.widget.Form
import org.jspare.kui.ui.widget.Input
import org.jspare.kui.ui.View
import org.jspare.kui.ui.widget.InputType

class LoginView : View() {

    init {

        addElement(
            Form()
                .addField(Input().withLabel("Usuário"))
                .addField(Input().withType(InputType.PASSWORD).withLabel("Senha"))
        )
    }
}
