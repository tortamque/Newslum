package com.example.newsapp.model.service

import com.example.newsapp.model.models.network.TopNewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    suspend fun getArticlesByCategory(@Query("category") category: String, @Query("country") country: String): TopNewsResponse

    @GET("everything")
    suspend fun getArticlesBySource(@Query("domains") category: String): TopNewsResponse

    @GET("everything")
    suspend fun getArticlesByQuery(@Query("q") query: String): TopNewsResponse
}