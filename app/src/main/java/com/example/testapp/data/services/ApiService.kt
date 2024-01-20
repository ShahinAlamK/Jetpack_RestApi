package com.example.testapp.data.services

import com.example.testapp.data.models.TodoModel
import com.example.testapp.data.utils.Api
import retrofit2.http.GET

interface ApiService {
    @GET(Api.END_POINT)
    suspend fun fetchTodo():List<TodoModel>

}