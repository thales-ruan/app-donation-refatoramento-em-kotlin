package com.example.firebasecomkotlin.firebase

import com.google.firebase.auth.FirebaseAuth

open class ConfigFireBase {

    private lateinit var auth: FirebaseAuth

    fun getIdUsuario(): String {
        auth = FirebaseAuth.getInstance()

        return auth.currentUser!!.uid

    }

}