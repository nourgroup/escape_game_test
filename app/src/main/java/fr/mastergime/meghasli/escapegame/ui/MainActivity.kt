package fr.mastergime.meghasli.escapegame.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import fr.mastergime.meghasli.escapegame.databinding.ActivityMainBinding
import fr.mastergime.meghasli.escapegame.ui.fragments.SplashFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val splashFragment = SplashFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show()

//        Navigation.findNavController(this,R.id.fragment).currentDestination

//        _binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(_binding.root)
//
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragment, splashFragment)
//            commit()
//        }

    }
}