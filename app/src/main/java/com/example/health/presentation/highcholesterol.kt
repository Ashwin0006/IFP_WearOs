package com.example.health.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import android.view.Gravity
import com.example.health.R
import com.example.health.presentation.theme.HealthTheme
import android.view.View
import android.content.Intent
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.Toast



class  highcholesterol: ComponentActivity() {

    private val UPDATE_DIABETES_REQUEST = 1
    private val dietPlans = hashMapOf<String, HashMap<String, String>>(
        "Monday" to hashMapOf(
            "Breakfast" to "Oatmeal with berries",
            "Lunch" to "Grilled chicken sandwich",
            "Snacks" to "Carrot sticks with hummus",
            "Dinner" to "Salmon with quinoa"
        ),
        "Tuesday" to hashMapOf(
            "Breakfast" to "Scrambled eggs with avocado",
            "Lunch" to "Vegetable stir-fry",
            "Snacks" to "Greek yogurt with honey",
            "Dinner" to "Turkey chili with brown rice"
        ),
        "Wednesday" to hashMapOf(
            "Breakfast" to "Whole grain toast with peanut butter",
            "Lunch" to "Quinoa salad with chickpeas",
            "Snacks" to "Apple slices with almond butter",
            "Dinner" to "Vegetable curry with rice"
        ),
        "Thursday" to hashMapOf(
            "Breakfast" to "Smoothie with spinach and banana",
            "Lunch" to "Tuna salad wrap",
            "Snacks" to "Mixed nuts",
            "Dinner" to "Grilled shrimp with couscous"
        ),
        "Friday" to hashMapOf(
            "Breakfast" to "Yogurt parfait with granola",
            "Lunch" to "Caprese salad",
            "Snacks" to "Cheese and crackers",
            "Dinner" to "Pasta primavera"
        ),
        "Saturday" to hashMapOf(
            "Breakfast" to "Pancakes with maple syrup",
            "Lunch" to "Grilled vegetable sandwich",
            "Snacks" to "Trail mix",
            "Dinner" to "Steak with roasted potatoes"
        ),
        "Sunday" to hashMapOf(
            "Breakfast" to "French toast with berries",
            "Lunch" to "Cobb salad",
            "Snacks" to "Popcorn",
            "Dinner" to "Chicken fajitas"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.highcholesterol)
        val btn1 = findViewById<Button>(R.id.change)
        btn1.setOnClickListener {
            // Launch SecondActivity
            val intent = Intent(this, up_highc::class.java)
            startActivityForResult(intent, UPDATE_DIABETES_REQUEST)
        }
        val daysOfWeek = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

        // Timing options
        val timingOptions = arrayOf("Breakfast", "Lunch", "Snacks", "Dinner")

        // Diet plan for each day and timing


        // Day Spinner
        val daySpinner: Spinner = findViewById(R.id.day_spinner)
        val dayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, daysOfWeek)
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        daySpinner.adapter = dayAdapter

        // Timing Spinner
        val timingSpinner: Spinner = findViewById(R.id.timing_spinner)
        val timingAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, timingOptions)
        timingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        timingSpinner.adapter = timingAdapter

        // Spinner Item Selected Listener
        val listener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                val selectedDay = daySpinner.selectedItem.toString()
                val selectedTiming = timingSpinner.selectedItem.toString()

                // Retrieve diet plan for selected day and timing
                val dietPlan = dietPlans[selectedDay]?.get(selectedTiming)
                // Show the diet plan in a toast message
                dietPlan?.let {
                    val yOffset = 150 // Adjust this value as needed
                    val toast = Toast.makeText(applicationContext, it, Toast.LENGTH_LONG)
                    toast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM, 0, yOffset)
                    toast.show()
                }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing if nothing is selected
            }
        }

        // Assign listener to both spinners
        daySpinner.onItemSelectedListener = listener
        timingSpinner.onItemSelectedListener = listener


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == UPDATE_DIABETES_REQUEST && resultCode == RESULT_OK) {
            val selectedDay = data?.getStringExtra("selectedDay")
            val selectedTiming = data?.getStringExtra("selectedTiming")
            val updatedDietPlan = data?.getStringExtra("updatedDietPlan")

            // Update the diet plan in your HashMap
            selectedDay?.let { day ->
                selectedTiming?.let { timing ->
                    updatedDietPlan?.let { dietPlan ->
                        dietPlans[day]?.put(timing, dietPlan)
                        Toast.makeText(this, "Diet plan updated successfully!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

}

