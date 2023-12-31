package com.mohammad.delloittetask.features.splash.presentation

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.mohammad.delloittetask.core.navigation.Activities
import com.mohammad.delloittetask.features.splash.domain.usecase.NavFromSplashToNextScreenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navFromSplashToNextScreenUseCase: NavFromSplashToNextScreenUseCase,
) : ViewModel() {

    fun navigateToNextScreen(currentActivity: Activity) {
        navFromSplashToNextScreenUseCase(
            currentActivity,
            Activities.Main,
        )
    }
}
