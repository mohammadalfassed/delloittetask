package com.mohammad.delloittetask.features.auth.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mohammad.delloittetask.features.auth.presentation.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val viewModel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
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
        binding.buttonRegister.setOnClickListener {
            if (checkValidation()) {
                viewModel.createAccount(
                    binding.editTextFullName.text.toString(),
                    binding.editTextEmail.text.toString(),
                    binding.editTextPhoneNumber.text.toString(),
                    binding.editTextDateOfBirth.text.toString(),
                    this
                )
            }
        }

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun checkValidation(): Boolean {
        val emailValidationError =
            viewModel.getEmailErrorValidation(binding.editTextEmail.text.toString(), this)
        val passwordValidationError =
            viewModel.getPasswordErrorValidation(binding.editTextPassword.text.toString(), this)
        val phoneNumberValidationError =
            viewModel.getPhoneNumberErrorValidation(
                binding.editTextPhoneNumber.text.toString(),
                this
            )
        val dateOfBirthValidationError =
            viewModel.getDateOfBirthErrorValidation(
                binding.editTextDateOfBirth.text.toString(),
                this
            )
        val fullNameValidationError =
            viewModel.getFullNameErrorValidation(
                binding.editTextFullName.text.toString(),
                this
            )

        return fullNameValidation(fullNameValidationError)
                && emailValidation(emailValidationError)
                && phoneNumberValidation(phoneNumberValidationError)
                && dateOfBirthValidation(dateOfBirthValidationError)
                && passwordValidation(passwordValidationError)
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

    private fun fullNameValidation(fullNameValidationError: String): Boolean {
        return if (fullNameValidationError.isEmpty()) {
            binding.textInputLayoutFullName.error = null
            binding.textInputLayoutFullName.isErrorEnabled = false
            true
        } else {

            binding.textInputLayoutFullName.isErrorEnabled = true
            binding.textInputLayoutFullName.error = fullNameValidationError
            false
        }
    }

    private fun dateOfBirthValidation(dateOfBirthValidationError: String): Boolean {
        return if (dateOfBirthValidationError.isEmpty()) {
            binding.textInputLayoutDateOfBirth.error = null
            binding.textInputLayoutDateOfBirth.isErrorEnabled = false
            true
        } else {

            binding.textInputLayoutDateOfBirth.isErrorEnabled = true
            binding.textInputLayoutDateOfBirth.error = dateOfBirthValidationError
            false
        }
    }

    private fun phoneNumberValidation(phoneNumberValidationError: String): Boolean {
        return if (phoneNumberValidationError.isEmpty()) {
            binding.textInputLayoutPhoneNumber.error = null
            binding.textInputLayoutPhoneNumber.isErrorEnabled = false
            true
        } else {

            binding.textInputLayoutPhoneNumber.isErrorEnabled = true
            binding.textInputLayoutPhoneNumber.error = phoneNumberValidationError
            false
        }
    }

}