package com.mobile.recfood.network

import com.mobile.recfood.model.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("recipes")
    suspend fun getRecipeList(): ApiResponse
}
