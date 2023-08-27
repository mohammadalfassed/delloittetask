package com.mohammad.delloittetask.features.news.presentation.newslist

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.mohammad.delloittetask.core.navigation.R
import com.mohammad.delloittetask.features.news.domain.models.NewsListModel
import com.mohammad.delloittetask.features.news.presentation.databinding.FragmentNewsListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsListFragment : Fragment() {

    private lateinit var binding: FragmentNewsListBinding
    private val viewModel by viewModels<NewsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsListBinding.inflate(layoutInflater, container, false)
        initSearchListFieldsBottomSheetResult()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initObservable()
        initShoot()
        initClicks()
    }

    private fun initSearchListFieldsBottomSheetResult() {
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Int?>(
            FILTER_RESULT
        )?.observe(viewLifecycleOwner) { filterResult ->
            if (filterResult != null) {
                initShoot(period = filterResult)
            }
        }
    }

    private fun initClicks() {
        binding.textviewFilter.setOnClickListener {
            findNavController().navigate(R.id.navigation_bottom_sheet_filter)
        }
    }

    private fun initShoot(period: Int = 1) {
        viewModel.getPopularNews(period)
    }

    private fun initObservable() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.successGetNewsSharedFlow.collect(::handleGetNewsSuccess)
            }
        }

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.progressSharedFlow.collect(::handleProgress)
            }
        }
    }

    private fun handleProgress(isShowing: Boolean) {
        binding.linearProgress.isVisible = isShowing
    }

    private fun handleGetNewsSuccess(newsList: List<NewsListModel>?) {
        if (!newsList.isNullOrEmpty()) {
            initAdapter(newsList)
        }
    }


    private fun initAdapter(newsList: List<NewsListModel>?) {
        val filterListAdapter = NewsListAdapter(newsList ?: listOf())
        binding.recyclerViewNewsList.setHasFixedSize(true)
        binding.recyclerViewNewsList.adapter = filterListAdapter
        initClickItemAdapter(filterListAdapter)
        initEditTextSearch(filterListAdapter)
    }

    private fun initClickItemAdapter(filterListAdapter: NewsListAdapter) {
        filterListAdapter.onNewsItemClick = {
//           findNavController().navigate(R.id.navigation_news_details_fragment, bundleOf(
//               NEWS_DETAILS to ""
//           ))
        }
    }

    private fun initEditTextSearch(filterListAdapter: NewsListAdapter) {
        binding.editTextSearchList.doOnTextChanged { text, start, before, count ->
            binding.imageviewClearSearchText.isVisible = text.toString().isNotEmpty()
            filterListAdapter.filter.filter(text.toString())
            Handler(Looper.getMainLooper()).postDelayed({
                binding.textviewNoResult.isVisible = filterListAdapter.getSizeList() <= 0
            }, 10)
        }
    }

    companion object {
        private const val NEWS_DETAILS = "news_details"
        private const val FILTER_RESULT = "filter_result"
    }
}