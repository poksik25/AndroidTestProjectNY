package com.poklad.androidtestprojectny.domain.model

data class Book(
    val title: String,
    val amazonProductUrl: String,
    val author: String,
    val bookImage: String,
    val description: String,
    val price: String,
    val publisher: String,
    val rank: Int,
)