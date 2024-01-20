package com.example.testapp.data.view

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.ApiStatus
import com.example.testapp.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel
@Inject
constructor(private val todoRepository: TodoRepository):ViewModel() {

    val response: MutableState<ApiStatus> = mutableStateOf(ApiStatus.Empty)
    init {
        fetchTodos()
    }
    fun fetchTodos() = viewModelScope.launch {
        todoRepository.getTodo()
            .onStart {
                response.value=ApiStatus.Loading
        }.catch {
            response.value = ApiStatus.Failure(it)
        }.collect{
            response.value = ApiStatus.Success(it)
        }
    }

}