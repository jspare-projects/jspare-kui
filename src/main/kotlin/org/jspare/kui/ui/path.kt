package org.jspare.kui.ui

/**
 * Use hook annotation with Widget to indicate that one function will be hooked by template engine.
 * Note: hook usage depends of Toolkit implementation registered on container.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
annotation class path(val value: String)