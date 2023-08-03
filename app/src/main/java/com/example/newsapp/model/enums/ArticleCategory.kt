package com.example.newsapp.model.enums

import com.example.newsapp.model.enums.ArticleCategory.*

enum class ArticleCategory(val categoryName: String, val categoryKey: String){
    BUSINESS("Business", "Business"),
    ENTERTAINMENT("Entertainment", "Entertainment"),
    GENERAL("General", "General"),
    HEALTH("Health", "Health"),
    SCIENCE("Science", "Science"),
    SPORTS("Sports", "Sports"),
    TECHNOLOGY("Technology", "Technology"),
    ALL_NEWS("All news", "")
}

fun getAllCategories(): List<ArticleCategory>{
    return listOf(
        ALL_NEWS,
        BUSINESS,
        ENTERTAINMENT,
        GENERAL,
        HEALTH,
        SCIENCE,
        SPORTS,
        TECHNOLOGY,
    )
}

fun getCategory(name: String): ArticleCategory {
    val map = values().associateBy(ArticleCategory::categoryName)

    return map[name]!!
}