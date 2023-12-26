package com.example.weatherapp.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.model.WeatherModel
import com.example.weatherapp.model.WeatherState
import com.example.weatherapp.repository.WeatherRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

    val weatherData: MutableState<WeatherState> = mutableStateOf(WeatherState.Empty)

    init {
        //
        getWeatherData(52.52,13.41);
    }

    fun getWeatherData(latitude: Double, longitude: Double){
        viewModelScope.launch {
            WeatherRepository.getWeather(latitude, longitude)
                .onStart {
                    weatherData.value = WeatherState.Loading
                }
                // 捕获异常
                .catch { e ->
                    weatherData.value = WeatherState.Failure(e)
                }
                // 回调数据
                .collect{response ->
                    weatherData.value = WeatherState.Success(response)
                }

        }
    }
}