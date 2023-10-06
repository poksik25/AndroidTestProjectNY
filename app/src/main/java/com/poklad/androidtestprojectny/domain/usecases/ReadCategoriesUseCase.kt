package com.poklad.androidtestprojectny.domain.usecases

import com.poklad.androidtestprojectny.domain.model.CategoryItem
import com.poklad.androidtestprojectny.domain.repositories.CategoryRepository
import javax.inject.Inject

class ReadCategoriesUseCase @Inject constructor(
    private val repository: CategoryRepository
) : UseCaseSuspend<Unit, List<CategoryItem>> {

    override suspend fun execute(params: Unit): List<CategoryItem> {
        TODO()
    }
}