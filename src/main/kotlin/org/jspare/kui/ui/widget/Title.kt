package org.jspare.kui.ui.widget

import org.jspare.kui.ui.annotations.hook

open class Title : Text() {

    @hook("_heading")
    var heading: Heading = Heading.H1
}