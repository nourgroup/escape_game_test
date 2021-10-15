package fr.mastergime.meghasli.escapegame.repositories

import android.content.Context
import androidx.lifecycle.MutableLiveData
import fr.mastergime.meghasli.escapegame.backend.AuthServiceFirebase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GlobalRepository @Inject constructor (val authServiceFirebase : AuthServiceFirebase){



   suspend  fun signUp (email : String , password : String , pseudo :String) : String {
        return authServiceFirebase.signup(email, password,pseudo)
    }

     fun login (email : String , password : String)  {
         authServiceFirebase.login(email, password)
    }






}