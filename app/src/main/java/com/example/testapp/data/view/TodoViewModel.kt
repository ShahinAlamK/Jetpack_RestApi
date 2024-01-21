package com.example.testapp.data.view

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.ApiStatus
import com.example.testapp.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel
@Inject
constructor(private val newsRepository: NewsRepository):ViewModel() {

    val response: MutableState<ApiStatus> = mutableStateOf(ApiStatus.Empty)
    init {
        fetchNews()
    }
    fun fetchNews() = viewModelScope.launch {
        newsRepository.getNews()
            .onStart {
                println("Loading")
                response.value=ApiStatus.Loading
        }.catch {
                println(it.message)
            response.value = ApiStatus.Failure(it)
        }.collect{
            response.value = ApiStatus.Success(it)
        }
    }

}