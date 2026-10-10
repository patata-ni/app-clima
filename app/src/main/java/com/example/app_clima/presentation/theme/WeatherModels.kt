package com.example.app_clima.presentation.theme

data class WeatherResponse(
    val name: String,
    val main: MainData,
    val weather: List<WeatherData>
)

data class MainData(
    val temp: Double,

)

data class WeatherData(
    val description: String,
)