package com.example.weatherapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "forecasts")
    val forecasts: List<Forecast>,
    @Json(name = "location")
    val location: Location,
    @Json(name = "now")
    val now: Now
)