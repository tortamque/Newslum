package com.example.newsapp.network.services

import com.example.newsapp.models.repository.TopNewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    fun getArticlesByCategory(@Query("category") category: String, @Query("country") country: String): Call<TopNewsResponse>

    @GET("everything")
    fun getArticlesBySource(@Query("source") category: String, @Query("country") country: String): Call<TopNewsResponse>
}