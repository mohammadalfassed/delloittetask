package com.mohammad.delloittetask.core.storage.di

import android.content.Context
import androidx.room.Room
import com.mohammad.delloittetask.core.storage.room.DelloitteTaskDatabase
import com.mohammad.delloittetask.core.storage.room.dao.NewsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomLocalDataModule {

    @Provides
    @Singleton
    fun provideDelloitteTaskDatabase(@ApplicationContext appContext: Context): DelloitteTaskDatabase {
        return Room.databaseBuilder(
            appContext,
            DelloitteTaskDatabase::class.java,
            "DelloitteTaskDatabase"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(delloitteTaskDatabase: DelloitteTaskDatabase): NewsDao {
        return delloitteTaskDatabase.newsDao()
    }
}