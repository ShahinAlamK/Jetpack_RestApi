package com.example.testapp.data

import com.example.testapp.data.models.TodoModel

sealed class ApiStatus {
    class Success(val data:List<TodoModel>):ApiStatus()
    class Failure(val msg:Throwable):ApiStatus()
    object Loading:ApiStatus()
    object Empty:ApiStatus()
}