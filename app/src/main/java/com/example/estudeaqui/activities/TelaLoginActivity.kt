package com.example.estudeaqui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.estudeaqui.databinding.ActivityTelaLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class TelaLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.buttonLogar.setOnClickListener {
            logarConta(
                binding.edTextEmailLogin.text.toString(),
                binding.edTextSenhaLogin.text.toString()
            )
        }

        binding.textViewCriarConta.setOnClickListener {
            telaCadastro()
        }

    }

    private fun logarConta(email: String, senha: String) {
        auth.signInWithEmailAndPassword(
            email,
            senha
        )   .addOnCompleteListener(this) { task ->

            if (task.isSuccessful) {
                Toast.makeText(this, "Autenticação efetuada", Toast.LENGTH_SHORT)
                    .show()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(this, "Erro de autenticação", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }

    private fun telaCadastro() {

        val intent = Intent(this, TelaCadastroActivity::class.java)

        startActivity(intent)
    }

}