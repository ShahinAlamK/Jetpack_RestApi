package com.example.testapp.data

import com.example.testapp.data.models.Article

sealed class ApiStatus {
    class Success(val data: List<Article>):ApiStatus()
    class Failure(val msg:Throwable):ApiStatus()
    object Loading:ApiStatus()
    object Empty:ApiStatus()
}

sealed class AppStatus<T>(val data:T?=null, val msg: String?=null){
    class Success<T>(data: T?):AppStatus<T>(data=data)
    class Error<T>(msg: String?):AppStatus<T>(msg=msg)
}