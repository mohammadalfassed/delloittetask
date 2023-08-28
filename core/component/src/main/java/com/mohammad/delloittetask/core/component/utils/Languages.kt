package com.mohammad.delloittetask.core.component.utils

import android.content.Context
import android.content.res.Configuration
import androidx.preference.PreferenceManager
import com.mohammad.delloittetask.core.storage.preferences.PrefsImpl
import java.util.Locale

object Languages {

    fun setLocale(context: Context): Context? {
        return updateResources(context, getLanguage(context))
    }

    private fun getLanguage(c: Context): String? {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c)
        return sharedPreferences.getString(
            PrefsImpl.PrefKey.CURRENT_LANGUAGE.name, Locale.getDefault().language
        )
    }

    private fun updateResources(context: Context?, language: String?): Context? {
        val result: Context?
        val locale = Locale(language ?: Locale.getDefault().language)
        Locale.setDefault(locale)

        val res = context?.resources
        val config = Configuration(res?.configuration)
        config.setLocale(locale)
        result = context?.createConfigurationContext(config)
        return result
    }
}
