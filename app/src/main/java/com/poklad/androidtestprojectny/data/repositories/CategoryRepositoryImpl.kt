package com.poklad.androidtestprojectny.data.repositories

import com.poklad.androidtestprojectny.data.local.dao.CategoryDao
import com.poklad.androidtestprojectny.data.local.mapper.CategoryEntityToCategoryItemMapper
import com.poklad.androidtestprojectny.data.remote.api.NYTimesApi
import com.poklad.androidtestprojectny.data.remote.mapper.ResponseCategoryToCategoryMapper
import com.poklad.androidtestprojectny.di.annotations.ApplicationScope
import com.poklad.androidtestprojectny.domain.model.CategoryItem
import com.poklad.androidtestprojectny.domain.repositories.CategoryRepository
import javax.inject.Inject

@ApplicationScope
class CategoryRepositoryImpl @Inject constructor(
    private val nyTimesApi: NYTimesApi,
    private val mapper: ResponseCategoryToCategoryMapper,
    private val dao: CategoryDao,
    private val mapperDb: CategoryEntityToCategoryItemMapper
) : CategoryRepository {
    override suspend fun getCategories(): List<CategoryItem> {
        return try {
            val networkCategories = nyTimesApi.getAllCategories().results.map(mapper::map)/*try {*/
            insertCategories(networkCategories)
            networkCategories
        } catch (e: Exception) {
            e.printStackTrace()
            dao.readAllCategories().map(mapperDb::map)
        }
    }

    /* override suspend fun readCategories(): List<CategoryItem> {
            return dao.readAllCategories().map(mapperDb::map)
        }*/

    override suspend fun insertCategories(categoriesList: List<CategoryItem>) {
        val entities = categoriesList.map { mapperDb.mapToEntity(it) }
        dao.insertCategories(entities)
    }
}