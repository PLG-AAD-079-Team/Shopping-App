
<h1 align="center">Movies Demo Application</h1>
<h4 align="center"> This is Movie listing app using TheMovieDb which demonstrates using of jetpack compose , retrofit, room database and hilt</h4>

</br>

## Technologies

- [Kotlin](https://kotlinlang.org/) - %100 Kotlin, No XML
- [Room Database](https://developer.android.com/training/data-storage/room) Database for local storage
- [Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) for paging network calls
- [Jetpack Compose](https://developer.android.com/jetpack/compose) for Declarative UI
- [Accompanist](https://github.com/google/accompanist) for Compose UI Widgets
- [Coil](https://github.com/coil-kt/coil) for image loading
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous operations
- [StateFlow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-state-flow/)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for Dependency Injection
- [OkHttp](https://github.com/square/okhttp) and [Retrofit](https://github.com/square/retrofit) for network operations
- [GSON](https://github.com/google/gson) for serialization

- Architecture
    - MVVM Architecture (Model View - ViewModel - Intent)

* Reasons for selecting MVI are:
  1. A unidirectional and cyclical data flow.
  2. A consistent state during the lifecycle of Views.
  3. Immutable Models that provide reliable behavior and thread safety on big apps.

- Assumptions
  - MVVM Architecture (Model View - ViewModel - Intent)
  - 

- Assumptions
  - Device has enough storage to accommodate cached images and data in the database

- Incomplete features
  - Pull to refresh
  - Top bar navigation title updates on navigation