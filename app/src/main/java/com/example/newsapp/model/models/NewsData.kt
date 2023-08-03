package com.example.newsapp.model.models

import com.example.newsapp.R

data class NewsData(
    val id: Int,
    val imageId: Int = R.drawable.breaking_news,
    val author: String,
    val title: String,
    val description: String,
    val publishedAt: String
)