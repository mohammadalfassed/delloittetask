package com.mohammad.delloittetask.core.storage.room.repository

import com.mohammad.delloittetask.core.storage.room.model.NewsLocalModel
import kotlinx.coroutines.flow.Flow

interface NewsLocalRepository {

    fun getAllNews(): Flow<List<NewsLocalModel>>

    fun insertAllNews(newsListLocal: List<NewsLocalModel>?)

    fun clearAll()

}
