package com.poklad.androidtestprojectny.data.remote.api

import com.poklad.androidtestprojectny.data.remote.model.ResponseCategoryList
import com.poklad.androidtestprojectny.utils.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTimesApi {
    @GET(ApiConstants.GET_ALL_CATEGORIES)
    suspend fun getAllCategories(
        @Query("api-key") apiKey: String = ApiConstants.API_KEY,
    ): ResponseCategoryList
}