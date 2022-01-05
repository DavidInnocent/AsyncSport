## AsyncLabs Interview Solution

👀  Writing AsyncLabs Interview Solution App using [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/), in 100% Kotlin, using Android Jetpack Components.

The final app looks like this:

<img src="https://res.cloudinary.com/ximmoz-corp/image/upload/v1641419448/asynclabs/splash.png" width="270"/> <img src="https://res.cloudinary.com/ximmoz-corp/image/upload/v1641419448/asynclabs/home.png" width="270"/> <img src="https://res.cloudinary.com/ximmoz-corp/image/upload/v1641419448/asynclabs/athletes.png" width="270"/>


### Background

create an application that will serve a feed with posts that are based around videos:

* Fetch video feeds and display video via player.

* Fetch athletes list from the api and display information about the athletes.

## Tech-stack

* Tech-stack
    * [Kotlin](https://kotlinlang.org/) - a cross-platform, statically typed, general-purpose programming language with type inference.
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations.

    * [Hilt](https://dagger.dev/hilt/) - Hilt provides a standard way to incorporate Dagger dependency injection into an Android application
    * [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java
    * [Jetpack](https://developer.android.com/jetpack)
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - is an observable data holder.
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform action when lifecycle state changes.
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way.


* Architecture
    * MVVM - Model View View Model
