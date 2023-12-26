package com.example.weatherapp.repository

import com.example.weatherapp.model.WeatherModel
import com.example.weatherapp.network.WeatherApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class WeatherRepository {
    companion object{

        fun getWeather(latitude: Double, longitude: Double): Flow<WeatherModel> =
            flow {
                var weather = WeatherApiClient.weatherApiService.getWeatherData(
                    latitude,
                    longitude
                )
                emit(weather)
            }.flowOn(Dispatchers.IO)
    }
}