package com.poklad.androidtestprojectny.domain.repositories

import com.poklad.androidtestprojectny.domain.model.Category

interface CategoryRepository {
    suspend fun getCategories(): List<Category>
}