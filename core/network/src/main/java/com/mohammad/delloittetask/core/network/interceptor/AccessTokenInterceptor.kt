package com.mohammad.delloittetask.core.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccessTokenInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val requestBuilder = original.newBuilder()
//            .header("lang", prefs.getCurrentLanguage)
//            .header("x-device-type", "android")
//            .header("x-app-name", "mazad")
//            .header("x-app-version", BuildConfig.VERSION_NAME)
//            .header("device-id", prefs.deviceId ?: "")

//        if (userModelPref?.accessToken?.isNotEmpty() == true) {
//            requestBuilder
//                .header(
//                    "Authorization",
//                    "Bearer ${userModelPref.accessToken}"
//                ).header(
//                    "refresh-token",
//                    userModelPref.refreshToken ?: ""
//                )
//        }

        val request = requestBuilder.build()
        return chain.proceed(request)
    }

    companion object {
        private const val USER_MODEL = "userModel"
        const val ACCESS_TOKEN = "accessToken"
    }
}
