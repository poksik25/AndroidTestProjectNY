package com.poklad.androidtestprojectny.data.remote.mapper

import com.poklad.androidtestprojectny.data.remote.model.categories.ResponseCategory
import com.poklad.androidtestprojectny.domain.model.Category
import com.poklad.androidtestprojectny.utils.Mapper
import javax.inject.Inject

class ResponseCategoryToCategoryMapper @Inject constructor() : Mapper<ResponseCategory, Category> {
    override fun map(data: ResponseCategory): Category {
        return Category(
            listName = data.listName,
            displayName = data.displayName,
            listNameEncoded = data.listNameEncoded,
            oldestPublishedDate = data.oldestPublishedDate,
            newestPublishedDate = data.newestPublishedDate,
            updated = data.updated
        )
    }
}