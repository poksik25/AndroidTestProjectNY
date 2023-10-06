package com.poklad.androidtestprojectny.data.remote.mapper

import com.poklad.androidtestprojectny.data.remote.model.categories.ResponseCategory
import com.poklad.androidtestprojectny.domain.model.CategoryItem
import com.poklad.androidtestprojectny.utils.Mapper
import javax.inject.Inject

class ResponseCategoryToCategoryMapper @Inject constructor() : Mapper<ResponseCategory, CategoryItem> {
    override fun map(data: ResponseCategory): CategoryItem {
        return CategoryItem(
            listName = data.listName,
            displayName = data.displayName,
            listNameEncoded = data.listNameEncoded,
            oldestPublishedDate = data.oldestPublishedDate,
            newestPublishedDate = data.newestPublishedDate,
            updated = data.updated
        )
    }
}