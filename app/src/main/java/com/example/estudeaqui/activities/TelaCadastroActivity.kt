package com.example.estudeaqui.activities

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.estudeaqui.databinding.ActivityTelaCadastroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class TelaCadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaCadastroBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.textViewLogar.setOnClickListener {
            telaLogin()
        }

        binding.buttonCriarConta.setOnClickListener {
            val email = binding.editTextEmailCadastro.text
            val senha = binding.editTextSenhaCadastro.text

            if (email.isNullOrEmpty()||senha.isNullOrEmpty()) {
                Toast.makeText(this, "Email e senha não podem ficar vazios",Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            else {
                criarConta(
                    binding.editTextEmailCadastro.text.toString(),
                    binding.editTextSenhaCadastro.text.toString()
                )
            }
        }

    }

    private fun criarConta(email: String, senha: String) {

        auth.createUserWithEmailAndPassword(
            email,
            senha
        )   .addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Autenticação Efetuada", Toast.LENGTH_SHORT)
                    .show()
            }
            else {
                Log.w(TAG, "createUserWithEmailAndPassword:failure", task.exception)
                Toast.makeText(
                    this, "Erro de autenticação",
                    Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun telaLogin() {

        val intent = Intent(this, TelaLoginActivity::class.java)

        startActivity(intent)

    }


}