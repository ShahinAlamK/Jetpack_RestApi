package com.example.testapp.data.di

import com.example.testapp.data.services.ApiService
import com.example.testapp.data.utils.Api
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesMoshi():Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun providesApiService(moshi: Moshi):ApiService = Retrofit.Builder().run {
        baseUrl(Api.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
        build()
    }.create(ApiService::class.java)
}