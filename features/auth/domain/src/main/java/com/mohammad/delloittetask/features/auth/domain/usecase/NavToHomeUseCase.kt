package com.mohammad.delloittetask.features.auth.domain.usecase

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mohammad.delloittetask.core.navigation.R
import javax.inject.Inject

class NavToHomeUseCase @Inject constructor() {

    operator fun invoke(currentFragment: Fragment) {
        currentFragment.findNavController().navigate(R.id.navigation_fragment_news_list)
    }
}
