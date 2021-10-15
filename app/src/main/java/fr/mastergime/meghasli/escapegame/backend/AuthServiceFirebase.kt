package fr.mastergime.meghasli.escapegame.backend


import android.accounts.NetworkErrorException
import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthEmailException
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import fr.mastergime.meghasli.escapegame.R
import fr.mastergime.meghasli.escapegame.model.User
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.net.ConnectException
import java.util.*
import java.util.logging.Handler
import javax.inject.Inject

class AuthServiceFirebase @Inject constructor() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    var message = ""
    lateinit var user : User

    suspend fun signup(email: String, password: String, pseudo: String): String {

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()
        try {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val id = auth.currentUser!!.uid
                         user = User(email = email, pseudo = pseudo, id = id)
                    } else {
                        Log.d("khaled", "createUserWithEmail:failure", task.exception)
                    }
                }.await()

        } catch (e: FirebaseNetworkException) {
            message = "Network Error, Check Your Connectivity"
        }
        return a(user)
    }


    fun login(email: String, password: String) {
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

    suspend fun a(user: User) : String{
        db.collection("Users")
            .document(user.id)
            .set(user)
            .addOnSuccessListener {
                Log.d("khaled", "DocumentSnapshot successfully written!")
                message = "success"
            }.addOnFailureListener { e ->
                Log.w("khaled", "Error writing document", e)
            }.await()
        return message
    }
}



