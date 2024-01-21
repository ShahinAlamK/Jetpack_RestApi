package com.example.testapp.data.services

import com.example.testapp.data.models.NewsModel
import com.example.testapp.data.utils.Api
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Api.END_POINT)
    suspend fun fetchNews(
        @Query("q") country: String ="tesla",
        @Query("apiKey") apiKey: String = Api.API_KEY,
    ): NewsModel

}