package fr.mastergime.meghasli.escapegame.ui.fragments

import android.hardware.input.InputManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.mastergime.meghasli.escapegame.R
import fr.mastergime.meghasli.escapegame.databinding.FragmentLogBinding
import fr.mastergime.meghasli.escapegame.databinding.FragmentSplashBinding


@AndroidEntryPoint
class LogFragment : Fragment(R.layout.fragment_log) {

    private lateinit var _binding:  FragmentLogBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLogBinding.bind(view)
        (activity as AppCompatActivity).supportActionBar?.show()

        enableBackTo()

        _binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_logFragment_to_signUpFragment)
        }

    }

    private fun enableBackTo() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object  : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {

            }
        })
    }

}