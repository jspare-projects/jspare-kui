package org.jspare.kui.ui.widget

import org.jspare.kui.ui.AbstractWidget
import org.jspare.kui.ui.annotations.hook
import org.jspare.kui.utils.fluently

abstract class Field : AbstractWidget() {

    @hook
    var label: String? = null

    @hook
    var name: String? = null

    fun withLabel(label: String): Field = fluently { this.label = label }
}
