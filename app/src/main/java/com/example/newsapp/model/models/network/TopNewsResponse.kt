package com.example.newsapp.model.models.network

data class TopNewsResponse(
    val status: String? = null,
    val totalResults: Int? = null,
    val articles: List<TopNewsArticle>? = null,
)
