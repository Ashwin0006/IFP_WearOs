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
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner


class  up_lowbp: ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.up_lowbp)
        val updateButton: Button = findViewById(R.id.change)
        val updatedDietPlanEditText: EditText = findViewById(R.id.updated_diet_plan_edit_text)
        val daySpinner: Spinner = findViewById(R.id.day_spinner)
        val timingSpinner: Spinner = findViewById(R.id.timing_spinner)

        // Days of week
        val daysOfWeek = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val dayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, daysOfWeek)
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        daySpinner.adapter = dayAdapter

        // Timing options
        val timingOptions = arrayOf("Breakfast", "Lunch", "Snacks", "Dinner")
        val timingAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, timingOptions)
        timingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        timingSpinner.adapter = timingAdapter

        updateButton.setOnClickListener {
            val selectedDay = daySpinner.selectedItem.toString()
            val selectedTiming = timingSpinner.selectedItem.toString()
            val updatedDietPlan = updatedDietPlanEditText.text.toString()

            val intent = Intent().apply {
                putExtra("selectedDay", selectedDay)
                putExtra("selectedTiming", selectedTiming)
                putExtra("updatedDietPlan", updatedDietPlan)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}

