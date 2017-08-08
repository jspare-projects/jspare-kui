package org.jspare.kui.widgets

import org.jspare.kui.Renderable

import java.util.ArrayList

class Container : AbstractWidget()   {

    private val elements = ArrayList<Renderable>()

    fun addChild(renderable: Renderable): Container {
        this.elements.add(renderable)
        return this
    }
}
