package com.poklad.androidtestprojectny.data.repositories

import com.poklad.androidtestprojectny.data.local.dao.CategoryDao
import com.poklad.androidtestprojectny.data.local.mapper.CategoryEntityToCategoryItemMapper
import com.poklad.androidtestprojectny.data.remote.api.NYTimesApi
import com.poklad.androidtestprojectny.data.remote.mapper.ResponseCategoryToCategoryMapper
import com.poklad.androidtestprojectny.di.annotations.ApplicationScope
import com.poklad.androidtestprojectny.domain.model.Category
import com.poklad.androidtestprojectny.domain.repositories.CategoryRepository
import com.poklad.androidtestprojectny.utils.extensions.log
import com.poklad.androidtestprojectny.utils.extensions.logError
import java.io.IOException
import javax.inject.Inject

@ApplicationScope
class CategoryRepositoryImpl @Inject constructor(
    private val nyTimesApi: NYTimesApi,
    private val mapper: ResponseCategoryToCategoryMapper,
    private val categoryEntityToCategoryItemMapper: CategoryEntityToCategoryItemMapper,
    private val categoryDao: CategoryDao
) : CategoryRepository {
    override suspend fun getCategories(): List<Category> {
        val listCategory = try {
            nyTimesApi.getAllCategories().results.map(mapper::map)
        } catch (e: IOException) {
            logError(e.message.toString())
            null
        }
        if (listCategory != null) {
            categoryDao.insertCategories(listCategory.map(categoryEntityToCategoryItemMapper::mapToEntity))
        }
        return listCategory ?: categoryDao.readAllCategories()
            ?.map(categoryEntityToCategoryItemMapper::map) ?: emptyList()
    }
}