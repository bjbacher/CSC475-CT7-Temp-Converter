package com.example.temperatureconverter

import org.junit.Test
import org.junit.Assert.*
import kotlin.random.Random

// Conversion functions from main class
fun convertCelsiusToFahrenheit(celsius: Double): Double {
    return (celsius * 9 / 5) + 32
}

fun convertFahrenheitToCelsius(fahrenheit: Double): Double {
    return (fahrenheit - 32) * 5 / 9
}


class ExampleUnitTest {

    // Test for Celsius to Fahrenheit conversion
    @Test
    fun testCelsiusToFahrenheitConversion() {
        val celsius = Random.nextDouble(-100.0, 100.0)
        val expectedFahrenheit = (celsius * 9 / 5) + 32
        val actualFahrenheit = convertCelsiusToFahrenheit(celsius)
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001)
    }

    // Test for Fahrenheit to Celsius conversion
    @Test
    fun testFahrenheitToCelsiusConversion() {
        val fahrenheit = Random.nextDouble(-100.0, 100.0)
        val expectedCelsius = (fahrenheit - 32) * 5 / 9
        val actualCelsius = convertFahrenheitToCelsius(fahrenheit)
        assertEquals(expectedCelsius, actualCelsius, 0.001)
    }

    // Your existing addition test
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
