package org.jspare.kui.ui.annotations


/**
 * Use hook annotation with Widget to indicate that one function will be hooked by template engine.
 * Note: hook usage depends of Toolkit implementation registered on container.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.FILE)
annotation class hook