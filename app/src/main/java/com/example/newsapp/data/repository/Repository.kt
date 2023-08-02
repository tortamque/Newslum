package com.example.newsapp.data.repository

import com.example.newsapp.network.models.NewsManager

class Repository(val manager: NewsManager){
    suspend fun getArticlesByCategory(category: String) = manager.getArticlesByCategory(category)
    suspend fun getArticlesBySource(source: String) = manager.getArticlesBySource(source)
    suspend fun getArticlesByQuery(query: String) = manager.getArticlesByQuery(query)
}