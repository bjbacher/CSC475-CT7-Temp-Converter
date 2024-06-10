package com.example.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.temperatureconverter.ui.theme.TemperatureConverterTheme

class MainActivity : ComponentActivity() {
    private lateinit var convertButton: Button
    private lateinit var celsiusEditText: EditText
    private lateinit var fahrenheitEditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        convertButton = findViewById(R.id.convert_button)
        celsiusEditText = findViewById(R.id.celsiusEditText)
        fahrenheitEditText = findViewById(R.id.fahrenheitEditText)
        resultTextView = findViewById(R.id.resultTextView)

        // Set up onClickListener for the convert button
        convertButton.setOnClickListener {
            // Retrieve input values from EditText fields
            val celsiusInput = celsiusEditText.text.toString().toDoubleOrNull()
            val fahrenheitInput = fahrenheitEditText.text.toString().toDoubleOrNull()

            // Check if both inputs are not null
            if (celsiusInput != null && fahrenheitInput != null) {
                // Display error message if both inputs are provided
                resultTextView.text = "Please provide input for only one temperature"
            } else if (celsiusInput != null) {
                // Convert from Celsius to Fahrenheit if Celsius input is provided
                val result = convertCelsiusToFahrenheit(celsiusInput)
                resultTextView.text = result.toString()
            } else if (fahrenheitInput != null) {
                // Convert from Fahrenheit to Celsius if Fahrenheit input is provided
                val result = convertFahrenheitToCelsius(fahrenheitInput)
                resultTextView.text = result.toString()
            } else {
                // Display error message if no input is provided
                resultTextView.text = "Please provide input for at least one temperature"
            }
        }
    }

    // algorithm to convert Celsius to Fahrenheit
    private fun convertCelsiusToFahrenheit(celsius: Double): Double {
        return (celsius * 9 / 5) + 32
    }

    // Algorithm to convert Fahrenheit to Celsius
    private fun convertFahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9
    }
}