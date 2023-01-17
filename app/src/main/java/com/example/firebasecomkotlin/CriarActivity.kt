package com.example.firebasecomkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.firebasecomkotlin.databinding.ActivityCriarBinding
import com.example.firebasecomkotlin.databinding.ActivityMainBinding
import com.example.firebasecomkotlin.firebase.AutenticaFireBase

import com.google.firebase.auth.FirebaseAuth

class CriarActivity : AppCompatActivity() {


    private lateinit var binding: ActivityCriarBinding

    //   private lateinit var viewModel: MainViewModel

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar)


        binding = ActivityCriarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        //     viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonCriar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

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


        }


    }
}