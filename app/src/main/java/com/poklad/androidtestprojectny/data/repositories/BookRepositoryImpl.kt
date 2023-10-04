package com.poklad.androidtestprojectny.data.repositories

import com.poklad.androidtestprojectny.data.remote.api.NYTimesApi
import com.poklad.androidtestprojectny.data.remote.mapper.ResponseBookToBookMapper
import com.poklad.androidtestprojectny.di.annotations.ApplicationScope
import com.poklad.androidtestprojectny.domain.model.Book
import com.poklad.androidtestprojectny.domain.repositories.BooksRepository
import javax.inject.Inject

@ApplicationScope
class BookRepositoryImpl @Inject constructor(
    private val mapper: ResponseBookToBookMapper,
    private val api: NYTimesApi
) : BooksRepository {
    override suspend fun getBookBySpecificCategories(categoryName: String): List<Book> {
        return api.getSpecificCategory(categoryName).results.books.map(mapper::map)
    }
}