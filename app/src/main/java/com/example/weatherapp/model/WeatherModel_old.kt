package com.example.weatherapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherModel_old(
    @Json(name = "message")
    val message: String,
    @Json(name = "result")
    val result: Result,
    @Json(name = "status")
    val status: Int
){
    @JsonClass(generateAdapter = true)
    data class Result(
        @Json(name = "forecasts")
        val forecasts: List<Forecast>,
        @Json(name = "location")
        val location: Location,
        @Json(name = "now")
        val now: Now
    ){
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

        @JsonClass(generateAdapter = true)
        data class Location(
            @Json(name = "city")
            val city: String,
            @Json(name = "country")
            val country: String,
            @Json(name = "id")
            val id: String,
            @Json(name = "name")
            val name: String,
            @Json(name = "province")
            val province: String
        )

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

    }
}

