package com.example.firebasecomkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasecomkotlin.databinding.ActivityCriarContaBinding
import com.example.firebasecomkotlin.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CriarContaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCriarContaBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_conta)

        binding = ActivityCriarContaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.buttonCriar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            val radioGroup = binding.rdGrupUsuarioEmpresa
            val radioButtonEmpresa = binding.rdEmpresa
            val radioButtonUsuario = binding.rdUsuario
            val selectedId = radioGroup.checkedRadioButtonId

            if (!email.isEmpty()) {
                if (!senha.isEmpty()) {

                    auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            Toast.makeText(
                                applicationContext,
                                "Cadastro realizado com sucesso",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Erro na criação de conta",
                                Toast.LENGTH_SHORT
                            )
                        }
                    }
                }
            }

            val usuario = User()
            if (selectedId == radioButtonUsuario.id) {
                usuario.type = "usuario"
                startActivity(Intent(this, InicialDoadorActivity::class.java))
            } else if (selectedId == radioButtonEmpresa.id) {
                usuario.type = "empresa"
                startActivity(Intent(this, InicialEntidadeActivity::class.java))
            }

            db = FirebaseDatabase.getInstance().reference
            val nomeFire = db.child("Userss").child(getIdUsuario())
            nomeFire.setValue(usuario)

        }
    }

    fun getIdUsuario(): String {
        return auth.currentUser!!.uid
    }

}
