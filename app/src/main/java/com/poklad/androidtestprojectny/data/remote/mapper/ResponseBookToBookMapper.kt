package com.poklad.androidtestprojectny.data.remote.mapper

import com.poklad.androidtestprojectny.data.remote.model.specific_category.BookResponse
import com.poklad.androidtestprojectny.domain.model.Book
import com.poklad.androidtestprojectny.utils.Mapper
import javax.inject.Inject

class ResponseBookToBookMapper @Inject constructor() : Mapper<BookResponse, Book> {
    override fun map(data: BookResponse): Book {
        return Book(
            title = data.title,
            amazonProductUrl = data.amazonProductUrl,
            author = data.author,
            bookImage = data.bookImage,
            description = data.description,
            price = data.price,
            publisher = data.publisher,
            rank = data.rank
        )
    }
}