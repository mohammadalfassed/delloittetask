package com.mohammad.delloittetask.features.more.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mohammad.delloittetask.core.component.annotations.ShowBottomBarNavController
import com.mohammad.delloittetask.core.storage.preferences.Prefs
import com.mohammad.delloittetask.features.more.presentation.databinding.FragmentMoreBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
@ShowBottomBarNavController
class MoreFragment : Fragment() {

    @Inject
    lateinit var prefs: Prefs
    private lateinit var binding: FragmentMoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoreBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initClicks()
        initData()
    }

    private fun initData() {
        binding.fullName = prefs.fullName
        binding.email = prefs.email
        binding.dateOfBirth = prefs.dateOfBirth
        binding.phoneNumber = prefs.phoneNumber
        binding.executePendingBindings()
    }

    private fun initClicks() {
        binding.buttonLogout.setOnClickListener {
            logout()
        }

        binding.textviewAr.setOnClickListener {
            handleArLanguage()
        }
        binding.textviewEn.setOnClickListener {
            handleEnLanguage()
        }
    }

    private fun handleEnLanguage() {
        prefs.getCurrentLanguage = "en"
        recreateUi()
    }

    private fun handleArLanguage() {
        prefs.getCurrentLanguage = "ar"
        recreateUi()
    }

    private fun recreateUi() {
        startActivity(Intent.makeRestartActivityTask(requireActivity().componentName))
        requireActivity().overridePendingTransition(
            android.R.anim.fade_in, android.R.anim.fade_out
        )
    }

    private fun logout() {
        clearPreferences()
    }

    private fun clearPreferences() {
        prefs.clearPrefs()
        findNavController().navigate(com.mohammad.delloittetask.core.navigation.R.id.navigation_fragment_login)
    }
}