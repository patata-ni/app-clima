# App Clima (Wear OS)

Aplicación de **Wear OS** (reloj) en Kotlin con Jetpack Compose que muestra el
clima actual: temperatura, descripción y nombre del lugar. Los datos vienen de la
API de [OpenWeather](https://openweathermap.org/api). Incluye también una
*complication* y un *tile* para la esfera del reloj.

Por ahora consulta unas coordenadas fijas (Mérida, Yucatán) en
`MainActivity.kt`.

## Configurar la clave de OpenWeather

Este repositorio **no incluye** ninguna clave. Se lee de `local.properties`,
un archivo que git ignora, así que tu clave nunca se sube a GitHub.

1. Crea una cuenta gratuita en OpenWeather y copia tu *API key*.
2. Copia [local.properties.example](./local.properties.example) como
   `local.properties` en la raíz del proyecto.
3. Sustituye `TU_API_KEY_DE_OPENWEATHER` por tu clave.

Si `local.properties` ya existe (Android Studio lo crea con la ruta del SDK),
añade la línea `OPENWEATHER_API_KEY=...` sin borrar `sdk.dir`.
Sin clave, la app compila pero el clima no carga.

La clave se compila dentro de la app (`BuildConfig`), así que quien tenga el APK
puede extraerla. Es aceptable en una práctica; en una app real, la clave debería
estar en un servidor propio.

## Ejecutar

Requisitos: Android Studio reciente y un emulador o reloj con Wear OS.

1. Abre esta carpeta en Android Studio y espera la sincronización de Gradle.
2. Elige un dispositivo Wear OS y pulsa **Run**.

El proyecto usa `minSdk 35` y `targetSdk 36`. Android Studio crea
`local.properties` con la ruta de tu SDK; ese archivo no se versiona.

## Tecnologías

Kotlin, Jetpack Compose para Wear OS, Retrofit/OpenWeather, Tiles y
Complications de Wear OS.
