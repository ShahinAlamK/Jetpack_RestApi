package com.example.testapp.data.repository
import com.example.testapp.data.models.NewsModel
import com.example.testapp.data.services.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: ApiService) {
    fun getNews(): Flow<NewsModel> = flow {
        emit(apiService.fetchNews())
    }.flowOn(Dispatchers.IO)
}