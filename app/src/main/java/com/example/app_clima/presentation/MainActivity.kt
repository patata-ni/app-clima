/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter to find the
 * most up to date changes to the libraries and their usages.
 */

package com.example.app_clima.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.wear.compose.foundation.lazy.TransformingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberTransformingLazyColumnState
import androidx.wear.compose.material3.AppScaffold
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.ButtonDefaults
import androidx.wear.compose.material3.EdgeButton
import androidx.wear.compose.material3.ListHeader
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.ScreenScaffold
import androidx.wear.compose.material3.SurfaceTransformation
import androidx.wear.compose.material3.Text
import androidx.wear.compose.material3.lazy.rememberTransformationSpec
import androidx.wear.compose.material3.lazy.transformedHeight
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import androidx.wear.compose.ui.tooling.preview.WearPreviewFontScales
import com.example.app_clima.BuildConfig
import com.example.app_clima.R
import com.example.app_clima.presentation.theme.App_ClimaTheme
import com.example.app_clima.presentation.theme.WeatherApi
import com.example.app_clima.presentation.theme.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp("Android")
        }
    }
}

@Composable
fun WearApp(greetingName: String) {
    App_ClimaTheme {

        WeatherScreen()

    }
}

@Composable
fun WeatherScreen() {
    var weather by remember {
        mutableStateOf<WeatherResponse?>(null)
    }
    var estado by remember {
        mutableStateOf("Cargando...")
    }

    LaunchedEffect(Unit) {
        try {
            val resultado = withContext(Dispatchers.IO) {
                WeatherApi.service.getWeather(
                    lat = 20.967370,
                    lon = -89.592590,
                    apiKey = BuildConfig.OPENWEATHER_API_KEY
                )
            }
            weather = resultado
            estado = "OK"
        } catch (e: Exception) {
            estado = e.message ?: "Error"
        }
    }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
           if (weather == null){
               Text(estado)
           }else{
               Text(
                   text = "${weather!!.main.temp} °C"
               )
               Text(
                   text = weather!!.weather[0].description
               )
               Text(
                   text = weather!!.name
               )
            }
        }
    }




@WearPreviewDevices
@WearPreviewFontScales
@Composable
fun DefaultPreview() {
    WearApp("Preview Android")
}