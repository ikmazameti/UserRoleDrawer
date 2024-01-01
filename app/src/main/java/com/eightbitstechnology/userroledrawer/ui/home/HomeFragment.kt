package com.eightbitstechnology.userroledrawer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.eightbitstechnology.userroledrawer.MainActivity
import com.eightbitstechnology.userroledrawer.R
import com.eightbitstechnology.userroledrawer.data.model.User
import com.eightbitstechnology.userroledrawer.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val userViewModel: HomeViewModel by viewModels()
    private var user: User? = null
    private val userArgs: HomeFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = FragmentHomeBinding.inflate(inflater, container, false).also { binding = it }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        user = userArgs.loggedInUser
        val welcome = getString(R.string.welcome) + user?.firstName
        binding.username.text = welcome

        updateUserRoleInActivity(user?.role ?: 0)
        Toast.makeText(
            requireContext(),
            " wow ${user?.role ?: 0} now : ${user?.role}",
            Toast.LENGTH_SHORT
        ).show()



        binding.logout.setOnClickListener {
            user = null
            findNavController().navigate(
                HomeFragmentDirections.actionHomeToLogin()
            )
        }


    }


    private fun updateUserRoleInActivity(userRole: Int) {
        if (activity is MainActivity) {
            (activity as MainActivity).updateMenuItemsBasedOnRole(userRole)
        }
    }

}
