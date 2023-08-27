package com.mohammad.delloittetask.features.news.presentation.newsdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mohammad.delloittetask.features.news.presentation.databinding.FragmentNewsDetailsBinding


class NewsDetailsFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailsBinding

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
        initClicks()
    }

    private fun initClicks() {

    }

}