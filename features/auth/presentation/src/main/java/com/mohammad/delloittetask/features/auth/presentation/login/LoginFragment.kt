package com.mohammad.delloittetask.features.auth.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mohammad.delloittetask.features.auth.presentation.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
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
        binding.buttonLogin.setOnClickListener {
            if (checkValidation()) {
                viewModel.navigateToHomeScreen(this)
            }
        }

        binding.textViewCreateAccount.setOnClickListener {
            viewModel.navigateToRegister(this)
        }

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().finish()
        }
    }

    private fun checkValidation(): Boolean {
        val emailValidationError =
            viewModel.getEmailErrorValidation(binding.editTextEmail.text.toString(), this)
        val passwordValidationError =
            viewModel.getPasswordErrorValidation(binding.editTextPassword.text.toString(), this)

        return emailValidation(emailValidationError) && passwordValidation(passwordValidationError)
    }

    private fun passwordValidation(passwordValidationError: String): Boolean {
        return if (passwordValidationError.isEmpty()) {
            binding.textInputLayoutPassword.error = null
            binding.textInputLayoutPassword.isErrorEnabled = false
            true
        } else {
            binding.textInputLayoutPassword.isErrorEnabled = true
            binding.textInputLayoutPassword.error = passwordValidationError
            false
        }
    }

    private fun emailValidation(emailValidationError: String): Boolean {
        return if (emailValidationError.isEmpty()) {
            binding.textInputLayoutEmail.error = null
            binding.textInputLayoutEmail.isErrorEnabled = false
            true
        } else {

            binding.textInputLayoutEmail.isErrorEnabled = true
            binding.textInputLayoutEmail.error = emailValidationError
            false
        }
    }

}