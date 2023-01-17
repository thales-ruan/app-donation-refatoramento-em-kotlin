package com.example.firebasecomkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasecomkotlin.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var auth: FirebaseAuth

    //  private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        //   viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.criarC.setOnClickListener {
            startActivity(Intent(this, CriarActivity::class.java))

        }
        //   onLoginButtonClicked()

//        val email = binding.editEmail.text.toString()
//        val senha = binding.editSenha.text.toString()
//        viewModel.login(email,senha )


        binding.buttonEntrar.setOnClickListener {


            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(applicationContext, "Login com sucesso", Toast.LENGTH_SHORT)
                        .show()
                }else{
                    Toast.makeText(applicationContext, "Erro no login", Toast.LENGTH_SHORT)
                }
            }


        }


    }


    fun onLoginButtonClicked() {

    }
}

