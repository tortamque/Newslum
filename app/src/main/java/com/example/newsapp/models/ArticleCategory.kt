package com.example.newsapp.models

import com.example.newsapp.models.ArticleCategory.*

enum class ArticleCategory(val categoryName: String){
    BUSINESS("business"),
    ENTERTAINMENT("entertainment"),
    GENERAL("general"),
    HEALTH("health"),
    SCIENCE("science"),
    SPORTS("sports"),
    TECHNOLOGY("technology")
}

fun getAllCategories(): List<ArticleCategory>{
    return listOf(
        BUSINESS,
        ENTERTAINMENT,
        GENERAL,
        HEALTH,
        SCIENCE,
        SPORTS,
        TECHNOLOGY,
    )
}

fun getCategory(name: String): ArticleCategory?{
    val map = values().associateBy(ArticleCategory::categoryName)

    return map[name]
}