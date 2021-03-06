package fr.mastergime.meghasli.escapegame.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.AndroidEntryPoint
import fr.mastergime.meghasli.escapegame.R
import fr.mastergime.meghasli.escapegame.databinding.FragmentLogBinding
import fr.mastergime.meghasli.escapegame.databinding.FragmentMenuBinding


@AndroidEntryPoint
class MenuFragment : Fragment(R.layout.fragment_menu) {
    private lateinit var auth: FirebaseAuth

    private lateinit var binding : FragmentMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.txtTest.text= auth.currentUser!!.email
        binding.imgLogout.setOnClickListener {
            auth.signOut()
            if (auth.currentUser!=null){
                Toast.makeText(activity,"Error Logout",Toast.LENGTH_SHORT).show()
            }else{
                findNavController().navigate(R.id.action_menuFragment_to_logFragment)
                Toast.makeText(activity,"Logout",Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnCreerPartie.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_creatSessionFragment)
        }
        binding.btnRejoindre.setOnClickListener {

            findNavController().navigate(R.id.action_menuFragment_to_joinSessionFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater)
        return binding.root
    }


}