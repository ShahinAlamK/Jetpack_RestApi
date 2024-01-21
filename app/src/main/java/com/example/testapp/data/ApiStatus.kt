package com.example.testapp.data

import com.example.testapp.data.models.NewsModel

sealed class ApiStatus {
    class Success(val data: NewsModel):ApiStatus()
    class Failure(val msg:Throwable):ApiStatus()
    object Loading:ApiStatus()
    object Empty:ApiStatus()
}
