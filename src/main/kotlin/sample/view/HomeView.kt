package sample.view

import org.jspare.kui.ui.View
import org.jspare.kui.ui.widget.Text

class HomeView : View() {

    init {

        addElements(
            Text().withValue("Página Inicial")
        )
    }
}
