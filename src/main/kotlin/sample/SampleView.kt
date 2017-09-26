package sample

import org.jspare.kui.ui.annotations.path
import org.jspare.kui.ui.widget.Sample
import org.jspare.kui.ui.widget.View

@path("/sample")
class SampleView : View() {

    override fun prepare() {

        withTitle("SampleView")

        addElements(
                Sample()
        )
    }
}