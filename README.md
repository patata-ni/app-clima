# App Clima (Wear OS)

Aplicación de **Wear OS** (reloj) en Kotlin con Jetpack Compose que muestra el
clima actual: temperatura, descripción y nombre del lugar. Los datos vienen de la
API de [OpenWeather](https://openweathermap.org/api). Incluye también una
*complication* y un *tile* para la esfera del reloj.

Por ahora consulta unas coordenadas fijas (Mérida, Yucatán) en
`MainActivity.kt`.

## Configurar la clave de OpenWeather

Este repositorio **no incluye** ninguna clave.

1. Crea una cuenta gratuita en OpenWeather y copia tu *API key*.
2. En [MainActivity.kt](./app/src/main/java/com/example/app_clima/presentation/MainActivity.kt)
   sustituye `TU_API_KEY_DE_OPENWEATHER` por tu clave.

Una clave incrustada en el código acaba en el repositorio. Para algo más allá de
una práctica, guárdala en `local.properties` y léela con `BuildConfig`.

## Ejecutar

Requisitos: Android Studio reciente y un emulador o reloj con Wear OS.

1. Abre esta carpeta en Android Studio y espera la sincronización de Gradle.
2. Elige un dispositivo Wear OS y pulsa **Run**.

El proyecto usa `minSdk 35` y `targetSdk 36`. Android Studio crea
`local.properties` con la ruta de tu SDK; ese archivo no se versiona.

## Tecnologías

Kotlin, Jetpack Compose para Wear OS, Retrofit/OpenWeather, Tiles y
Complications de Wear OS.
