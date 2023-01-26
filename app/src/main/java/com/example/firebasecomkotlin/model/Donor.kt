package com.example.firebasecomkotlin.model

data class Donor(
    var idUser: String? = null,
    var name: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var password: String? = null
) {
    fun save() {
        //TODO
    }
}
