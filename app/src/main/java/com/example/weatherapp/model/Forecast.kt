package com.example.weatherapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Forecast(
    @Json(name = "date")
    val date: String,
    @Json(name = "high")
    val high: Int,
    @Json(name = "low")
    val low: Int,
    @Json(name = "text_day")
    val textDay: String,
    @Json(name = "text_night")
    val textNight: String,
    @Json(name = "wc_day")
    val wcDay: String,
    @Json(name = "wc_night")
    val wcNight: String,
    @Json(name = "wd_day")
    val wdDay: String,
    @Json(name = "wd_night")
    val wdNight: String,
    @Json(name = "week")
    val week: String
)