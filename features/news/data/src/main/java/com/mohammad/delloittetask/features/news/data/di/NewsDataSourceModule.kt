package com.mohammad.delloittetask.features.news.data.di

import com.mohammad.delloittetask.features.news.data.remote.RemoteNewsDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NewsDataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteNewsDataSource(retrofit: Retrofit): RemoteNewsDataSource {
        return retrofit.create(RemoteNewsDataSource::class.java)
    }
}
