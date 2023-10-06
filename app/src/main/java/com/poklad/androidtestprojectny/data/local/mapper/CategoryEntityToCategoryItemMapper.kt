package com.poklad.androidtestprojectny.data.local.mapper

import com.poklad.androidtestprojectny.data.local.model.CategoryEntity
import com.poklad.androidtestprojectny.domain.model.CategoryItem
import com.poklad.androidtestprojectny.utils.Mapper
import javax.inject.Inject

class CategoryEntityToCategoryItemMapper @Inject constructor() : Mapper<CategoryEntity, CategoryItem> {
    override fun map(data: CategoryEntity): CategoryItem {
        return CategoryItem(
            listName = data.listName,
            displayName = data.displayName,
            listNameEncoded = data.listNameEncoded,
            oldestPublishedDate = data.oldestPublishedDate,
            newestPublishedDate = data.newestPublishedDate,
            updated = data.updated
        )
    }

    fun mapToEntity(data: CategoryItem): CategoryEntity {
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