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


class Bphome : ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bphome)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        btn1.setOnClickListener {
            // Launch SecondActivity
            val intent = Intent(this, lowbp::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            // Launch SecondActivity
            val intent = Intent(this, highbp::class.java)
            startActivity(intent)
        }

    }
}

