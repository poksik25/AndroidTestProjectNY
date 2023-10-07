package com.poklad.androidtestprojectny.data.local.mapper

import com.poklad.androidtestprojectny.data.local.model.CategoryEntity
import com.poklad.androidtestprojectny.domain.model.Category
import com.poklad.androidtestprojectny.utils.Mapper
import javax.inject.Inject

class CategoryEntityToCategoryItemMapper @Inject constructor() : Mapper<CategoryEntity, Category> {
    override fun map(data: CategoryEntity): Category {
        return Category(
            listName = data.listName,
            displayName = data.displayName,
            listNameEncoded = data.listNameEncoded,
            oldestPublishedDate = data.oldestPublishedDate,
            newestPublishedDate = data.newestPublishedDate,
            updated = data.updated
        )
    }

    fun mapToEntity(data: Category): CategoryEntity {
        return CategoryEntity(
            listName = data.listName,
            displayName = data.displayName,
            listNameEncoded = data.listNameEncoded,
            oldestPublishedDate = data.oldestPublishedDate,
            newestPublishedDate = data.newestPublishedDate,
            updated = data.updated
        )
    }
}