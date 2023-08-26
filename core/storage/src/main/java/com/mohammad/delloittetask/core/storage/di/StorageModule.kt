package com.mohammad.delloittetask.core.storage.di

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.mohammad.delloittetask.core.storage.preferences.Prefs
import com.mohammad.delloittetask.core.storage.preferences.PrefsImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }


    @Provides
    @Singleton
    fun providePrefs(sharedPreferences: SharedPreferences): Prefs {
        return PrefsImpl(sharedPreferences)
    }
}
