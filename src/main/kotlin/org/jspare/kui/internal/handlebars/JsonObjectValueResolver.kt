package org.jspare.kui.internal.handlebars

import com.github.jknack.handlebars.ValueResolver
import io.vertx.core.json.JsonObject
import kotlin.collections.Map.Entry

class JsonObjectValueResolver : ValueResolver {

    override fun resolve(context: Any, name: String): Any {
        var value: Any? = null
        if (context is JsonObject) {
            value = context.getValue(name)
        }
        return if (value == null) ValueResolver.UNRESOLVED else value
    }

    override fun resolve(context: Any): Any {
        if (context is JsonObject) {
            return context
        }
        return ValueResolver.UNRESOLVED
    }

    override fun propertySet(context: Any): Set<Entry<String, Any>> {
        if (context is JsonObject) {
            return context.map.entries
        }
        return emptySet()
    }

    companion object {

        val INSTANCE: ValueResolver = JsonObjectValueResolver()
    }
}