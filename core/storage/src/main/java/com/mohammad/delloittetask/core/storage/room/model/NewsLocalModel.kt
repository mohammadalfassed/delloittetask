package com.mohammad.delloittetask.core.storage.room.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "news")
@Parcelize
data class NewsLocalModel(
    @PrimaryKey(autoGenerate = false)
    val idGenerated: Int? = null,

    val id: Long? = null,

    var assetId: Long? = null,

    var source: String? = null,

    var publishedDate: String? = null,

    var url: String? = null,

    var updatedDate: String? = null,

    var section: String? = null,

    var title: String? = null,

    var abstract: String? = null,
) : Parcelable
