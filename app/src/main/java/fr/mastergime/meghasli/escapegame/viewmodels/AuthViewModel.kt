package fr.mastergime.meghasli.escapegame.viewmodels

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mastergime.meghasli.escapegame.repositories.GlobalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor (val globalRepository: GlobalRepository) : ViewModel() {


    var messageSignUp : MutableLiveData<String> = MutableLiveData()


        fun signUp ( email : String , password: String) : MutableLiveData<String> {

            CoroutineScope(Dispatchers.IO).launch {
                messageSignUp.postValue(globalRepository.signUp(email,password))
            }
            return messageSignUp
        }

    fun login ( email : String , password: String)  {
        globalRepository.login(email,password)
    }


}


