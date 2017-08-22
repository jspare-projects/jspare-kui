package org.jspare.kui

inline fun <T : Any> T.fluently(func: () -> Unit): T = this.apply { func() }