package com.poklad.androidtestprojectny.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poklad.androidtestprojectny.data.local.model.CategoryEntity
import com.poklad.androidtestprojectny.utils.DatabaseConstants

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categoriesList: List<CategoryEntity>)

    @Query(DatabaseConstants.GET_CATEGORIES_FROM_DB)
    suspend fun readAllCategories(): List<CategoryEntity>
}