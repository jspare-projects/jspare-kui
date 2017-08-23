package sample

import org.jspare.kui.ui.View
import org.jspare.kui.ui.widget.Title

class PageNotFoundView : View() {

    override fun prepare() {

        addElements(
            Title().withValue(i18n("general.not_found"))
        )
    }
}