package com.example.newsapp.network.models

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.newsapp.models.ArticleCategory
import com.example.newsapp.models.getCategory
import com.example.newsapp.models.repository.TopNewsResponse
import com.example.newsapp.network.objects.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsManager {
    private val _getArticleByCategory = mutableStateOf(TopNewsResponse())
    val getArticlesByCategory: MutableState<TopNewsResponse> = _getArticleByCategory

    val selectedCategory: MutableState<ArticleCategory> = mutableStateOf(ArticleCategory.ALL_NEWS)

    val sourceName = mutableStateOf(SourcesEnum.ABCNews)
    private val _getArticleBySource = mutableStateOf(TopNewsResponse())
    val getArticlesBySource: MutableState<TopNewsResponse> = _getArticleBySource

    init {
        getArticlesByCategory(selectedCategory.value.categoryKey)
    }

    fun getArticlesByCategory(category: String){
        val service = Api.retrofitService.getArticlesByCategory(category, "us")
        service.enqueue(object: Callback<TopNewsResponse> {
            override fun onResponse(
                call: Call<TopNewsResponse>,
                response: Response<TopNewsResponse>
            ) {
                if(response.isSuccessful){
                    _getArticleByCategory.value = response.body()!!
                } else{
                    Log.d("Error", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<TopNewsResponse>, t: Throwable) {
                Log.d("Error", t.printStackTrace().toString())
            }
        })
    }

    fun getArticlesBySource(){
        val service = Api.retrofitService.getArticlesBySource(sourceName.value.sourceKey)
        service.enqueue(object: Callback<TopNewsResponse> {
            override fun onResponse(
                call: Call<TopNewsResponse>,
                response: Response<TopNewsResponse>
            ) {
                if(response.isSuccessful){
                    _getArticleBySource.value = response.body()!!
                } else{
                    Log.d("Error", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<TopNewsResponse>, t: Throwable) {
                Log.d("Error", t.printStackTrace().toString())
            }
        })
    }

    fun onSelectedCategoryChanged(category: ArticleCategory){
        val newCategory = getCategory(category.categoryName)
        selectedCategory.value = newCategory
    }
}