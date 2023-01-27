package com.example.firebasecomkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasecomkotlin.databinding.ActivityLoginBinding
import com.example.firebasecomkotlin.firebase.SettingsFireBase
import com.example.firebasecomkotlin.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var auth: FirebaseAuth

    private lateinit var referenceFirebase: DatabaseReference

    private var idUserLogged = SettingsFireBase().getIdUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        referenceFirebase = FirebaseDatabase.getInstance().getReference()


        binding.tVCreatAccount.setOnClickListener {
            startActivity(Intent(this, CreateAccountActivity::class.java))

        }

        binding.buttonEnter.setOnClickListener {
                //todo verificar se o campo nao esta vazio
            val email = binding.editEmail.text.toString()
            val senha = binding.editPassword.text.toString()

            auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener { autenticacao ->
                if (autenticacao.isSuccessful) {
                    Toast.makeText(applicationContext, "Login com sucesso", Toast.LENGTH_SHORT)
                        .show()
                    Log.i("sucess", "onCreate: ")
                    directActivity()
                }
            }.addOnFailureListener {
                Toast.makeText(applicationContext, "Erro ao fazer login", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun directActivity(){
        val userRef: DatabaseReference = referenceFirebase
            .child("Userss")
            .child(idUserLogged)

        //val user = User()

        userRef.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                val userType = snapshot.child("type").value as String?

                if(userType!= null && userType == "usuario"){
                    val intent = Intent(applicationContext,InitialDonorActivity::class.java)
                    startActivity(intent)
                }else if(userType!= null && userType == "empresa"){
                    val intent = Intent(applicationContext,InitialEntityActivity::class.java)
                    startActivity(intent)
                }


            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("error direct", "onCancelled: ")
            }

        })

    }
//teste do commit

}

