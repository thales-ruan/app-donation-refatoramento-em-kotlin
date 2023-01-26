package com.example.firebasecomkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasecomkotlin.databinding.ActivityCriarContaBinding
import com.example.firebasecomkotlin.firebase.SettingsFireBase
import com.example.firebasecomkotlin.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCriarContaBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseReference
    private val firebase = SettingsFireBase()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crieate_account)

        binding = ActivityCriarContaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.buttonCriar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val password = binding.editSenha.text.toString()

            val radioGroup = binding.rdGrupUsuarioEmpresa
            val radioButtonEntity = binding.rdEmpresa
            val radioButtonUser = binding.rdUsuario
            val selectedId = radioGroup.checkedRadioButtonId

            if (!email.isEmpty()) {
                if (!password.isEmpty()) {

                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
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

            val user = User()
            if (selectedId == radioButtonUser.id) {
                user.type = "usuario"
                startActivity(Intent(this, InitialDonorActivity::class.java))
            } else if (selectedId == radioButtonEntity.id) {
                user.type = "empresa"
                startActivity(Intent(this, InitialEntityActivity::class.java))
            }

            db = FirebaseDatabase.getInstance().reference
            val realDataBase = db.child("Userss").child(firebase.getIdUser())
            realDataBase.setValue(user)

        }
    }

}
