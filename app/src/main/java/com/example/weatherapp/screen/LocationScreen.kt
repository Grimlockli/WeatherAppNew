package com.example.weatherapp.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.weatherapp.model.WeatherModel_old

@Composable
fun LocationScreen(location: WeatherModel_old.Result.Location) {
    ComposeText(text = "${location.city}, ${location.name}", fontSize = 30.sp)
}