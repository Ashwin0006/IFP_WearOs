package com.example.health.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.health.R
import com.google.firebase.auth.FirebaseAuth

class ChatApp : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Authentication
        auth = FirebaseAuth.getInstance()

        setContent {
            // Set your Compose content here if you're using Jetpack Compose
        }

        // If you're not using Jetpack Compose, you can still access your views like this:
        setContentView(R.layout.activity_chatlogin)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtPassword = findViewById<EditText>(R.id.edt_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            // Authenticate user with email and password
            signInWithEmailAndPassword(email, password)
        }
    }

    private fun signInWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    val intent = Intent(this, ChatApplication::class.java)
                    intent.putExtra("Email", email)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("LoginActivity", "signInWithEmail:failure", task.exception)
                    // Update UI accordingly, e.g., show an error message
                }
            }
    }
}
