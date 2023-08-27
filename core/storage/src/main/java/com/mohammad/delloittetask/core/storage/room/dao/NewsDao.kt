package com.mohammad.delloittetask.core.storage.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mohammad.delloittetask.core.storage.room.model.NewsLocalModel

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    suspend fun getAllNews(): MutableList<NewsLocalModel>?

    @Insert
    suspend fun insertAllNews(newsListLocal: MutableList<NewsLocalModel>?)

    @Update
    suspend fun updateAllNews(newsListLocal: MutableList<NewsLocalModel>?)
}
