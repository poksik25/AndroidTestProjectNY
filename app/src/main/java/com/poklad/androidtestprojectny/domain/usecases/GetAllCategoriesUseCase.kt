package com.poklad.androidtestprojectny.domain.usecases

import com.poklad.androidtestprojectny.domain.model.Category
import com.poklad.androidtestprojectny.domain.repositories.CategoryRepository
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(
    private val repository: CategoryRepository
) : UseCaseSuspend<Unit, List<Category>> {
    override suspend fun execute(params: Unit): List<Category> {
        return repository.getCategories()
    }
}