package com.poklad.androidtestprojectny.domain.repositories

import com.poklad.androidtestprojectny.domain.model.Category

interface CategoryRepository {
    suspend fun getCategories(): List<Category>

   /* suspend fun readCategories(): List<CategoryEntity>
    suspend fun insertCategories(categoriesList: List<CategoryEntity>)*/
}