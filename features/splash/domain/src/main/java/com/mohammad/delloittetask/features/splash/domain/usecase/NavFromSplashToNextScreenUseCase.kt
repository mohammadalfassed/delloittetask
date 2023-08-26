package com.mohammad.delloittetask.features.splash.domain.usecase

import android.app.Activity
import android.content.Intent
import com.mohammad.delloittetask.core.navigation.AddressableActivity
import com.mohammad.delloittetask.core.navigation.intentTo
import javax.inject.Inject

class NavFromSplashToNextScreenUseCase @Inject constructor() {

    operator fun invoke(
        currentActivity: Activity,
        addressableActivity: AddressableActivity,
    ) {
        val mainIntent = currentActivity.intentTo(
            addressableActivity
        )

        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        currentActivity.finish()
        currentActivity.startActivity(mainIntent)
    }
}

