package com.poklad.androidtestprojectny.domain.model

data class Category(
    val listName: String,
    val displayName: String,
    val listNameEncoded: String,
    val oldestPublishedDate: String,
    val newestPublishedDate: String,
    val updated: String
)