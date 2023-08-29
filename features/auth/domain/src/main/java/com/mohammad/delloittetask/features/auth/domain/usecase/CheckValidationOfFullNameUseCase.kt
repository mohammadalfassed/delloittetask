package com.mohammad.delloittetask.features.auth.domain.usecase

import androidx.fragment.app.Fragment
import com.mohammad.delloittetask.features.auth.domain.R
import javax.inject.Inject

class CheckValidationOfFullNameUseCase @Inject constructor() {

    operator fun invoke(fullName: String?, currentFragment: Fragment): String {
        return checkFullNameValidation(fullName, currentFragment)
    }

    private fun checkFullNameValidation(fullName: String?, currentFragment: Fragment): String {
        return when {

            fullName.isNullOrEmpty() -> {
                currentFragment.requireContext().getString(R.string.this_field_is_required)
            }

            else -> {
                ""
            }
        }
    }

}
