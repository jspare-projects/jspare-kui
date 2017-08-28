package sample

import io.vertx.core.http.HttpMethod
import org.jspare.kui.rest
import org.jspare.kui.ui.annotations.path
import org.jspare.kui.ui.widget.*

@path("/sample")
class SampleView : View() {

    override fun prepare() {

        withTitle("SampleView")

        addElements(
            Title().withValue("SampleView"),
            Form(rCtx!!)
                .dataSource(rest("api", HttpMethod.POST, "/auth"))
                .addFields(
                        Input().withType(InputType.TEXT).withLabel("Usuário"),
                        Input().withType(InputType.PASSWORD).withLabel("Senha")
                )
        )
    }
}