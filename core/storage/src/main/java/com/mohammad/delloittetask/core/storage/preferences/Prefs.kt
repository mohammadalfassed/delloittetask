package com.mohammad.delloittetask.core.storage.preferences

interface Prefs {

    var getCurrentLanguage: String

    var accessToken: String?

    var fullName: String?

    var phoneNumber: String?

    var email: String?

    var dateOfBirth: String?

    val isLoggedIn: Boolean
        get() = !accessToken.isNullOrEmpty()
}
