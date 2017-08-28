package org.jspare.kui

import io.vertx.core.http.HttpMethod
import org.jspare.kui.utils.fluently

class Rest(val endpoint: String, val httpMethod: HttpMethod, val path: String) : DataSource {

    private var queryParameters: Array<String> = emptyArray()

    private var headers: Map<String, String> = emptyMap()

    fun queryParameters(queryParameters: Array<String>) = fluently { this.queryParameters = queryParameters }

    fun headers(headers: Map<String, String>) = fluently { this.headers = headers }
}