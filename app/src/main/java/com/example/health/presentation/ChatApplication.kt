package com.example.health.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.health.R
import com.google.firebase.firestore.FirebaseFirestore

class ChatApplication : ComponentActivity() {

    private val db = FirebaseFirestore.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chat)

        val textDisp = findViewById<TextView>(R.id.user_name)
        val send_btn = findViewById<Button>(R.id.send_btn)
        val read_btn = findViewById<Button>(R.id.read_btn)

        var userEmail = "Default"
        var dispName = "None"

        userEmail = intent.getStringExtra("Email").toString()

        val usersCollection = db.collection("user_email")

        usersCollection.document(userEmail).get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val userName = document.getString("User")
                    if (userName != null) {
                        dispName = userName
                        textDisp.text = "Welcome $dispName!"

                        send_btn.setOnClickListener {
                            // Launch SecondActivity
                            val intent = Intent(this, sendMsg::class.java)
                            intent.putExtra("Sender_Email", userEmail)
                            intent.putExtra("Sender", userName)
                            startActivity(intent)
                        }
                    }
                } else {
                    Log.d("Firestore", "Document not found for email: $userEmail")
                }
            }
            .addOnFailureListener { exception ->
                // Error occurred while retrieving document
                Log.e("Firestore", "Error getting document", exception)
            }

    }

}