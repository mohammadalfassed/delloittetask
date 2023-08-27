package com.mohammad.delloittetask.core.storage.room.repository

import com.mohammad.delloittetask.core.storage.room.dao.NewsDao
import com.mohammad.delloittetask.core.storage.room.model.NewsLocalModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsLocalRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao
) : NewsLocalRepository {

    override suspend fun getAllNews(): MutableList<NewsLocalModel>? {
        return newsDao.getAllNews()
    }

    override suspend fun insertAllNews(newsListLocal: MutableList<NewsLocalModel>?) {
        return newsDao.insertAllNews(newsListLocal)
    }

    override suspend fun updateAllNews(newsListLocal: MutableList<NewsLocalModel>?) {
        return newsDao.updateAllNews(newsListLocal)
    }

}
