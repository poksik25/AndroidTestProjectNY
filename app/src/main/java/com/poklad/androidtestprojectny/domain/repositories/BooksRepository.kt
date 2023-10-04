package com.poklad.androidtestprojectny.domain.repositories

import com.poklad.androidtestprojectny.domain.model.Book

interface BooksRepository {
    suspend fun getBookBySpecificCategories(categoryName: String): List<Book>

}