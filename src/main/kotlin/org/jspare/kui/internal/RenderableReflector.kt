package org.jspare.kui.internal

import io.vertx.core.json.JsonObject
import org.jspare.kui.Renderable
import org.jspare.kui.ui.Script
import org.jspare.kui.ui.Template
import java.io.File

object RenderableReflector {

    fun scripts(renderable: Renderable): Array<String>? {
        val ann = renderable::class.annotations.find { it is Script } as? Script
        return ann?.value
    }

    fun template(renderable: Renderable): String? {
        val ann = renderable::class.annotations.find { it is Template } as? Template
        return ann?.value ?: parseTemplate(renderable::class.qualifiedName!!)
    }

    fun  data(component: Renderable): JsonObject {
        return JsonObject()
    }

    private fun parseTemplate(string: String): String = string.replace(".", File.separator)
}