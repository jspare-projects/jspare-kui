package org.jspare.kui.ui.widget

import org.jspare.kui.ui.annotations.hook
import org.jspare.kui.utils.fluently

class Input : Field() {

    @hook("_type")
    var type: InputType? = InputType.TEXT

    fun withType(type: InputType): Field = fluently { this.type = type }
}
