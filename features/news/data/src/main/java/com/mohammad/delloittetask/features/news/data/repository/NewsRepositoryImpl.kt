package com.mohammad.delloittetask.features.news.data.repository

import com.mohammad.delloittetask.core.network.entity.NetworkErrorMapper
import com.mohammad.delloittetask.core.network.entity.getOrThrow
import com.mohammad.delloittetask.core.network.entity.map
import com.mohammad.delloittetask.core.network.entity.mapError
import com.mohammad.delloittetask.core.network.entity.runWithCatching
import com.mohammad.delloittetask.core.storage.room.repository.NewsLocalRepository
import com.mohammad.delloittetask.features.news.data.mapper.NewsMapper
import com.mohammad.delloittetask.features.news.data.remote.RemoteNewsDataSource
import com.mohammad.delloittetask.features.news.domain.models.NewsListModel
import com.mohammad.delloittetask.features.news.domain.repository.NewsRepository
import javax.inject.Inject

internal class NewsRepositoryImpl @Inject constructor(
    private val remoteNewsDataSource: RemoteNewsDataSource,
    private val newsLocalRepository: NewsLocalRepository,
    private val newsMapper: NewsMapper,
    private val networkErrorMapper: NetworkErrorMapper,
) : NewsRepository {
    override suspend fun getPopularNews(period: Int): List<NewsListModel>? {
        var newsList = runWithCatching {
            remoteNewsDataSource.getPopularNews(period)
        }.map(newsMapper::map).mapError(networkErrorMapper::map)
            .getOrThrow().results?.toMutableList()

        if (newsList.isNullOrEmpty()) {
            newsList = getNewsListFromRoom()
        } else {
            if (getNewsListFromRoom().isNullOrEmpty()) {
                insertAllNews(newsList)
            } else {
                updateAllNews(newsList)
            }
        }

        return newsList
    }

    private suspend fun getNewsListFromRoom(): MutableList<NewsListModel>? {
        return newsLocalRepository.getAllNews()?.map { newsMapper.map(it) }?.toMutableList()
    }

    private suspend fun insertAllNews(newsList: MutableList<NewsListModel>?) {
        return newsLocalRepository.insertAllNews(newsList?.map { newsMapper.map(it) }
            ?.toMutableList())
    }

    private suspend fun updateAllNews(newsList: MutableList<NewsListModel>?) {
        return newsLocalRepository.updateAllNews(newsList?.map { newsMapper.map(it) }
            ?.toMutableList())
    }
}

