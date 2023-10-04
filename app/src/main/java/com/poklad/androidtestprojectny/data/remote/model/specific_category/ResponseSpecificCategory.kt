package com.poklad.androidtestprojectny.data.remote.model.specific_category

import com.google.gson.annotations.SerializedName

data class ResponseSpecificCategory(
    @SerializedName("results")
    val results: BooksList,
)