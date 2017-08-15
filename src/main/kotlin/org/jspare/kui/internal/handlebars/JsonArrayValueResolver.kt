package org.jspare.kui.internal.handlebars

import com.github.jknack.handlebars.ValueResolver
import io.vertx.core.json.JsonArray

import java.util.Collections
import kotlin.collections.Map.Entry

class JsonArrayValueResolver : ValueResolver {

    override fun resolve(context: Any): Any {
        if (context is JsonArray) {
            return context
        }
        return ValueResolver.UNRESOLVED
    }

    override fun resolve(context: Any, name: String): Any {
        if (context is JsonArray) {
            val jsonArray = context
            if ("length" == name || "size" == name) {
                return jsonArray.size()
            }
            // NumberFormatException will bubble up and cause a HandlebarsException with line, row info
            val value = jsonArray.getValue(Integer.valueOf(name)!!)
            if (value != null) {
                return value
            }
        }
        return ValueResolver.UNRESOLVED
    }

    override fun propertySet(context: Any): Set<Entry<String, Any>> {
        return emptySet()
    }

    companion object {
        val INSTANCE: ValueResolver = JsonArrayValueResolver()
    }
}