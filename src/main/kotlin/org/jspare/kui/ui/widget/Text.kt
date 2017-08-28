package org.jspare.kui.ui.widget

import org.jspare.kui.ui.AbstractWidget
import org.jspare.kui.ui.Widget
import org.jspare.kui.ui.annotations.hook
import org.jspare.kui.utils.fluently

open class Text : AbstractWidget() {

    @hook
    var value: String? = ""

    fun withValue(value: String): Widget = fluently { this.value = value }
}