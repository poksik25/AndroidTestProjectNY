package com.poklad.androidtestprojectny.data.remote.model.specific_category

import com.google.gson.annotations.SerializedName

data class BooksList(
    @SerializedName("books")
    val books: List<BookResponse>,
)