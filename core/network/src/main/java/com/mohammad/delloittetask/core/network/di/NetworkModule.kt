package com.mohammad.delloittetask.core.network.di

import com.mohammad.delloittetask.core.network.interceptor.AccessTokenInterceptor
import com.mohammad.delloittetask.network.BuildConfig
import com.serjltt.moshi.adapters.FallbackOnNull
import com.serjltt.moshi.adapters.Wrapped
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val TIMEOUT_MINUTES = 8L

    @Provides
    @Singleton
    fun provideOkHttp(
        interceptors: Set<@JvmSuppressWildcards Interceptor>,
        authorizationInterceptor: AccessTokenInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .readTimeout(TIMEOUT_MINUTES, TimeUnit.MINUTES)
            .writeTimeout(TIMEOUT_MINUTES, TimeUnit.MINUTES)
            .connectTimeout(TIMEOUT_MINUTES, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(authorizationInterceptor)
            .followRedirects(false)
            .followSslRedirects(false)

        interceptors.forEach { builder.addInterceptor(it) }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideMainRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideConverterFactory(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        val builder = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(Wrapped.ADAPTER_FACTORY)
            .add(FallbackOnNull.ADAPTER_FACTORY)
        return builder.build()
    }

//    @Provides
//    @Singleton
//    fun provideConverterObjects(moshi: Moshi): ConverterObjects {
//        return ConverterObjects(moshi)
//    }
}
