package com.example.firebasecomkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebasecomkotlin.databinding.ActivityCriarContaBinding
import com.example.firebasecomkotlin.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CriarContaActivity : AppCompatActivity() {


    private lateinit var binding: ActivityCriarContaBinding

    //   private lateinit var viewModel: MainViewModel

    private lateinit var auth: FirebaseAuth
    private lateinit var db :DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_conta)


        binding = ActivityCriarContaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        //     viewModel = ViewModelProvider(this).get(MainViewModel::class.java)





        binding.buttonCriar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            val nome = binding.editNome.text.toString()

            val radioGroup = binding.rdGrupUsuarioEmpresa
            val radioButtonEmpresa = binding.rdEmpresa
            val radioButtonUsuario = binding.rdUsuario
            val selectedId = radioGroup.checkedRadioButtonId





            db = FirebaseDatabase.getInstance().getReference("Userss")
            val User = User(nome)
            db.child(nome).setValue(User).addOnCompleteListener{
                binding.editNome.text.clear()
                Toast.makeText(applicationContext, "SUCESS", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(applicationContext, "FAILED", Toast.LENGTH_SHORT).show()
            }

            val usuario = User()
            if (selectedId == radioButtonUsuario.id){
                usuario.type = "usuario"
            }else if(selectedId == radioButtonEmpresa.id){
                usuario.type = "empresa"
            }
            db.setValue(usuario)





//            val userModel = User()
//            if (selectedId == radioButtonEmpresa.id) {
//                userModel.accountType = "employer"
//            } else {
//                userModel.accountType = "user"
//            }
//


//TODO TA FUNCIONANDO O SALVAMENTO NO FIREBASE POREM ELE NAO ESTA PEGANNDO O ID DO USUARIO ASSIM SUBSTITUINDO NO BANCO


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
//teste commit





//
//
//            val radioGroup = binding.rdGrupUsuarioEmpresa
//            val radioButtonEmpresa = binding.rdEmpresa
//            val radioButtonUsuario = binding.rdUsuario
//
//            val selectedId = radioGroup.checkedRadioButtonId
//
//            val user = FirebaseAuth.getInstance().currentUser
//
//            val userId = user?.uid
//            val database = FirebaseDatabase.getInstance().reference
//            val userRef = database.child("users").child(userId!!)
//            if (selectedId == radioButtonEmpresa.id) {
//                userRef.child("accountType").setValue("employer")
//            } else {
//                userRef.child("accountType").setValue("user")
//            }
//        binding.buttonCriar.setOnClickListener {
//
//
//
//
//
//
//            val user = FirebaseAuth.getInstance().currentUser
//            val userId = user?.uid
//            val database = FirebaseDatabase.getInstance().reference
//            val userRef = database.child("users").child(userId!!)
//            val accountType = userRef.child("accountType").addListenerForSingleValueEvent(object :
//                ValueEventListener {
//                override fun onDataChange(dataSnapshot: DataSnapshot) {
//                    val type = dataSnapshot.getValue(String::class.java)
//                    if (type == "employer") {
//                        // Se for empresa inicia activity empresa
//                        Toast.makeText(applicationContext, "empresa", Toast.LENGTH_SHORT).show()
////                        val intent = Intent(this, InicialEntidadeActivity::class.java)
////                        startActivity(intent)
//                    } else {
//                        // Se for usuário inicia activity usuário
////                        val intent = Intent(this, InicialDoadorActivity::class.java)
////                        startActivity(intent)
//                        Toast.makeText(applicationContext, "usuario", Toast.LENGTH_SHORT).show()
//                    }
//                }
//                override fun onCancelled(databaseError: DatabaseError) {
//                    Log.e("TAG", "loadPost:onCancelled", databaseError.toException())
//                }
//            })
//
//        }
//
//        }

        }










//
//
//        //todo
//        val user = FirebaseAuth.getInstance().currentUser
//        val userId = user?.uid
//        val database = FirebaseDatabase.getInstance().reference
//        val userRef = database.child("users").child(userId)
//        userRef.child("accountType").setValue("employer")
//
//// Recuperando informações adicionais sobre o usuário
//        val user = FirebaseAuth.getInstance().currentUser
//        val userId = user?.uid
//        val database = FirebaseDatabase.getInstance().reference
//        val userRef = database.child("users").child(userId)
//        val accountType = userRef.child("accountType").addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val type = dataSnapshot.getValue(String::class.java)
//                if (type == "employer") {
//                    // Se for empresa inicia activity empresa
////                    val intent = Intent(this, EmpresaActivity::class.java)
////                    startActivity(intent)
//                } else {
//                    // Se for usuário inicia activity usuário
////                    val intent = Intent(this, UsuarioActivity::class.java)
////                    startActivity(intent)
//                }
//            }
////            override fun onCancelled(databaseError: DatabaseError) {
////                Log.e(TAG, "loadPost:onCancelled", databaseError.toException())
////            }
//        })





    }
}