package org.jspare.kui.internal

import io.vertx.core.json.JsonObject
import org.apache.commons.lang.StringUtils
import org.jspare.kui.Renderable
import org.jspare.kui.ui.annotations.hook
import org.jspare.kui.ui.annotations.scripts
import org.jspare.kui.ui.annotations.template
import java.io.File
import java.lang.reflect.Field
import java.lang.reflect.Method
import java.util.*
import kotlin.collections.ArrayList

object RenderableReflector {

    fun scripts(renderable: Renderable): List<String>? {
        return scripts(renderable, renderable::class.java)
    }

    private fun <T> scripts(renderable: Renderable, javaClass: Class<T>): List<String> {

        val scripts = ArrayList<String>()

        if (javaClass.superclass != null) {
            scripts.addAll(scripts(renderable, javaClass.superclass))
        }

        val ann = javaClass.annotations.find { it is scripts } as? scripts
        if (ann != null) scripts.addAll(ann?.value)
        return scripts
    }

    fun template(renderable: Renderable): String? {
        return template(renderable, renderable::class.java)
    }

    private fun <T> template(renderable: Renderable, javaClass: Class<T>): String {

        var sTemplate = StringUtils.EMPTY
        if (javaClass.superclass != null) {
            sTemplate = template(renderable, javaClass.superclass)
        }

        if (javaClass.isAnnotationPresent(template::class.java)) {
            sTemplate = parseTemplate(javaClass.getAnnotation(template::class.java).value)
        }

        if (StringUtils.isEmpty(sTemplate)) {
            sTemplate = parseTemplate(renderable::class.qualifiedName!!)
        }
        return sTemplate;
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
                        data.put(f.getAnnotation(hook::class.java).value, f.get(renderable)?.toString() ?: StringUtils.EMPTY)
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
                        data.put(m.getAnnotation(hook::class.java).value, m.invoke(renderable)?.toString() ?: StringUtils.EMPTY)
                    } catch (e: IllegalAccessException) {
                        /** ignore  */
                        error("failed to read member ${m.name} with error ${e.message}")
                    }
                }
        return data
    }

    private fun parseTemplate(string: String): String = string.replace(".", File.separator)
}