package com.mohammad.delloittetask.features.news.data.remote.response

import com.squareup.moshi.Json

data class RemoteNewsListWrapper(
    @Json(name = "status")
    val status: String? = null,

    @Json(name = "copyright")
    var copyright: String? = null,

    @Json(name = "num_results")
    var numResults: String? = null,

    @Json(name = "results")
    var results: List<RemoteNewsListModel>? = null
)

data class RemoteNewsListModel(
    @Json(name = "id")
    val id: Long? = null,

    @Json(name = "asset_id")
    var assetId: Long? = null,

    @Json(name = "source")
    var source: String? = null,

    @Json(name = "published_date")
    var publishedDate: String? = null,

    @Json(name = "url")
    var url: String? = null,

    @Json(name = "updated")
    var updatedDate: String? = null,

    @Json(name = "section")
    var section: String? = null,

    @Json(name = "title")
    var title: String? = null,

    @Json(name = "abstract")
    var abstract: String? = null,
)