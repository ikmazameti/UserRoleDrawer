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
import com.eightbitstechnology.userroledrawer.databinding.FragmentLoginBinding
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = FragmentLoginBinding.inflate(inflater, container, false).also { binding = it }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = binding.username
        val password = binding.password
        val loginButton = binding.login
        val loadingProgressBar = binding.loading

        loginButton.setOnClickListener {
            lifecycleScope.launch {
                val user = loginViewModel.login(username.text.toString(), password.text.toString())
                if (user != null) {
                    // Login successful, navigate to the main screen
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginToHome(loggedInUser = user)
                    )
                } else {
                    // Display an error message
                    Toast.makeText(requireContext(), "$user", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.register.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginToRegister()
            )
        }

    }

}