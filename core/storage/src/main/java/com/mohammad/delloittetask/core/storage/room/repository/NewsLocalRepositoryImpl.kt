package com.mohammad.delloittetask.core.storage.room.repository

import com.mohammad.delloittetask.core.storage.room.dao.NewsDao
import com.mohammad.delloittetask.core.storage.room.model.NewsLocalModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsLocalRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao
) : NewsLocalRepository {

    override fun getAllNews(): Flow<List<NewsLocalModel>> {
        return newsDao.getAllNews()
    }

    override fun insertAllNews(newsListLocal: List<NewsLocalModel>?) {
        return newsDao.insertAllNews(newsListLocal)
    }

    override fun clearAll() {
        return newsDao.clearAll()
    }

}
