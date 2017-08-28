package org.jspare.kui.ui.annotations


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
annotation class scripts(val value: Array<String>)