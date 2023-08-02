package com.example.newsapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.MainApp
import com.example.newsapp.data.models.ArticleCategory
import com.example.newsapp.data.models.getCategory
import com.example.newsapp.data.models.repository.TopNewsResponse
import com.example.newsapp.network.models.SourcesEnum
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val repository = getApplication<MainApp>().repository

    // Category
    private val _selectedCategory = MutableStateFlow(ArticleCategory.ALL_NEWS)
    val selectedCategory: StateFlow<ArticleCategory>
        get() = _selectedCategory

    private val _categoryNewsResponse = MutableStateFlow(TopNewsResponse())
    val categoryNewsResponse: StateFlow<TopNewsResponse>
        get() = _categoryNewsResponse

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun getArticlesByCategory(category: String){
        _isLoading.value = true

        viewModelScope.launch(Dispatchers.IO){
            _categoryNewsResponse.value = repository.getArticlesByCategory(category)
            _isLoading.value = false
        }
    }

    fun onSelectedCategoryChanged(category: ArticleCategory){
        val newCategory = getCategory(category.categoryName)
        _selectedCategory.value = newCategory
    }

    // Source
    val sourceName = MutableStateFlow(SourcesEnum.NBCNews)
    private val _sourceNewsResponse = MutableStateFlow(TopNewsResponse())
    val sourceNewsResponse: StateFlow<TopNewsResponse>
        get() = _sourceNewsResponse

    fun getArticlesBySource(){
        _isLoading.value = true

        viewModelScope.launch(Dispatchers.IO){
            _sourceNewsResponse.value = repository.getArticlesBySource(sourceName.value.sourceKey)
            _isLoading.value = false
        }
    }


    // Query
    val query = MutableStateFlow("")
    private val _queryNewsResponse = MutableStateFlow(TopNewsResponse())
    val queryNewsResponse: StateFlow<TopNewsResponse>
        get() = _queryNewsResponse

    fun getArticlesByQuery(query: String){
        _isLoading.value = true

        viewModelScope.launch(Dispatchers.IO){
            _queryNewsResponse.value = repository.getArticlesByQuery(query)
            _isLoading.value = false
        }
    }
}