package com.poklad.androidtestprojectny.domain.usecases

import com.poklad.androidtestprojectny.domain.model.CategoryItem
import com.poklad.androidtestprojectny.domain.repositories.CategoryRepository
import javax.inject.Inject

class InsertCategoriesUseCase @Inject constructor(
    private val repository: CategoryRepository
) : UseCaseSuspend<List<CategoryItem>, Unit> {

    /*   override suspend fun execute(params: List<CategoryItem>) {
        repository.insertCategories(params)
    }*/
    override suspend fun execute(params: List<CategoryItem>) {
        TODO("Not yet implemented")
    }
}