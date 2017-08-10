package org.jspare.kui.ui

import org.jspare.kui.Renderable
import org.jspare.kui.ui.widget.Attribute

interface Widget : Renderable {

    var id: String
    var attributes: Array<Attribute>
    var classes: Array<String>
    var style: String
    fun addAttribute(attr: Attribute): Widget
    fun addClass(oneClass: String): Widget

}
