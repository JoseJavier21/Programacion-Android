package com.estech.firebaseauthsample.dominio

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


/**
 * Created by sergi on 08/06/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

class MyRepository {


    suspend fun createUser(userEmail: String, userPassword: String): Resource<AuthResult> {
        return withContext(Dispatchers.IO) {
            try {
                val result =
                    FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(userEmail, userPassword).await()
                Resource.Success(result)
            } catch (e: Exception) {
                Resource.Error(e.message)
            }
        }
    }

    suspend fun loginUser(email: String, password: String): Resource<AuthResult> {
        return withContext(Dispatchers.IO) {
            try {
                val loginResultesult =
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).await()
                Resource.Success(loginResultesult)

            } catch (e: Exception) {
                Resource.Error(e.message)
            }
        }
    }

    suspend fun getUser(): Resource<FirebaseUser> {
        return withContext(Dispatchers.IO) {
            try {
                FirebaseAuth.getInstance().currentUser?.reload()
                val user = FirebaseAuth.getInstance().currentUser
                if (user != null) {
                    Resource.Success(user)
                } else {
                    Resource.Error("Usuario no logueado")
                }
            } catch (e: Exception) {
                Resource.Error(e.message)
            }
        }
    }

    suspend fun sendMail(user: FirebaseUser): Resource<String> {
        return withContext(Dispatchers.IO) {
            try {
                user.sendEmailVerification().await()
                Resource.Success("Email enviado correctamente")
            } catch (e: Exception) {
                Resource.Error(e.message)
            }
        }
    }
}