package fr.mastergime.meghasli.escapegame.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import fr.mastergime.meghasli.escapegame.R
import fr.mastergime.meghasli.escapegame.databinding.ActivityMainBinding
import fr.mastergime.meghasli.escapegame.ui.fragments.SplashFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val splashFragment = SplashFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.splash_fragment, splashFragment)
            commit()
        }

    }
}