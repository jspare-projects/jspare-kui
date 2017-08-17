package org.jspare.kui.ui

import org.jspare.kui.fluently

abstract class Field : AbstractWidget() {

    var label: String? = null

    var name: String? = null

    fun withLabel(label: String): Field = fluently { this.label = label }
}
