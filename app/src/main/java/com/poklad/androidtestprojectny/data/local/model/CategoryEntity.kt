package com.poklad.androidtestprojectny.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
class CategoryEntity(
    @PrimaryKey
    @ColumnInfo("list_name")
    val listName: String,
    @ColumnInfo("display_name")
    val displayName: String,
    @ColumnInfo("list_name_encoded")
    val listNameEncoded: String,
    @ColumnInfo("oldest_published_date")
    val oldestPublishedDate: String,
    @ColumnInfo("newest_published_date")
    val newestPublishedDate: String,
    @ColumnInfo("updated")
    val updated: String
)