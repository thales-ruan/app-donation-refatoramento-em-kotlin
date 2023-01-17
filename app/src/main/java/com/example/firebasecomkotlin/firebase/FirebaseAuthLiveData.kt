package com.example.firebasecomkotlin.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FirebaseAuthLiveData  (private val firebaseAuth: FirebaseAuth) : LiveData<FirebaseUser>() {
    private val authStateListener = FirebaseAuth.AuthStateListener {
        value = it.currentUser
    }

    override fun onActive() {
        firebaseAuth.addAuthStateListener(authStateListener)
    }

    override fun onInactive() {
        firebaseAuth.removeAuthStateListener(authStateListener)
    }
}