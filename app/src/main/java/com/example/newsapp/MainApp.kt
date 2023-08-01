package com.example.newsapp

import android.app.Application
import com.example.newsapp.data.repository.Repository
import com.example.newsapp.network.models.NewsManager
import com.example.newsapp.network.objects.Api

class MainApp: Application() {
    private val manager by lazy {
        NewsManager(Api.retrofitService)
    }

    val repository by lazy {
        Repository(manager)
    }


}