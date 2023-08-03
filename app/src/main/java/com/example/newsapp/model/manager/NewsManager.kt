package com.example.newsapp.model.manager

import com.example.newsapp.model.models.network.TopNewsResponse
import com.example.newsapp.model.service.NewsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsManager(
    private val service: NewsService
){
    suspend fun getArticlesByCategory(category: String): TopNewsResponse = withContext(Dispatchers.IO){
        service.getArticlesByCategory(category = category, country = "us")
    }

    suspend fun getArticlesBySource(sourceKey: String): TopNewsResponse = withContext(Dispatchers.IO){
        service.getArticlesBySource(sourceKey)
    }

    suspend fun getArticlesByQuery(query: String): TopNewsResponse = withContext(Dispatchers.IO){
        service.getArticlesByQuery(query)
    }
}