package sample

import io.vertx.core.json.JsonObject
import org.jspare.vertx.web.annotation.handler.Handler
import org.jspare.vertx.web.annotation.method.Post
import org.jspare.vertx.web.handler.APIHandler

class AuthRoute : APIHandler() {

    @Post
    @Handler
    fun auth(data: JsonObject) {
        success()
    }
}