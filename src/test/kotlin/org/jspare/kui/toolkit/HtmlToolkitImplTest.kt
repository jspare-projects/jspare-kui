package org.jspare.kui.toolkit

import io.vertx.ext.unit.TestContext
import org.jspare.kui.ui.Input
import org.jspare.vertx.unit.ext.junit.VertxJspareUnitRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(VertxJspareUnitRunner::class)
class HtmlToolkitImplTest {

    @Test
    fun simple(ctx: TestContext) {

        val tk = HtmlToolkitImpl()
        ctx.assertEquals("", tk.render(Input()))
    }
}