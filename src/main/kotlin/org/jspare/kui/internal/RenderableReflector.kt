package org.jspare.kui.internal

import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import org.jspare.kui.Renderable
import org.jspare.kui.ui.Script
import org.jspare.kui.ui.Template
import java.io.File
import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty

object RenderableReflector {

    private val ALLOWED_TYPES = arrayOf(String::class,
            Integer::class,
            Float::class,
            Boolean::class,
            Double::class,
            JsonObject::class,
            JsonArray::class
    )

    fun scripts(renderable: Renderable): Array<String>? {
        val ann = renderable::class.annotations.find { it is Script } as? Script
        return ann?.value
    }

    fun template(renderable: Renderable): String? {
        val ann = renderable::class.annotations.find { it is Template } as? Template
        return ann?.value ?: parseTemplate(renderable::class.qualifiedName!!)
    }

    fun data(renderable: Renderable): JsonObject {

        val hooks = JsonObject()

        renderable::class.members.forEach {

            if (it is KMutableProperty<*>) {
                val value = it.call(renderable)
                hooks.put("_${it.name}", if (ALLOWED_TYPES.contains(it.returnType as KClass<out Any>)) value else value.toString())
            }
        }
        return hooks
    }


    private fun parseTemplate(string: String): String = string.replace(".", File.separator)
}