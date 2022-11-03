package com.example.estudeaqui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.estudeaqui.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginIntro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_intro)

        val  auth = Firebase.auth

        if (auth.currentUser != null) {
            Toast.makeText(this, "oie :D",Toast.LENGTH_SHORT)
                .show()
            redirect("MAIN")
        }

        findViewById<Button>(R.id.buttonLoginIntro).setOnClickListener {
            redirect("LOGIN")
        }

    }

    private fun redirect(nome: String) {
        val intent = when(nome) {
            "LOGIN" -> Intent(this, TelaLoginActivity::class.java)
            "MAIN" -> Intent(this, MainActivity::class.java)
            else -> throw Exception("Não existe um caminho")
        }
        startActivity(intent)

        finish()
    }
}