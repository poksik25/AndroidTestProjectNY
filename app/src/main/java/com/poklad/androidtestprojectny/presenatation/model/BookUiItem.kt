package com.poklad.androidtestprojectny.presenatation.model

data class BookUiItem(
    val title: String,
    val amazonProductUrl: String,
    val author: String,
    val bookImage: String,
    val description: String,
    val price: String,
    val publisher: String,
    val rank: Int
)