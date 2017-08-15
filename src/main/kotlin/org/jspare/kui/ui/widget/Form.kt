package org.jspare.kui.ui.widget

import org.jspare.kui.fluently
import org.jspare.kui.ui.AbstractWidget
import org.jspare.kui.ui.Field
import java.util.*

class Form : AbstractWidget() {

    private val fields = ArrayList<Field>()

    fun addField(field: Field): Form = fluently {
        this.fields.add(field)
    }
}
