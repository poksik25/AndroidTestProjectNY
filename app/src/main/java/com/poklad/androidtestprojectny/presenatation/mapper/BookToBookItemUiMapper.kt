package com.poklad.androidtestprojectny.presenatation.mapper

import com.poklad.androidtestprojectny.domain.model.Book
import com.poklad.androidtestprojectny.presenatation.model.BookUiItem
import com.poklad.androidtestprojectny.utils.Mapper
import javax.inject.Inject

class BookToBookItemUiMapper @Inject constructor() : Mapper<Book, BookUiItem> {
    override fun map(data: Book): BookUiItem {
        return BookUiItem(
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