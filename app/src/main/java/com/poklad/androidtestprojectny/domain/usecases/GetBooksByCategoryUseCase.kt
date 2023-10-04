package com.poklad.androidtestprojectny.domain.usecases

import com.poklad.androidtestprojectny.domain.model.Book
import com.poklad.androidtestprojectny.domain.repositories.BooksRepository
import javax.inject.Inject

class GetBooksByCategoryUseCase @Inject constructor(
    private val booksRepository: BooksRepository
) : UseCaseSuspend<String, List<Book>> {
    override suspend fun execute(params: String): List<Book> {
        return booksRepository.getBookBySpecificCategories(params)
    }
}