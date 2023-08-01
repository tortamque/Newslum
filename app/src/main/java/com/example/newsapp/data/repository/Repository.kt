package com.example.newsapp.data.repository

import com.example.newsapp.network.models.NewsManager

class Repository(val manager: NewsManager){
    suspend fun getArticlesByCategory(category: String) = manager.getArticlesByCategory(category)
}