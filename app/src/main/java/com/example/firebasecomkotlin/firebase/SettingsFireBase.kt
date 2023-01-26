package com.example.firebasecomkotlin.firebase

import com.google.firebase.auth.FirebaseAuth

open class SettingsFireBase {

    private lateinit var auth: FirebaseAuth

    fun getIdUser(): String {
        auth = FirebaseAuth.getInstance()

        return auth.currentUser!!.uid

    }

}