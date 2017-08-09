package org.jspare.kui.ui

abstract class Field : AbstractWidget() {

    var label: String? = null

    fun withLabel(label: String): Field {
        this.label = label
        return this
    }
}
