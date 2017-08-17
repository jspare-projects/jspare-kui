package sample.view

import org.jspare.kui.ui.View
import org.jspare.kui.ui.widget.Text
import org.jspare.kui.ui.widget.Title

class HomeView : View() {

    init {

        addElements(
            Title().withValue("Página Inicial"),
            Text().withValue("Olá Mundo")
        )
    }
}
