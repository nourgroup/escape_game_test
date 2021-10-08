package fr.mastergime.meghasli.escapegame

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import fr.mastergime.meghasli.escapegame.databinding.FragmentSplashBinding

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var _binding: FragmentSplashBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSplashBinding.bind(view)

        _binding.animationViewLoader.setAnimation("game_loader.json")
        _binding.animationViewLoader.playAnimation()
        _binding.animationViewLoader.loop(true)
      //  _binding.animationViewLoader.setscal

        val animation = AnimationUtils.loadAnimation(context,R.anim.zoom_in)
        _binding.titleEscapeGame.startAnimation(animation)


    }

}