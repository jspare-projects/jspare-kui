package org.jspare.kui.internal

import io.vertx.ext.unit.TestContext
import io.vertx.ext.web.RoutingContext
import org.jspare.core.internal.Bind
import org.jspare.kui.Toolkit
import org.jspare.kui.ui.Template
import org.jspare.kui.ui.View
import org.jspare.kui.ui.widget.Input
import org.jspare.unit.mock.Mocker
import org.jspare.vertx.unit.ext.junit.VertxJspareUnitRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(VertxJspareUnitRunner::class)
class HtmlToolkitImplTest {

    @Before
    fun setup() {
        Bind
                .bind(Toolkit::class.java)
                .to(HtmlToolkitImpl::class.java)
                .registry()
    }

    @Test
    fun ct_01(ctx: TestContext) {

        val rCtx = Mocker.createProxy(RoutingContext::class.java)
        ctx.assertEquals(readCt("/ct_01.html"), Input().render(rCtx))
    }

    @Test
    fun ct_02(ctx: TestContext) {

        val rCtx = Mocker.createProxy(RoutingContext::class.java)
        ctx.assertEquals(readCt("/ct_02.html"), SampleView(rCtx).render(rCtx))
    }

    @Test
    fun ct_03(ctx: TestContext) {

        val rCtx = Mocker.createProxy(RoutingContext::class.java)
        val template = RenderableReflector.template(SampleView(rCtx))
        ctx.assertEquals("org\\jspare\\kui\\ui\\widget\\View", template)
    }

    @Test
    fun ct_04(ctx: TestContext) {

        val rCtx = Mocker.createProxy(RoutingContext::class.java)
        val template = RenderableReflector.template(CustomSampleView(rCtx))
        ctx.assertEquals("CustomSampleView", template)
    }


    private fun readCt(name: String) = HtmlToolkitImplTest::class.java.getResource(name).readText()

    class SampleView(routingContext: RoutingContext) : View(routingContext) {
        init {
            addElement(Input())
        }
    }

    @Template("CustomSampleView")
    class CustomSampleView(routingContext: RoutingContext) : View(routingContext)
}