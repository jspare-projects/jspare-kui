package org.jspare.kui.ui.widget

import org.jspare.kui.ui.hook

open class Title : Text() {

    @hook
    var heading: Heading = Heading.H1
}