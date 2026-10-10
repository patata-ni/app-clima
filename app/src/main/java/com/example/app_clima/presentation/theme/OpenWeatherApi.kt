package com.example.app_clima.presentation

import com.example.app_clima.presentation.theme.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi{
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "es"
    ): WeatherResponse
}