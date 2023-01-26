package com.example.firebasecomkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasecomkotlin.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.criarC.setOnClickListener {
            startActivity(Intent(this, CreateAccountActivity::class.java))

        }

        binding.buttonEntrar.setOnClickListener {
                //todo verificar se o campo nao esta vazio
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener { autenticacao ->
                if (autenticacao.isSuccessful) {
                    Toast.makeText(applicationContext, "Login com sucesso", Toast.LENGTH_SHORT)
                        .show()
                    Log.i("sucess", "onCreate: ")
                }
            }.addOnFailureListener {
                Toast.makeText(applicationContext, "Erro ao fazer login", Toast.LENGTH_SHORT).show()
            }
        }
    }

}

