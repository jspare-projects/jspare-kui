package org.jspare.kui.ui.widget

import org.jspare.kui.ui.AbstractWidget
import org.jspare.kui.ui.Widget

open class Text : AbstractWidget() {

    var value: String? = ""

    fun withValue(value: String): Widget = fluently { this.value = value }
}