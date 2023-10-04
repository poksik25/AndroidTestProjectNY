package com.poklad.androidtestprojectny.presenatation.mapper

import com.poklad.androidtestprojectny.domain.model.Category
import com.poklad.androidtestprojectny.presenatation.model.CategoryUiItem
import com.poklad.androidtestprojectny.utils.Mapper
import javax.inject.Inject

class CategoryToCategoryUiItemMapper @Inject constructor() : Mapper<Category, CategoryUiItem> {
    override fun map(data: Category): CategoryUiItem {
        return CategoryUiItem(
            listName = data.listName,
            displayName = data.displayName,
            listNameEncoded = data.listNameEncoded,
            oldestPublishedDate = data.oldestPublishedDate,
            newestPublishedDate = data.newestPublishedDate,
            updated = data.updated
        )
    }
}