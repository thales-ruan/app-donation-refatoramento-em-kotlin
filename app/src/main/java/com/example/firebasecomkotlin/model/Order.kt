package com.example.firebasecomkotlin.model

data class Order(
    var idUser: String? = null,
    var idEntity: String? = null,
    var idOrder: String? = null,
    var name: String? = null,
    var phone: String? = null,
    var items: List<OrderedItem>? = null,
    var comments: String? = null,
    var status: String = "pendente"
) {
    fun save() {

        //TODO

    }
}
