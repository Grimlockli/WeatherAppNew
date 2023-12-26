package com.example.weatherapp.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.weatherapp.model.WeatherModel

@Composable
fun HourlyScreen(hourly: WeatherModel.Hourly) {
    ComposeText(text = "${hourly.time}, ${hourly.temperature2m}", fontSize = 30.sp)
}
