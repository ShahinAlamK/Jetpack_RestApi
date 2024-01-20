package com.example.testapp.data.repository

import com.example.testapp.data.models.TodoModel
import com.example.testapp.data.services.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TodoRepository @Inject constructor(private val apiService: ApiService) {
    fun getTodo():Flow<List<TodoModel>> = flow {
        emit(apiService.fetchTodo())
    }.flowOn(Dispatchers.IO)
}