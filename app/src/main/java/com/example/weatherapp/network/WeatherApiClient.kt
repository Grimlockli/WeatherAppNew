package com.example.weatherapp.network

import com.example.weatherapp.model.WeatherModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object WeatherApiClient {

    private val Base_URL = "https://api.open-meteo.com/v1/hourly=temperature_2m/"

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val weatherApiService: WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }
}

interface WeatherApiService{
    @GET("forecast")

    //
    suspend fun getWeatherData(
        @Query("latitude") latitude:Double,
        @Query("longitude") longitude:Double
        ) : WeatherModel
}