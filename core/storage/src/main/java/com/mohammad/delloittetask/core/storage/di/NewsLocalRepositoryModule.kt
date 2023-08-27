package com.mohammad.delloittetask.core.storage.di

import com.mohammad.delloittetask.core.storage.room.repository.NewsLocalRepository
import com.mohammad.delloittetask.core.storage.room.repository.NewsLocalRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface NewsLocalRepositoryModule {

    @Binds
    fun bindNewsLocalRepository(impl: NewsLocalRepositoryImpl): NewsLocalRepository
}
