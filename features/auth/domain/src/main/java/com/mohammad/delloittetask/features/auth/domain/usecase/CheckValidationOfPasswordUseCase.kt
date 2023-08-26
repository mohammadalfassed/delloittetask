package com.mohammad.delloittetask.features.auth.domain.usecase

import androidx.fragment.app.Fragment
import com.mohammad.delloittetask.features.auth.domain.R
import javax.inject.Inject

class CheckValidationOfPasswordUseCase @Inject constructor() {

    operator fun invoke(password: String?, currentFragment: Fragment): String {
        return when {
            password.isNullOrEmpty() -> {
                currentFragment.requireContext().getString(R.string.this_field_is_required)
            }

            password.length < 4 -> {
                currentFragment.requireContext().getString(R.string.this_field_is_required)
            }

            else -> {
                ""
            }
        }
    }
}
