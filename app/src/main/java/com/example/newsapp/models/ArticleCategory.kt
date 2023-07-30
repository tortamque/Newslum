package com.example.newsapp.models

import com.example.newsapp.models.ArticleCategory.*

enum class ArticleCategory(val categoryName: String){
    BUSINESS("Business"),
    ENTERTAINMENT("Entertainment"),
    GENERAL("General"),
    HEALTH("Health"),
    SCIENCE("Science"),
    SPORTS("Sports"),
    TECHNOLOGY("Technology")
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