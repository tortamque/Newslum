package com.example.newsapp.network.models

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.newsapp.data.models.ArticleCategory
import com.example.newsapp.data.models.getCategory
import com.example.newsapp.data.models.repository.TopNewsResponse
import com.example.newsapp.network.objects.Api
import com.example.newsapp.network.services.NewsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsManager(
    private val service: NewsService
){
    val sourceName = mutableStateOf(SourcesEnum.ABCNews)
    private val _getArticleBySource = mutableStateOf(TopNewsResponse())
    val getArticlesBySource: MutableState<TopNewsResponse> = _getArticleBySource

    val query = mutableStateOf("")
    private val _searchNewsResponse = mutableStateOf(TopNewsResponse())
    val searchNewsResponse: MutableState<TopNewsResponse> = _searchNewsResponse

    suspend fun getArticlesByCategory(category: String): TopNewsResponse = withContext(Dispatchers.IO){
        service.getArticlesByCategory(category = category, country = "us")
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

    fun getArticlesByQuery(query: String){
        val service = Api.retrofitService.getArticlesByQuery(query)
        service.enqueue(object: Callback<TopNewsResponse> {
            override fun onResponse(
                call: Call<TopNewsResponse>,
                response: Response<TopNewsResponse>
            ) {
                if(response.isSuccessful){
                    _searchNewsResponse.value = response.body()!!
                    Log.d("Success", _searchNewsResponse.toString())
                } else{
                    Log.d("Error", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<TopNewsResponse>, t: Throwable) {
                Log.d("Error", t.printStackTrace().toString())
            }
        })
    }
}