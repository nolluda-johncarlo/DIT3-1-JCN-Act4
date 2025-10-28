package com.example.eventpracticeapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views by ID
        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextAge: EditText = findViewById(R.id.editTextAge)
        val buttonSubmit: Button = findViewById(R.id.buttonSubmit)
        val textViewOutput: TextView = findViewById(R.id.textViewOutput)

        // Set OnClickListener for the Submit button
        buttonSubmit.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val ageString = editTextAge.text.toString().trim()

            // Validation: Check if fields are empty
            if (name.isEmpty() || ageString.isEmpty()) {
                // Show Toast for empty fields
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validation: Handle invalid age (non-numeric)
            try {
                val age = ageString.toInt()
                // If valid, display the data in TextView
                textViewOutput.text = "Name: $name\nAge: $age"
                // Optional: Show success feedback via Toast
                Toast.makeText(this, "Data submitted successfully!", Toast.LENGTH_SHORT).show()
            } catch (e: NumberFormatException) {
                // Show Toast for invalid age
                Toast.makeText(this, "Please enter a valid numeric age.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
