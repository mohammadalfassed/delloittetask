package com.mohammad.delloittetask.core.storage.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mohammad.delloittetask.core.storage.room.dao.NewsDao
import com.mohammad.delloittetask.core.storage.room.model.NewsLocalModel


@Database(entities = [NewsLocalModel::class], version = 4)
abstract class DelloitteTaskDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}