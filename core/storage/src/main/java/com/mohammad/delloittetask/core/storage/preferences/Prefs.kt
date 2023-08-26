package com.mohammad.delloittetask.core.storage.preferences

interface Prefs {

    var getCurrentLanguage: String

    var accessToken: String?


    val isLoggedIn: Boolean
        get() = accessToken != null
}
