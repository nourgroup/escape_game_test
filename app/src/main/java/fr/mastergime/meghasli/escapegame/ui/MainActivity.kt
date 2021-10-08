package fr.mastergime.meghasli.escapegame.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.mastergime.meghasli.escapegame.R
import fr.mastergime.meghasli.escapegame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}