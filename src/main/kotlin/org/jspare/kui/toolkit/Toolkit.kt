package org.jspare.kui.toolkit

import org.jspare.kui.ui.Renderable

interface Toolkit {

    fun render(component: Renderable): String
}
