package org.jspare.kui

import io.vertx.core.http.HttpMethod
import org.jspare.kui.utils.fluently

object DataSources {

    private val dataMap = HashMap<String, String>()

    fun put(ds: String, endpoint: String) = fluently {
        dataMap[ds] = endpoint
    }

    fun get(ds: String): String? {
        return dataMap[ds]
    }
}

inline fun rest(ds: String, method: HttpMethod, path: String): Rest {
    return Rest(ds, method, path)
}