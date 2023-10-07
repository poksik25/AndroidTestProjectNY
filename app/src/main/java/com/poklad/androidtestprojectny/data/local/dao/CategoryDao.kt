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
    fun insertCategories(categoriesList: List<CategoryEntity>)

    @Query("SELECT * FROM category")
    fun readAllCategories(): List<CategoryEntity>?
}