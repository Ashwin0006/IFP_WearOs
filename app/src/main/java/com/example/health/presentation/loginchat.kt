/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.health.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.health.R
import android.content.Intent
import android.widget.Button
import android.widget.EditText

class loginchat : ComponentActivity() {
    lateinit var edtEmail: EditText
    lateinit var edtpassword: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_loinchat)
        edtEmail = findViewById(R.id.edt_email)

        edtpassword = findViewById(R.id.edt_password)

        val btnLogin = findViewById<Button>(R.id.btn_login)

        val btnsignup = findViewById<Button>(R.id.btn_signup)

        btnsignup.setOnClickListener {



            val intent = Intent(this, signupchat::class.java)

            startActivity(intent)

        }
         // Assuming it's a button for login

// Other code...

//        val btn2 = findViewById<Button>(R.id.btn2)
//
//        btn2.setOnClickListener {
//            // Launch SecondActivity
//            val intent = Intent(this, ChatActivity::class.java)
//            startActivity(intent)
//        }

    }
}

