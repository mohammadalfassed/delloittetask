package com.mohammad.delloittetask.features.news.domain.models

data class NewsListWrapper(
    val status: String? = null,

    var copyright: String? = null,

    var numResults: String? = null,

    var results: List<NewsListModel>? = null
)

data class NewsListModel(
    val id: Long? = null,

    var assetId: Long? = null,

    var source: String? = null,

    var publishedDate: String? = null,

    var url: String? = null,

    var updatedDate: String? = null,

    var section: String? = null,

    var title: String? = null,

    var abstract: String? = null,
)