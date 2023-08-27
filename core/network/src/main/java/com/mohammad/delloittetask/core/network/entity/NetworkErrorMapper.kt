package com.mohammad.delloittetask.core.network.entity

import com.mohammad.delloittetask.core.network.exceptions.HttpErrorBodyModel
import com.mohammad.delloittetask.core.network.exceptions.HttpStatus
import com.mohammad.delloittetask.core.network.exceptions.RemoteApisException
import com.squareup.moshi.Moshi
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NetworkErrorMapper @Inject constructor(private val moshi: Moshi) {

    fun map(throwable: Throwable): RemoteApisException {
        return when (throwable) {
            is HttpException -> {
                val errorBody = throwable.response()?.errorBody()?.string()
                val error = if (errorBody != null) {
                    moshi.adapter(HttpErrorBodyModel::class.java).fromJson(errorBody)!!
                } else {
                    HttpErrorBodyModel()
                }
                RemoteApisException.Http(
                    throwable.message(),
                    throwable,
                    error,
                    HttpStatus.valueOf(throwable.code())!!
                )
            }

            is IOException -> RemoteApisException.Network(throwable.message, throwable)
            else -> RemoteApisException.Unknown(throwable.message, throwable)
        }
    }
}
