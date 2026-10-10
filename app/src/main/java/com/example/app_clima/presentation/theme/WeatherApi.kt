package com.example.app_clima.presentation.theme

import com.example.app_clima.presentation.OpenWeatherApi
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApi {
    private const val BASE_URL =
        "https://api.openweathermap.org/"
    val service: OpenWeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(OpenWeatherApi::class.java)
    }
}