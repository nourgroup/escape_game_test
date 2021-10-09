package fr.mastergime.meghasli.escapegame.ui.fragments

import android.os.Bundle
import android.util.Log

import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.mastergime.meghasli.escapegame.R
import fr.mastergime.meghasli.escapegame.databinding.FragmentSplashBinding
import kotlinx.coroutines.*

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var _binding: FragmentSplashBinding
    private val activityScope = CoroutineScope(Dispatchers.Main)
    private val activityScope2 = CoroutineScope(Dispatchers.Main)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // _binding = FragmentSplashBinding.bind(view)


        Log.d("nav", "onViewCreated: ${findNavController().currentDestination}")
        lunchLogoAnimation()

    }

    private fun lunchLoadingAnimation() {
        activityScope2.launch {
            _binding.animationViewLoading.setAnimation("loading.json")
            _binding.animationViewLoading.visibility = View.VISIBLE
            _binding.animationViewLoading.playAnimation()
            _binding.animationViewLoading.loop(true)
            delay(4000)
            activityScope2.cancel()
            Toast.makeText(context, "Another Fragment", Toast.LENGTH_SHORT).show()
            _binding.animationViewLoading.visibility = View.GONE
            findNavController().navigate(R.id.action_signUpFragment_to_logFragment)
        }
    }

    private fun lunchLogoAnimation() {
        activityScope.launch {
            val animation = AnimationUtils.loadAnimation(context, R.anim.zoom_in)
            val animationTitle = AnimationUtils.loadAnimation(context, R.anim.zoom_in)

            _binding.animationViewLoader.startAnimation(animation)
            _binding.titleEscapeGame.startAnimation(animationTitle)

            delay(3500)
            activityScope.cancel()

            eraseLogoAnimation()
            lunchLoadingAnimation()
        }
    }

    private fun eraseLogoAnimation() {
        _binding.animationViewLoader.clearAnimation()
        _binding.titleEscapeGame.clearAnimation()

        _binding.titleEscapeGame.visibility = View.GONE
        _binding.animationViewLoader.visibility = View.GONE
    }

}