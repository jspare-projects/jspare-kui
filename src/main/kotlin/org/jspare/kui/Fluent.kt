package org.jspare.kui

fun <T : Any> T.fluently(func: () -> Unit): T = this.apply { func() }