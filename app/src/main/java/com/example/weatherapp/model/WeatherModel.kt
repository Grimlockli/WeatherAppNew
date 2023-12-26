package com.example.weatherapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherModel(
    @Json(name = "elevation")
    val elevation: Double,
    @Json(name = "generationtime_ms")
    val generationtimeMs: Double,
    @Json(name = "hourly")
    val hourly: Hourly,
    @Json(name = "hourly_units")
    val hourlyUnits: HourlyUnits,
    @Json(name = "latitude")
    val latitude: Double,
    @Json(name = "longitude")
    val longitude: Double,
    @Json(name = "timezone")
    val timezone: String,
    @Json(name = "timezone_abbreviation")
    val timezoneAbbreviation: String,
    @Json(name = "utc_offset_seconds")
    val utcOffsetSeconds: Int
){
    @JsonClass(generateAdapter = true)
    data class HourlyUnits(
        @Json(name = "precipitation_probability")
        val precipitationProbability: String,
        @Json(name = "temperature_2m")
        val temperature2m: String,
        @Json(name = "time")
        val time: String,
        @Json(name = "weather_code")
        val weatherCode: String
    )
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
}