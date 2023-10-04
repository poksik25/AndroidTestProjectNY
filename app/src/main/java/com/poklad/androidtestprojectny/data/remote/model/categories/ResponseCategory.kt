package com.poklad.androidtestprojectny.data.remote.model.categories

import com.google.gson.annotations.SerializedName

data class ResponseCategoryList(
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val results: List<ResponseCategory>,
)

data class ResponseCategory(
    @SerializedName("list_name")
    val listName: String,
    @SerializedName("display_name")
    val displayName: String,
    @SerializedName("list_name_encoded")
    val listNameEncoded: String,
    @SerializedName("oldest_published_date")
    val oldestPublishedDate: String,
    @SerializedName("newest_published_date")
    val newestPublishedDate: String,
    @SerializedName("updated")
    val updated: String
)