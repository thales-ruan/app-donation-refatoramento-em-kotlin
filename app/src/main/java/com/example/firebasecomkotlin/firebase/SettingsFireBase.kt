package com.example.firebasecomkotlin.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

open class SettingsFireBase {

    private lateinit var auth: FirebaseAuth
    private lateinit var referenceFirebase: DatabaseReference

    fun getIdUser(): String {
        auth = FirebaseAuth.getInstance()

        return auth.currentUser!!.uid

    }

//    fun getRefDataBase():DatabaseReference{
//
//        if (referenceFirebase == null){
//            referenceFirebase = FirebaseDatabase.getInstance().getReference()
//        }
//        return  referenceFirebase
//    }

}