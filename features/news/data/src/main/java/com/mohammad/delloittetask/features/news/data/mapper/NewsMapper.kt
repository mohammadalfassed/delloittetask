package com.mohammad.delloittetask.features.news.data.mapper

import com.mohammad.delloittetask.core.storage.room.model.NewsLocalModel
import com.mohammad.delloittetask.features.news.data.remote.response.RemoteNewsListModel
import com.mohammad.delloittetask.features.news.data.remote.response.RemoteNewsListWrapper
import com.mohammad.delloittetask.features.news.domain.models.NewsListModel
import com.mohammad.delloittetask.features.news.domain.models.NewsListWrapper
import javax.inject.Inject

class NewsMapper @Inject constructor() {

    fun map(source: RemoteNewsListWrapper?): NewsListWrapper {
        return NewsListWrapper(
            status = source?.status,
            copyright = source?.copyright,
            numResults = source?.numResults,
            results = source?.results?.map { map(it) },
        )
    }

    fun map(source: RemoteNewsListModel?): NewsListModel {
        return NewsListModel(
            id = source?.id,
            assetId = source?.assetId,
            source = source?.source,
            abstract = source?.abstract,
            publishedDate = source?.publishedDate,
            section = source?.section,
            title = source?.title,
            updatedDate = source?.updatedDate,
            url = source?.url,
        )
    }

    fun map(source: NewsLocalModel?): NewsListModel {
        return NewsListModel(
            id = source?.id,
            assetId = source?.assetId,
            source = source?.source,
            abstract = source?.abstract,
            publishedDate = source?.publishedDate,
            section = source?.section,
            title = source?.title,
            updatedDate = source?.updatedDate,
            url = source?.url,
        )
    }
}
