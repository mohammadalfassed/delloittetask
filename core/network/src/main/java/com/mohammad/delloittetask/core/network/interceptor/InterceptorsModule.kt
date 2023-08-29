package com.mohammad.delloittetask.core.network.interceptor

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import okhttp3.Interceptor

@Module
@InstallIn(SingletonComponent::class)
interface InterceptorsModule {

    @Binds
    @IntoSet
    fun bindAccessTokenInterceptor(interceptor: AccessTokenInterceptor): Interceptor

}
