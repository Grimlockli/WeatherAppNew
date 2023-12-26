package com.example.weatherapp.model

sealed class WeatherState {
    class Success(val weather: WeatherModel) : WeatherState()
    class Failure(val error: Throwable) : WeatherState()
    object Loading : WeatherState()
    object Empty : WeatherState()
}