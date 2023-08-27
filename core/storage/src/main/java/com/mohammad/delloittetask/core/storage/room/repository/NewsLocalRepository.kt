package com.mohammad.delloittetask.core.storage.room.repository

import com.mohammad.delloittetask.core.storage.room.model.NewsLocalModel

interface NewsLocalRepository {

    suspend fun getAllNews(): MutableList<NewsLocalModel>?

    suspend fun insertAllNews(newsListLocal: MutableList<NewsLocalModel>?)

    suspend fun updateAllNews(newsListLocal: MutableList<NewsLocalModel>?)
}
