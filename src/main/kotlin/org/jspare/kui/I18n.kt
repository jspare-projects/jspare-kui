package org.jspare.kui

import javax.annotation.Resource
import java.io.File
import java.util.Locale
import java.util.ResourceBundle

@Resource
class I18n {

    var locale: Locale? = null

    operator fun get(key: String): String =get(DEFAULT_BUNDLE, key)

    operator fun get(bundle: String, key: String): String {
        val labels = ResourceBundle.getBundle(DEFAULT_PATH + bundle, locale!!)
        return labels.getString(key)
    }

    companion object {
        private val DEFAULT_PATH = File.separator + "i18n" + File.separator
        private val DEFAULT_BUNDLE = "labels"
    }
}