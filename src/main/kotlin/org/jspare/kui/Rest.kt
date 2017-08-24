package org.jspare.kui

import io.vertx.core.http.HttpMethod
import org.jspare.core.Environment
import org.jspare.kui.utils.fluently

class Rest(val httpMethod: HttpMethod, val path: String) : DataSource {

    private var endpoint: String = Environment.my(String::class.java, "")

    private var queryParameters: Array<String> = emptyArray()

    private var headers: Map<String, String> = emptyMap()

    fun endpoint(endpoint: String) = fluently { this.endpoint = endpoint }

    fun queryParameters(queryParameters: Array<String>) = fluently { this.queryParameters = queryParameters }

    fun headers(headers: Map<String, String>) = fluently { this.headers = headers }
}