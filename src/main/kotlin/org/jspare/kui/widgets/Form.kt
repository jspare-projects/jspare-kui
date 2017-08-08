package org.jspare.kui.widgets

import java.util.*

class Form : AbstractWidget() {

    private val fields = ArrayList<Field>()

    fun addField(field: Field): Form {
        this.fields.add(field)
        return this
    }
}
