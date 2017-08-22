package sample.view

import io.vertx.ext.web.RoutingContext
import org.jspare.kui.ui.View
import org.jspare.kui.ui.widget.Text
import org.jspare.kui.ui.widget.Title

class HomeView(routingContext: RoutingContext) : View(routingContext) {

    init {

        addElements(
                Title().withValue("Página Inicial"),
                Text().withValue("Olá Mundo")
        )
    }
}
