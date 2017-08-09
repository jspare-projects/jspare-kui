package org.jspare.kui.ui

class Input : Field() {

    var type: InputType? = InputType.TEXT

    fun withType(type: InputType): Field {
        this.type = type
        return this
    }

    enum class InputType {
        TEXT,
        PASSWORD
    }
}
