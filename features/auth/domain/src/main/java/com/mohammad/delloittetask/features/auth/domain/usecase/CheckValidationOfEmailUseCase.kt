package com.mohammad.delloittetask.features.auth.domain.usecase

import android.util.Patterns
import androidx.fragment.app.Fragment
import com.mohammad.delloittetask.features.auth.domain.R
import javax.inject.Inject

class CheckValidationOfEmailUseCase @Inject constructor() {

    operator fun invoke(email: String?, currentFragment: Fragment): String {
        return checkEmailValidation(email, currentFragment)
    }

    private fun checkEmailValidation(email: String?, currentFragment: Fragment): String {
        return when {

            email.isNullOrEmpty() -> {
                currentFragment.requireContext().getString(R.string.this_field_is_required)
            }

            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                currentFragment.requireContext().getString(R.string.invalid_email)
            }

            else -> {
                ""
            }
        }
    }

}
