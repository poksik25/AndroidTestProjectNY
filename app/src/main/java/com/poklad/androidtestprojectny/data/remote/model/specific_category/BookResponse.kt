package com.poklad.androidtestprojectny.data.remote.model.specific_category

import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("amazon_product_url")
    val amazonProductUrl: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("book_image")
    val bookImage: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("rank")
    val rank: Int,
)