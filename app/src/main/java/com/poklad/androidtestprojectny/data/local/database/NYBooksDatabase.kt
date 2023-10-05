package com.poklad.androidtestprojectny.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.poklad.androidtestprojectny.data.local.dao.BooksDao
import com.poklad.androidtestprojectny.data.local.dao.CategoryDao
import com.poklad.androidtestprojectny.data.local.model.CategoryEntity
import com.poklad.androidtestprojectny.utils.DatabaseConstants

@Database(
    entities = [
        CategoryEntity::class,
        BooksDao::class],
    version = DatabaseConstants.DATABASE_VERSION
)
abstract class NYBooksDatabase : RoomDatabase() {
    abstract fun getDao(): CategoryDao
}