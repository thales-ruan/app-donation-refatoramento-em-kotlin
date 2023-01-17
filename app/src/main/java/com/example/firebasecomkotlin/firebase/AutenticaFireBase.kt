package com.example.firebasecomkotlin.firebase

import com.google.firebase.auth.FirebaseAuth

open class AutenticaFireBase {

   // private var  referenciaAutenticacao: FirebaseAuth? = null
   private lateinit var auth: FirebaseAuth

    fun getRef(): FirebaseAuth {
        return auth
    }

}