package org.jspare.kui.ui.widget

import org.jspare.kui.fluently
import org.jspare.kui.ui.Field
import org.jspare.kui.ui.hook

class Input : Field() {

    @hook var type: InputType? = InputType.TEXT

    fun withType(type: InputType): Field = fluently { this.type = type }
}
