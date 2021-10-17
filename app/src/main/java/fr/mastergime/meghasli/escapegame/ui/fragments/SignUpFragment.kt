package fr.mastergime.meghasli.escapegame.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.mastergime.meghasli.escapegame.R

@AndroidEntryPoint
class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object  : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Log.d("signup", "handleOnBackPressed: ")
                Toast.makeText(context, "labas", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_signUpFragment_to_logFragment)
            }
        })
    }

    override fun onResume() {
        super.onResume()
    }

}