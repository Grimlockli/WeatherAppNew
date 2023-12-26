package com.example.weatherapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Now(
    @Json(name = "feels_like")
    val feelsLike: Int,
    @Json(name = "rh")
    val rh: Int,
    @Json(name = "temp")
    val temp: Int,
    @Json(name = "text")
    val text: String,
    @Json(name = "uptime")
    val uptime: String,
    @Json(name = "wind_class")
    val windClass: String,
    @Json(name = "wind_dir")
    val windDir: String
)