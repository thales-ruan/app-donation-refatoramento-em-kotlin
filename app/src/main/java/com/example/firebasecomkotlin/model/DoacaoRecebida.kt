package com.example.firebasecomkotlin.model

data class DoacaoRecebida(
    var idUsuario: String? = null,
    var idEntidade: String? = null,
    var idPedido: String? = null,
    var nome: String? = null,
    var celular: String? = null,
    var itens: List<ItemPedido>? = null,
    var observacoes: String? = null,
    var status: String = "pendente"
) {

}
