package org.jspare.kui.widgets

abstract class Field : AbstractWidget() {

    var label: String? = null

    fun withLabel(label: String): Field {
        this.label = label
        return this
    }
}
