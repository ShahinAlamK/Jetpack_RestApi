package com.example.testapp.data.services

import com.example.testapp.data.models.Article
import com.example.testapp.data.models.NewsModel
import com.example.testapp.data.utils.Api
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Api.END_POINT)
    suspend fun fetchNews(
        @Query("category") category: String ="business",
        @Query("country") country: String ="us",
        @Query("apiKey") apiKey: String = Api.API_KEY,
    ): List<Article>

}