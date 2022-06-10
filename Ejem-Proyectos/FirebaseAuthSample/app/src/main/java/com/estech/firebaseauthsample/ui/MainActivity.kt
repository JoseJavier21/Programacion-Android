package com.estech.firebaseauthsample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.estech.firebaseauthsample.R
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    val mFirebaseAuth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}