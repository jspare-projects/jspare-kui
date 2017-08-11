package org.jspare.kui.ui.widget

import org.jspare.kui.ui.AbstractWidget
import org.jspare.kui.ui.Field
import java.util.*

class Form : AbstractWidget() {
    override var id: String
        get() = this.id
        set(value) {
            this.id = value
        }

    private val fields = ArrayList<Field>()

    fun addField(field: Field): Form {
        this.fields.add(field)
        return this
    }
}
