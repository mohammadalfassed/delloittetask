package com.mohammad.delloittetask.features.news.domain.repository


import com.mohammad.delloittetask.features.news.domain.models.NewsListModel

interface NewsRepository {

    suspend fun getPopularNews(period: Int = 1): List<NewsListModel>?
}
