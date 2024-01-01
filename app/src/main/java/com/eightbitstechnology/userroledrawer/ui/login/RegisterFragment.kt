package com.eightbitstechnology.userroledrawer.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.eightbitstechnology.userroledrawer.data.model.User
import com.eightbitstechnology.userroledrawer.databinding.FragmentRegisterBinding
import kotlinx.coroutines.launch

class RegisterFragment : Fragment() {
    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = FragmentRegisterBinding.inflate(inflater, container, false).also { binding = it }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = binding.username
        val password = binding.password
        val firstName = binding.firstName
        val otherName = binding.otherName
        val loadingProgressBar = binding.loading



        binding.btnSignUp.setOnClickListener {
            lifecycleScope.launch {
                val selectedRole: String = binding.spinnerRole.selectedItem.toString()

                val newUser = User(
                    username = username.text.toString(),
                    password = password.text.toString(),
                    role = mapRoleStringToInt(selectedRole),
                    firstName = firstName.text.toString(),
                    otherName = otherName.text.toString()
                )

                val user = loginViewModel.register(newUser)
                if (user != null) {
                    // Login successful, navigate to the main screen
                    findNavController().navigate(RegisterFragmentDirections.actionRegisterToLogin())
                } else {
                    // Display an error message
                    Toast.makeText(requireContext(), "$user", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }

    private fun mapRoleStringToInt(role: String): Int {
        return when (role) {
            "User" -> 0
            "Admin" -> 1
            else -> 0 // Default to User role
        }
    }
}