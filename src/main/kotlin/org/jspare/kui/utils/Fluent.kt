package org.jspare.kui.utils

inline fun <T : Any> T.fluently(func: () -> Unit): T = this.apply { func() }