package com.mohammad.delloittetask.features.news.presentation.newslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mohammad.delloittetask.features.news.presentation.databinding.BottomSheetFilterBinding


class FilterBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetFilterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetFilterBinding.inflate(layoutInflater, container, false)
        isCancelable = true

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
        binding.textviewLastDay.setOnClickListener {
            findNavController().previousBackStackEntry?.savedStateHandle?.set(
                FILTER_RESULT, NUM_1
            )
            dismiss()
        }
        binding.textviewLast7Days.setOnClickListener {
            findNavController().previousBackStackEntry?.savedStateHandle?.set(
                FILTER_RESULT, NUM_7
            )
            dismiss()
        }
        binding.textviewLast30Days.setOnClickListener {
            findNavController().previousBackStackEntry?.savedStateHandle?.set(
                FILTER_RESULT, NUM_30
            )
            dismiss()
        }
    }

    companion object {
        private const val FILTER_RESULT = "filter_result"
        private const val NUM_1 = 1
        private const val NUM_7 = 7
        private const val NUM_30 = 30
    }
}