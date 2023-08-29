package com.mohammad.delloittetask.core.network.entity

sealed class RequestState<out T> {
    object Loading : RequestState<Nothing>()
    data class Error(val exception: Exception) : RequestState<Nothing>()
    data class Success<T>(val data: T) : RequestState<T>()
}
