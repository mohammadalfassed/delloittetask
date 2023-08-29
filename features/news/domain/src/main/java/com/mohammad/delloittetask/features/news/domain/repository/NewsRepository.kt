package com.mohammad.delloittetask.features.news.domain.repository


import com.mohammad.delloittetask.core.network.entity.RequestState
import com.mohammad.delloittetask.features.news.domain.models.NewsListModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getPopularNews(period: Int = 1): Flow<RequestState<List<NewsListModel>>>
}
