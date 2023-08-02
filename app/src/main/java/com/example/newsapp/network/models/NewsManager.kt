package com.example.newsapp.network.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.newsapp.data.models.repository.TopNewsResponse
import com.example.newsapp.network.services.NewsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsManager(
    private val service: NewsService
){
    val sourceName = mutableStateOf(SourcesEnum.NBCNews)
    private val _getArticleBySource = mutableStateOf(TopNewsResponse())
    val getArticlesBySource: MutableState<TopNewsResponse> = _getArticleBySource

    val query = mutableStateOf("")
    private val _searchNewsResponse = mutableStateOf(TopNewsResponse())
    val searchNewsResponse: MutableState<TopNewsResponse> = _searchNewsResponse

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