package org.jspare.kui.ui.widget

import io.vertx.ext.web.RoutingContext
import org.jspare.kui.DataSource
import org.jspare.kui.ui.AbstractWidget
import org.jspare.kui.ui.Field
import org.jspare.kui.ui.hook
import org.jspare.kui.utils.fluently
import java.util.*

class Form(val rCtx: RoutingContext) : AbstractWidget() {

    private val fields = ArrayList<Field>()

    var dataSource: DataSource? = null

    fun addField(field: Field): Form = fluently {
        this.fields.add(field)
    }

    fun addFields(vararg field: Field): Form = fluently {
        this.fields.addAll(field)
    }

    fun dataSource(dataSource: DataSource): Form = fluently { this.dataSource = dataSource }

    @hook
    private fun elements(): String {
        val builder = StringBuilder()
        fields.forEach { builder.append(it.render(rCtx!!)) }
        return builder.toString()
    }
}
