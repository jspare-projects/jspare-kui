package sample

import org.jspare.kui.ui.View
import org.jspare.kui.ui.path
import org.jspare.kui.ui.widget.Input
import org.jspare.kui.ui.widget.InputType
import org.jspare.kui.ui.widget.Title

@path("/sample")
class SampleView : View() {

    override fun prepare() {

        withTitle("SampleView")

        addElements(
            Title().withValue("SampleView"),
            Input().withType(InputType.TEXT).withLabel("Usuário"),
            Input().withType(InputType.PASSWORD).withLabel("Senha")
        )
    }
}