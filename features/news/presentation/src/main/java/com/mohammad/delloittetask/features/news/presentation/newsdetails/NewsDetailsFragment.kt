package com.mohammad.delloittetask.features.news.presentation.newsdetails

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mohammad.delloittetask.features.news.domain.models.NewsListModel
import com.mohammad.delloittetask.features.news.presentation.databinding.FragmentNewsDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailsFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailsBinding

    private val newsListModel: NewsListModel? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(NEWS_DETAILS, NewsListModel::class.java)
        } else {
            arguments?.getParcelable(NEWS_DETAILS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initData()
        initClicks()
    }

    private fun initData() {
        binding.model = newsListModel
        binding.executePendingBindings()
    }

    private fun initClicks() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    companion object {
        private const val NEWS_DETAILS = "news_details"
    }
}