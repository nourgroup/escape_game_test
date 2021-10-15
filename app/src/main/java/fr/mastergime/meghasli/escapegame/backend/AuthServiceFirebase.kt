package fr.mastergime.meghasli.escapegame.backend


import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import fr.mastergime.meghasli.escapegame.R
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.util.*
import java.util.logging.Handler
import javax.inject.Inject

class AuthServiceFirebase @Inject constructor () {

    private lateinit var auth: FirebaseAuth




    suspend fun signup ( email: String ,  password : String ) : String {


        var message = "hjuhj"
        auth = FirebaseAuth.getInstance()

        auth.createUserWithEmailAndPassword(email,password)
            .addOnSuccessListener {

                message = "success"
            }
            .addOnFailureListener {
                message ="fail"
            }.await()

        //delay(1000)
        return message
    }


    fun login ( email: String ,  password : String ) {

        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(Activity()) {
                if (it.isSuccessful) {

                    // Sign in success, update UI with the signed-in user's information
                    Log.d("xxx", "signInWithEmail:success")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.d("xxx", "signInWithEmail:failure")
                }
            }



    }


}



