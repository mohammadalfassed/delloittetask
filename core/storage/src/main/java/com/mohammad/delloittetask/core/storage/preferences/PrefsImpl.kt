package com.mohammad.delloittetask.core.storage.preferences

import android.content.SharedPreferences
import androidx.core.content.edit
import java.util.Locale

class PrefsImpl(
    private val sharedPreferences: SharedPreferences,
) : Prefs {

    override var getCurrentLanguage: String
        get() = sharedPreferences.getString(
            PrefKey.CURRENT_LANGUAGE.name, Locale.getDefault().language
        ) ?: ""
        set(value) {
            sharedPreferences.edit { putString(PrefKey.CURRENT_LANGUAGE.name, value) }
        }

    override var accessToken: String?
        get() = sharedPreferences.getString(PrefKey.ACCESS_TOKEN.name, null)
        set(value) {
            sharedPreferences.edit { putString(PrefKey.ACCESS_TOKEN.name, value) }
        }
    override var fullName: String?
        get() = sharedPreferences.getString(PrefKey.FULL_NAME.name, null)
        set(value) {
            sharedPreferences.edit { putString(PrefKey.FULL_NAME.name, value) }
        }
    override var phoneNumber: String?
        get() = sharedPreferences.getString(PrefKey.PHONE_NUMBER.name, null)
        set(value) {
            sharedPreferences.edit { putString(PrefKey.PHONE_NUMBER.name, value) }
        }
    override var email: String?
        get() = sharedPreferences.getString(PrefKey.EMAIL.name, null)
        set(value) {
            sharedPreferences.edit { putString(PrefKey.EMAIL.name, value) }
        }
    override var dateOfBirth: String?
        get() = sharedPreferences.getString(PrefKey.DATE_OF_BIRTH.name, null)
        set(value) {
            sharedPreferences.edit { putString(PrefKey.DATE_OF_BIRTH.name, value) }
        }

    override fun clearPrefs() {
        fullName = null
        phoneNumber = null
        email = null
        dateOfBirth = null
        accessToken = null
    }

    enum class PrefKey {
        ACCESS_TOKEN,

        CURRENT_LANGUAGE,

        FULL_NAME,

        EMAIL,

        PHONE_NUMBER,

        DATE_OF_BIRTH,
    }
}
