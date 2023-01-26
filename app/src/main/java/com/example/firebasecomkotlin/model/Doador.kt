package com.example.firebasecomkotlin.model

data class Doador(
    var idUsuario: String? = null,
    var nome: String? = null,
    var email: String? = null,
    var celular: String? = null,
    var senha: String? = null
) {
    fun salvar() {
        //TODO
    }
}
