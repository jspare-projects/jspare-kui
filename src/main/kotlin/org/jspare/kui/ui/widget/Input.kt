package org.jspare.kui.ui.widget

import org.jspare.kui.utils.fluently
import org.jspare.kui.ui.annotations.hook

class Input : Field() {

    @hook
    var type: InputType? = InputType.TEXT

    fun withType(type: InputType): Field = fluently { this.type = type }
}
