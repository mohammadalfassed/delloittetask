package com.mohammad.delloittetask.core.storage.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mohammad.delloittetask.core.storage.room.model.NewsLocalModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getAllNews(): Flow<List<NewsLocalModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllNews(newsListLocal: List<NewsLocalModel>?)

    @Query("DELETE FROM news")
    fun clearAll()
}
