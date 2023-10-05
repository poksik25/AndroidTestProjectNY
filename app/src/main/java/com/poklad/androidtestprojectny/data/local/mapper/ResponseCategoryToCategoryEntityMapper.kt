package com.poklad.androidtestprojectny.data.local.mapper

import com.poklad.androidtestprojectny.data.local.model.CategoryEntity
import com.poklad.androidtestprojectny.data.remote.model.categories.ResponseCategory
import com.poklad.androidtestprojectny.utils.Mapper

class ResponseCategoryToCategoryEntityMapper : Mapper<ResponseCategory, CategoryEntity> {
    override fun map(data: ResponseCategory): CategoryEntity {
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