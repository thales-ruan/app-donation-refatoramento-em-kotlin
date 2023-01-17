package com.example.firebasecomkotlin.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.firebasecomkotlin.firebase.FirebaseAuthLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

//class MainViewModel :ViewModel() {
//
//    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
//    val user: LiveData<FirebaseUser> = FirebaseAuthLiveData(FirebaseAuth.getInstance())
//    val isLoggedIn: LiveData<Boolean> = Transformations.map(user) { it != null }
//
//
//    fun login(email: String, password: String) {
//        auth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    Log.i("login", "login: ")
//                }
//            }
//    }
//
//    fun register(email: String, password: String) {
//        auth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (!task.isSuccessful) {
//                    // Falha na criação de usuário
//                }
//            }
//    }
//
//
//}