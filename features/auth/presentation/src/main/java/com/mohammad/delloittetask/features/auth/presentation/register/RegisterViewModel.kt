package com.mohammad.delloittetask.features.auth.presentation.register

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.mohammad.delloittetask.features.auth.domain.usecase.CheckValidationOfEmailUseCase
import com.mohammad.delloittetask.features.auth.domain.usecase.CheckValidationOfPasswordUseCase
import com.mohammad.delloittetask.features.auth.domain.usecase.NavToHomeUseCase
import com.mohammad.delloittetask.features.auth.presentation.login.LoginFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val checkValidationOfEmailUseCase: CheckValidationOfEmailUseCase,
    private val checkValidationOfPasswordUseCase: CheckValidationOfPasswordUseCase,
    private val navToHomeUseCase: NavToHomeUseCase,
) : ViewModel(), LifecycleObserver {


    fun getEmailErrorValidation(email: String?, currentFragment: Fragment): String {
        return checkValidationOfEmailUseCase(email = email, currentFragment)
    }

    fun getPasswordErrorValidation(password: String?, currentFragment: Fragment): String {
        return checkValidationOfPasswordUseCase(password = password, currentFragment)
    }

    fun navigateToHomeScreen(
        currentFragment: LoginFragment,
    ) {
        navToHomeUseCase(currentFragment = currentFragment)
    }

}
