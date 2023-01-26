package com.example.firebasecomkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasecomkotlin.databinding.ActivityCreateAccountBinding
import com.example.firebasecomkotlin.firebase.SettingsFireBase
import com.example.firebasecomkotlin.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateAccountBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseReference
    private val firebase = SettingsFireBase()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.buttonCreate.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            val radioGroup = binding.rdGrupUserEntity
            val radioButtonEntity = binding.rdEntity
            val radioButtonUser = binding.rdUser
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
                startActivity(Intent(this, LoginActivity::class.java))
                Toast.makeText(this, "Entre com seu Login", Toast.LENGTH_SHORT).show()
                finish()
            } else if (selectedId == radioButtonEntity.id) {
                user.type = "empresa"
                startActivity(Intent(this, LoginActivity::class.java))
                Toast.makeText(this, "Entre com seu Login", Toast.LENGTH_SHORT).show()
                finish()

            }

            db = FirebaseDatabase.getInstance().reference
            val realDataBase = db.child("Userss").child(firebase.getIdUser())
            realDataBase.setValue(user)

        }
    }

}
