package com.poklad.androidtestprojectny.data.repositories

import com.poklad.androidtestprojectny.data.remote.api.NYTimesApi
import com.poklad.androidtestprojectny.data.remote.mapper.ResponseCategoryToCategoryMapper
import com.poklad.androidtestprojectny.di.annotations.ApplicationScope
import com.poklad.androidtestprojectny.domain.model.Category
import com.poklad.androidtestprojectny.domain.repositories.CategoryRepository
import javax.inject.Inject

@ApplicationScope
class CategoryRepositoryImpl @Inject constructor(
    private val nyTimesApi: NYTimesApi,
    private val mapper: ResponseCategoryToCategoryMapper
) : CategoryRepository {
    override suspend fun getCategories(): List<Category> {
        return nyTimesApi.getAllCategories().results.map(mapper::map)
    }
}