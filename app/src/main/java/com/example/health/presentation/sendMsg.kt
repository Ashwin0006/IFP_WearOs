package com.example.health.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.health.R
import com.google.firebase.firestore.FirebaseFirestore
class sendMsg : ComponentActivity() {

    private val db = FirebaseFirestore.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sendmsg)

        val send_btn = findViewById<Button>(R.id.send_msg)
        val sender_mail = intent.getStringExtra("Sender_Email")
        val sender_name = intent.getStringExtra("Sender")

        send_btn.setOnClickListener {
            val receiver_mail = findViewById<EditText>(R.id.email_rec).text.toString()
            val receiver_msg = findViewById<EditText>(R.id.msg_rec).text.toString()

            val messageCollection = db.collection("Messages")
        }


    }
}