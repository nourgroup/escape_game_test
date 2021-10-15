package fr.mastergime.meghasli.escapegame.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import fr.mastergime.meghasli.escapegame.R
import fr.mastergime.meghasli.escapegame.databinding.FragmentLogBinding
import fr.mastergime.meghasli.escapegame.databinding.FragmentSplashBinding
import fr.mastergime.meghasli.escapegame.viewmodels.AuthViewModel


@AndroidEntryPoint
class LogFragment : Fragment() {

    private lateinit var binding : FragmentLogBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val authViewModel : AuthViewModel by viewModels ()

        binding.loginButton.setOnClickListener {

            if (test()) {

                authViewModel.login(binding.emailTextInput.editText?.text.toString(),binding.passwordTextInput.editText?.text.toString())


                        if (auth.currentUser!=null){
                            findNavController().navigate(R.id.action_logFragment_to_menuFragment)
                            Toast.makeText(activity,"success",Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(activity,"failure",Toast.LENGTH_SHORT).show()
                        }



            }
        }

        binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_logFragment_to_signUpFragment)
        }

        (activity as AppCompatActivity
                ).supportActionBar?.show()
        enableBackTo()
        binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_logFragment_to_signUpFragment)
        }

    }

    private fun enableBackTo() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object  : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                //TODO QUITTER L'Application
            }
        })
    }
    fun test() : Boolean {
        if (binding.emailTextInput.editText?.text.toString().isNullOrEmpty()){
            binding.emailTextInput.error="enter email"
            return false
        }
        if (binding.passwordTextInput.editText?.text.toString().length< 6){
            binding.emailTextInput.error= null
            binding.passwordTextInput.error= "password should have at least 6 characters"
            return false
        }
        return true
    }


}