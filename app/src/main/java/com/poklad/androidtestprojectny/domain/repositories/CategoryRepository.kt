package com.poklad.androidtestprojectny.domain.repositories

import com.poklad.androidtestprojectny.domain.model.CategoryItem

interface CategoryRepository {
    suspend fun getCategories(): List<CategoryItem>

    //   suspend fun readCategories(): List<CategoryItem>
    suspend fun insertCategories(categoriesList: List<CategoryItem>)
}