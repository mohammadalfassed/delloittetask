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

    enum class PrefKey {
        ACCESS_TOKEN,

        CURRENT_LANGUAGE,
    }
}
