package org.jspare.kui.internal

import io.vertx.core.json.JsonObject
import org.apache.commons.lang.StringUtils
import org.jspare.kui.Renderable
import org.jspare.kui.ui.Script
import org.jspare.kui.ui.Template
import org.jspare.kui.ui.hook
import java.io.File
import java.lang.reflect.Field
import java.lang.reflect.Method
import java.util.*

object RenderableReflector {

    fun scripts(renderable: Renderable): Array<String>? {
        val ann = renderable::class.annotations.find { it is Script } as? Script
        return ann?.value
    }

    fun template(renderable: Renderable): String? {
        return template(renderable, renderable::class.java)
    }

    private fun <T> template(renderable: Renderable, javaClass: Class<T>): String {

        var template = StringUtils.EMPTY
        if (javaClass.superclass != null) {
            template = template(renderable, javaClass.superclass)
        }

        if (javaClass.isAnnotationPresent(Template::class.java)) {
            template = parseTemplate(javaClass.getAnnotation(Template::class.java).value)
        }

        if (StringUtils.isEmpty(template)) {
            template = parseTemplate(renderable::class.qualifiedName!!)
        }
        return template;
    }

    fun <T> data(renderable: Renderable, javaClass: Class<T>): JsonObject {

        // XXX Refactor to kotlin api
        val data = JsonObject()

        // recursive member resolver
        if (javaClass.superclass != null) {
            data.mergeIn(data(renderable, javaClass.superclass))
        }

        Arrays.asList<Field>(*javaClass.declaredFields)
                .stream()
                .filter { f -> f.isAnnotationPresent(hook::class.java) }
                .forEach { f ->
                    try {
                        f.isAccessible = true
                        data.put("_${f.name}", f.get(renderable)?.toString() ?: StringUtils.EMPTY)
                    } catch (e: IllegalAccessException) {
                        /** ignore  */
                        error("failed to read member ${f.name} with error ${e.message}")
                    }
                }
        Arrays.asList<Method>(*javaClass.declaredMethods)
                .stream()
                .filter { f -> f.isAnnotationPresent(hook::class.java) }
                .forEach { m ->
                    try {
                        m.isAccessible = true
                        data.put("_${m.name}", m.invoke(renderable)?.toString() ?: StringUtils.EMPTY)
                    } catch (e: IllegalAccessException) {
                        /** ignore  */
                        error("failed to read member ${m.name} with error ${e.message}")
                    }
                }
        return data
    }

    private fun parseTemplate(string: String): String = string.replace(".", File.separator)
}