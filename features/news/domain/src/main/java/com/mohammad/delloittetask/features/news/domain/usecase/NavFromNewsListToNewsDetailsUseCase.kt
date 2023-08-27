package com.mohammad.delloittetask.features.news.domain.usecase

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mohammad.delloittetask.core.navigation.R
import com.mohammad.delloittetask.features.news.domain.models.NewsListModel
import javax.inject.Inject

class NavFromNewsListToNewsDetailsUseCase @Inject constructor() {

    operator fun invoke(
        currentFragment: Fragment,
        newsListModel: NewsListModel?,
    ) {
        currentFragment.findNavController().navigate(
            R.id.navigation_fragment_news_details, bundleOf(
                NEWS_DETAILS to newsListModel
            )
        )
    }

    companion object {
        private const val NEWS_DETAILS = "news_details"
    }
}

