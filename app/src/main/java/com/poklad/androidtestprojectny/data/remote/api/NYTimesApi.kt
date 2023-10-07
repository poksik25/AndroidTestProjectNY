package com.poklad.androidtestprojectny.data.remote.api

import com.poklad.androidtestprojectny.data.remote.model.categories.ResponseCategoryList
import com.poklad.androidtestprojectny.data.remote.model.specific_category.ResponseSpecificCategory
import com.poklad.androidtestprojectny.utils.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface NYTimesApi {
    @GET(ApiConstants.GET_ALL_CATEGORIES)
    suspend fun getAllCategories(
    ): ResponseCategoryList

    @GET(ApiConstants.GET_BOOKS_BY_CATEGORY)
    suspend fun getSpecificCategory(
        @Path("category") category: String,
    ): ResponseSpecificCategory
}