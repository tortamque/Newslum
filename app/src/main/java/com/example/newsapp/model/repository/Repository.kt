package com.example.newsapp.model.repository

import com.example.newsapp.model.manager.NewsManager

class Repository(val manager: NewsManager){
    suspend fun getArticlesByCategory(category: String) = manager.getArticlesByCategory(category)
    suspend fun getArticlesBySource(source: String) = manager.getArticlesBySource(source)
    suspend fun getArticlesByQuery(query: String) = manager.getArticlesByQuery(query)
}