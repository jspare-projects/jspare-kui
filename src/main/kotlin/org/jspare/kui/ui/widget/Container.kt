package org.jspare.kui.ui.widget

import org.jspare.kui.Renderable
import org.jspare.kui.utils.fluently
import org.jspare.kui.ui.AbstractWidget
import java.util.*

class Container : AbstractWidget() {

    private val elements = ArrayList<Renderable>()

    fun addChild(renderable: Renderable): Container = fluently {
        this.elements.add(renderable)
    }
}
