package org.jspare.kui.ui.widget

import org.jspare.kui.Renderable
import org.jspare.kui.ui.AbstractWidget
import java.util.ArrayList

class Container : AbstractWidget()   {

    private val elements = ArrayList<Renderable>()

    fun addChild(renderable: Renderable): Container {
        this.elements.add(renderable)
        return this
    }
}
