package com.estech.firebaseauthsample.viewmodels

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estech.firebaseauthsample.dominio.MyRepository
import com.estech.firebaseauthsample.dominio.Resource
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * Created by sergi on 08/06/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

class AuthViewModel : ViewModel() {
    private val myRepository = MyRepository()

    val userRegistrationStatus = MutableLiveData<Resource<AuthResult>>()
    val userSignUpStatus = MutableLiveData<Resource<AuthResult>>()
    val firebaseUser = MutableLiveData<Resource<FirebaseUser>>()
    val sendEmailResult = MutableLiveData<Resource<String>>()

    fun createUser(userEmailAddress: String, userLoginPassword: String) {
        val error =
            if (userEmailAddress.isEmpty() || userLoginPassword.isEmpty()) {
                "Falta información"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(userEmailAddress).matches()) {
                "No es un email válido"
            } else null

        error?.let {
            userRegistrationStatus.postValue(Resource.Error(it))
            return
        }
        userRegistrationStatus.postValue(Resource.Loading())

        viewModelScope.launch(Dispatchers.Main) {
            val registerResult = myRepository.createUser(userEmailAddress, userLoginPassword)
            userRegistrationStatus.postValue(registerResult)
        }
    }

    fun signInUser(userEmailAddress: String, userLoginPassword: String) {
        if (userEmailAddress.isEmpty() || userLoginPassword.isEmpty()) {
            userSignUpStatus.postValue(Resource.Error("Falta información"))
        } else {
            userSignUpStatus.postValue(Resource.Loading())
            viewModelScope.launch(Dispatchers.Main) {
                val loginResult = myRepository.loginUser(userEmailAddress, userLoginPassword)
                userSignUpStatus.postValue(loginResult)
            }
        }
    }

    fun getUser() {

        FirebaseAuth.getInstance().currentUser?.reload()?.addOnCompleteListener {

        }

        userRegistrationStatus.postValue(Resource.Loading())
        viewModelScope.launch(Dispatchers.Main) {
            firebaseUser.postValue(myRepository.getUser())
        }
    }

    fun sendMail(user: FirebaseUser) {
        if (user.isEmailVerified) {
            sendEmailResult.postValue(Resource.Error("El email ya está verificado"))
        } else {
            userRegistrationStatus.postValue(Resource.Loading())
            viewModelScope.launch {
                sendEmailResult.postValue(myRepository.sendMail(user))
            }
        }
    }

}