package fr.mastergime.meghasli.escapegame.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import fr.mastergime.meghasli.escapegame.R
import fr.mastergime.meghasli.escapegame.databinding.FragmentLogBinding
import fr.mastergime.meghasli.escapegame.databinding.FragmentSignUpBinding
import fr.mastergime.meghasli.escapegame.viewmodels.AuthViewModel
import kotlinx.android.synthetic.main.fragment_log.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import java.util.regex.Pattern
import kotlin.math.log


@AndroidEntryPoint
class SignUpFragment : Fragment() {




    private lateinit var binding : FragmentSignUpBinding
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
        binding = FragmentSignUpBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val authViewModel : AuthViewModel by viewModels ()

        binding.registerButton.setOnClickListener {

            if(test()){

                binding.progressBar2.visibility=View.VISIBLE
                authViewModel.signUp(binding.emailTextInput.editText?.text.toString(),binding.passwordTextInput.editText?.text.toString())
                    .observe(viewLifecycleOwner,
                    Observer {

                        if(it == "success"){
                            findNavController().navigate(R.id.action_signUpFragment_to_logFragment)
                            auth.signOut()
                            Toast.makeText(activity,it,Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(activity,it,Toast.LENGTH_SHORT).show()
                        }

                        binding.progressBar2.visibility=View.INVISIBLE

                    })


            }


        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object  : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                // Log.d("signup", "handleOnBackPressed: ")
                Toast.makeText(context, "labas", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_signUpFragment_to_logFragment)
            }
        })




    }

    fun test() : Boolean {
        val EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        if (binding.emailTextInput.editText?.text.toString().isNullOrEmpty()){
            binding.emailTextInput.error="enter email"
            return false
        }

        if(!(EMAIL_ADDRESS_PATTERN.matcher(binding.emailTextInput.editText?.text.toString()).matches())){
            binding.emailTextInput.error="enter a valid email"
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