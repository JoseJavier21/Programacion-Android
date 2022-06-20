package com.estech.firebaseauthsample.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.estech.firebaseauthsample.databinding.ActivityLoginBinding
import com.estech.firebaseauthsample.dominio.Resource
import com.estech.firebaseauthsample.viewmodels.AuthViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


/**
 * Created by sergi on 08/06/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val model: AuthViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        model.getUser()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val email = binding.inputEmail.text.toString()
            val pass = binding.inputPassword.text.toString()
            model.createUser(email, pass)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.inputEmail.text.toString()
            val pass = binding.inputPassword.text.toString()
            model.signInUser(email, pass)
        }

        model.userRegistrationStatus.observe(this) {
            when (it) {
                is Resource.Loading -> binding.progressBar.isVisible = true

                is Resource.Success -> {
                    binding.progressBar.isVisible = false

                    it.data?.user?.let { fireUser ->
                        updateTextView(fireUser)
                        model.sendMail(fireUser)
                    }
                }

                is Resource.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        model.sendEmailResult.observe(this) {
            when (it) {
                is Resource.Loading -> binding.progressBar.isVisible = true

                is Resource.Success -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(this, it.data, Toast.LENGTH_SHORT).show()
                }

                is Resource.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        model.userSignUpStatus.observe(this) {
            when (it) {
                is Resource.Loading -> binding.progressBar.isVisible = true

                is Resource.Success -> {
                    binding.progressBar.isVisible = false

                    it.data?.user?.let { fireUser ->
                        updateTextView(fireUser)
                        Toast.makeText(this, "Logged", Toast.LENGTH_SHORT).show()
                        if (fireUser.isEmailVerified)
                            startMainActivity()
                        else {
                            fireUser.sendEmailVerification()
                        }
                    }

                }

                is Resource.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        model.firebaseUser.observe(this) {
            when (it) {
                is Resource.Success -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(this, "Usuario logueado", Toast.LENGTH_SHORT).show()
                    it.data?.let {  fireUser->
                        if (fireUser.isEmailVerified)
                            startMainActivity()
                        else
                            Toast.makeText(this, "Email no verificado.", Toast.LENGTH_SHORT).show()
                    }
                }

                is Resource.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> binding.progressBar.isVisible = true
            }
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun updateTextView(user: FirebaseUser) {
        binding.statusText.text =
            "User logged in\n Email: ${user.email}\n Verified: ${user.isEmailVerified}+\n UID: ${user.uid}"
    }

}