package com.example.weatherapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hourly(
    @Json(name = "precipitation_probability")
    val precipitationProbability: List<Int>,
    @Json(name = "temperature_2m")
    val temperature2m: List<Double>,
    @Json(name = "time")
    val time: List<String>,
    @Json(name = "weather_code")
    val weatherCode: List<Int>
)