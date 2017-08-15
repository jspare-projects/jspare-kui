package org.jspare.kui.ui.widget

import org.jspare.kui.fluently
import org.jspare.kui.ui.Field

class Input : Field() {

    var type: InputType? = InputType.TEXT

    fun withType(type: InputType): Field = fluently { this.type = type }
}
