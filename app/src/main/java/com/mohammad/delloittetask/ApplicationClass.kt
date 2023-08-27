package com.mohammad.delloittetask

import android.app.Application
import android.content.Context
import com.mohammad.delloittetask.core.component.utils.Languages
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationClass : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(Languages.setLocale(base))
        //MultiDex.install(this)
    }

}
