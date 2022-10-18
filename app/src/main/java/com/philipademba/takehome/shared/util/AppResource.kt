package com.philipademba.takehome.shared.util

sealed class AppResource<T> {
    data class Success<T>(val data: T) : AppResource<T>()
    data class Error<T>(val message: String) : AppResource<T>()
    class Loading<T> : AppResource<T>()

    companion object {
        fun <T> success(data: T) = Success<T>(data)
        fun <T> error(message: String) = Error<T>(message)
        fun <T> loading() = Loading<T>()
    }
}