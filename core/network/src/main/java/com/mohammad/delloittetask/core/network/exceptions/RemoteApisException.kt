package com.mohammad.delloittetask.core.network.exceptions

sealed class RemoteApisException(message: String?, throwable: Throwable) :
    Throwable(message, throwable) {

    class Network(message: String?, throwable: Throwable) : RemoteApisException(message, throwable)

    class Http(
        message: String,
        throwable: Throwable,
        val body: HttpErrorBodyModel,
        val status: HttpStatus
    ) : RemoteApisException(message, throwable)

    class Unknown(message: String?, throwable: Throwable) : RemoteApisException(message, throwable)
}
